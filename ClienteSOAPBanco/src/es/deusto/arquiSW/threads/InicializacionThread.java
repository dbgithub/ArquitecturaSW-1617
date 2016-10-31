package es.deusto.arquiSW.threads;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.axis2.AxisFault;
import es.deusto.arquiSW.SOAP.DeustoBankServiceStub;
import es.deusto.arquiSW.SOAP.ObtenerClientes;
import es.deusto.arquiSW.SOAP.ObtenerClientesResponse;
import es.deusto.arquiSW.SOAP.ObtenerCuentas;
import es.deusto.arquiSW.SOAP.ObtenerCuentasResponse;
import es.deusto.arquiSW.SOAP.ObtenerOperacion;
import es.deusto.arquiSW.SOAP.ObtenerOperacionResponse;
import es.deusto.arquiSW.SOAP.ObtenerOperaciones;
import es.deusto.arquiSW.SOAP.ObtenerOperacionesResponse;
import es.deusto.arquiSW.SOAP.ObtenerTarjetas;
import es.deusto.arquiSW.SOAP.ObtenerTarjetasResponse;
import es.deusto.arquiSW.SOAP.classes.xsd.Cliente;
import es.deusto.arquiSW.SOAP.classes.xsd.Cuenta;
import es.deusto.arquiSW.SOAP.classes.xsd.Operacion;
import es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta;
import es.deusto.arquiSW.SOAP.gui.Mainwindow;
import es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.EnumTipoOperacion;

/**
 * Clase runnable que ejecuta una serie de instrucciones y metodos relacionados
 * con las peticiones al servicio web SOAP y la carga de los datos en las
 * correspondientes tablas en el lado cliente. La intencion es liberar de
 * recursos al hilo principal que es la UI.
 * 
 * @author aitor & daniel
 *
 */
public class InicializacionThread implements Runnable {

	Mainwindow mw; // una referencia a la clase Mainwinow.java
	DeustoBankServiceStub service; // variable temporal que hace uso del
									// servicio web SOAP
	boolean stop = false; // booleano que detiene el Thread cuando ha realizado
							// su cometido

	public InicializacionThread(Mainwindow window) {
		try {
			mw = window;
			service = new DeustoBankServiceStub("http://localhost:8080/axis2/services/DeustoBankService");
		} catch (AxisFault e) {
			System.out.println("[InicializacionThreat] Error a la hora de instanciar el servicio:");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (!stop) {

			// Declaracion de atributos a utilizar de cara al servicio:
			Cliente[] arrayClientes;
			Cuenta[] arrayCuentas;
			Tarjeta[] arrayTarjetas;
			Operacion[] arrayOperacion;
			ObtenerClientes obtClientes;
			ObtenerCuentas obtCuentas;
			ObtenerTarjetas obtTarjetas;
			ObtenerOperacion obtOperacion;
			ObtenerClientesResponse obtClientesRes;
			ObtenerCuentasResponse obtCuentasRes;
			ObtenerTarjetasResponse obtTarjetasRes;
			ObtenerOperacionResponse obtOperacionRes;
			boolean bolClientes = false;
			boolean bolCuentas = false;
			boolean bolTarjetas = false;

			// Instanciacion de los atributos a utilizar de cara al servicio:
			obtClientes = new ObtenerClientes();
			obtCuentas = new ObtenerCuentas();
			obtTarjetas = new ObtenerTarjetas();
			obtOperacion = new ObtenerOperacion();

			// Llamadas a metodos del servicio:
			// Obtener todos los clientes:
			try {
				obtClientesRes = service.obtenerClientes(obtClientes);
				arrayClientes = obtClientesRes.get_return();
				mw.setTempClientes(convertFromSOAPclienteToJAXBcliente(arrayClientes));
				mw.loadClientes();
				System.out.println("[InicializacionThreat] coleccion de clientes obtenida y añadida con exito! :)");
				bolClientes = true;
			} catch (RemoteException e) {
				System.out.println("[InicializacionThreat] Error en 'obtenerClientes'");
				e.printStackTrace();
			}
			// Obtener todas las cuentas + sus operaciones
			try {
				// En relacion a cuentas:
				obtCuentasRes = service.obtenerCuentas(obtCuentas);
				arrayCuentas = obtCuentasRes.get_return();
				System.out.println("arrayCuentas: " + arrayCuentas[0].getIBAN());
				// En relacion a operaciones:
				for (Cuenta cu : arrayCuentas) {
					obtOperacion.setIBAN(Integer.toString(cu.getIBAN()));
					obtOperacionRes = service.obtenerOperacion(obtOperacion);
					arrayOperacion = obtOperacionRes.get_return();
					cu.setOperaciones(arrayOperacion);
				}		
				mw.setTempCuentas(convertFromSOAPcuentaToJAXBcuenta(arrayCuentas));
				mw.loadCuentas();
				System.out.println("[InicializacionThreat] coleccion de cuentas obtenida y añadida con exito! :)");
				bolCuentas = true;
			} catch (RemoteException e) {
				System.out.println("[InicializacionThreat] Error en 'obtenerCuentas'");
				e.printStackTrace();
			}
			// // Obtener todas las tarjetas:
			try {
				obtTarjetasRes = service.obtenerTarjetas(obtTarjetas);
				arrayTarjetas = obtTarjetasRes.get_return();
				mw.setTempTarjetas(convertFromSOAPtarjetaToJAXBtarjeta(arrayTarjetas));
				mw.loadTarjetas();
				System.out.println("[InicializacionThreat] coleccion de tarjetas obtenida y añadida con exito! :)");
				bolTarjetas = true;
			} catch (RemoteException e) {
				System.out.println("[InicializacionThreat] Error en 'obtenerTarjetas'");
				e.printStackTrace();
			}

			// Paramos el Thread:
			if (bolClientes && bolCuentas && bolTarjetas) {
				stop = true;
			}

			// Pasamos la instanciacion del servicio web SOAP al hilo principal
			// (mas que nada para no tener que instanciarla en el hilo principal
			// de nuevo):
			mw.setSOAPservice(service);

		}
		System.out.println("[InicializacionThreat] Bucle WHILE parado. Thread terminado! :)");

	}

	// Metodos 'util' que convierten clases del tipo que el servicio web SOAP
	// declara a clases del tipo JAXB definidas por el lado cliente:

	/**
	 * Convierte del tipo Cliente de SOAP al tipo Cliente de JAXB
	 * 
	 * @param clientes
	 * @return
	 */
	private es.deusto.arquiSW.JAXB.classes.Cliente[] convertFromSOAPclienteToJAXBcliente(Cliente[] clientes) {

		es.deusto.arquiSW.JAXB.classes.Cliente[] colleccion = new es.deusto.arquiSW.JAXB.classes.Cliente[clientes.length];

		for (int i = 0; i < clientes.length; i++) {

			colleccion[i] = new es.deusto.arquiSW.JAXB.classes.Cliente(clientes[i].getDNI(), clientes[i].getNombre(),
					clientes[i].getApellidos(), clientes[i].getDireccion(), clientes[i].getEmail(),
					clientes[i].getMovil(), clientes[i].getEmpleado(), clientes[i].getPIN());
		}
		return colleccion;
	}

	/**
	 * Convierte del tipo Cuenta de SOAP al tipo Cuenta de JAXB
	 * 
	 * @param cuentas
	 * @return
	 */
	private es.deusto.arquiSW.JAXB.classes.Cuenta[] convertFromSOAPcuentaToJAXBcuenta(Cuenta[] cuentas) {
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Cuenta> tempcoleccion = new
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Cuenta>();
		// for (Cuenta c : cuentas) {
		// es.deusto.arquiSW.JAXB.classes.Operacion[] operaciones =
		// convertFromSOAPoperacionToJAXBoperacion(
		// c.getOperaciones());
		// tempcoleccion.add(new
		// es.deusto.arquiSW.JAXB.classes.Cuenta(c.getIBAN(), c.getSWIFT(),
		// c.getFechaApertura(),
		// c.getActiva(), c.getSaldoActual(), c.getInteres(),
		// c.getTitular().getDNI(),
		// new
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Operacion>(Arrays.asList(operaciones))));
		// }
		// return (es.deusto.arquiSW.JAXB.classes.Cuenta[])
		// tempcoleccion.toArray();
		es.deusto.arquiSW.JAXB.classes.Cuenta[] colleccion = new es.deusto.arquiSW.JAXB.classes.Cuenta[cuentas.length];
		for (int i = 0; i < cuentas.length; i++) {
			es.deusto.arquiSW.JAXB.classes.Operacion[] operaciones = convertFromSOAPoperacionToJAXBoperacion(
					cuentas[i].getOperaciones());
			colleccion[i] = new es.deusto.arquiSW.JAXB.classes.Cuenta(cuentas[i].getIBAN(), cuentas[i].getSWIFT(),
					cuentas[i].getFechaApertura(), cuentas[i].getActiva(), cuentas[i].getSaldoActual(),
					cuentas[i].getInteres(), cuentas[i].getTitular().getDNI(),
					new ArrayList<es.deusto.arquiSW.JAXB.classes.Operacion>(Arrays.asList(operaciones)));
			
		}
		return colleccion;

	}

	/**
	 * Convierte del tipo Operacion de SOAP al tipo Operacion de JAXB
	 * 
	 * @param operaciones
	 * @return
	 */
	private es.deusto.arquiSW.JAXB.classes.Operacion[] convertFromSOAPoperacionToJAXBoperacion(
			es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] operaciones) {
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Operacion> tempcoleccion =
		// new ArrayList<es.deusto.arquiSW.JAXB.classes.Operacion>();
		// for (Operacion o : operaciones) {
		// tempcoleccion.add(new
		// es.deusto.arquiSW.JAXB.classes.Operacion(o.getId(), o.getFecha(),
		// es.deusto.arquiSW.JAXB.classes.Operacion.EnumTipoOperacion.valueOf(o.getTipo().getValue()),
		// o.getImporte(), o.getCuenta().getIBAN()));
		// }
		// return (es.deusto.arquiSW.JAXB.classes.Operacion[])
		// tempcoleccion.toArray();

		es.deusto.arquiSW.JAXB.classes.Operacion[] colleccion = new es.deusto.arquiSW.JAXB.classes.Operacion[operaciones.length];

		for (int i = 0; i < operaciones.length; i++) {

			colleccion[i] = new es.deusto.arquiSW.JAXB.classes.Operacion(operaciones[i].getId(),
					operaciones[i].getFecha(),
					es.deusto.arquiSW.JAXB.classes.Operacion.EnumTipoOperacion
							.valueOf(operaciones[i].getTipo().getValue()),
					operaciones[i].getImporte(), operaciones[i].getCuenta().getIBAN());
		}
		return colleccion;

	}

	/**
	 * Convierte del tipo Tarjeta de SOAP al tipo Tarjeta de JAXB
	 * 
	 * @param tarjetas
	 * @return
	 */
	private es.deusto.arquiSW.JAXB.classes.Tarjeta[] convertFromSOAPtarjetaToJAXBtarjeta(Tarjeta[] tarjetas) {
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Tarjeta> tempcoleccion = new
		// ArrayList<es.deusto.arquiSW.JAXB.classes.Tarjeta>();
		// for (Tarjeta t : tarjetas) {
		// tempcoleccion.add(new
		// es.deusto.arquiSW.JAXB.classes.Tarjeta(t.getNumero(),
		// t.getCuenta().getIBAN(),
		// t.getLimiteExtraccion(), t.getFechaCaducidad(),
		// es.deusto.arquiSW.JAXB.classes.Tarjeta.EnumProveedores.valueOf(t.getProveedor().getValue()),
		// es.deusto.arquiSW.JAXB.classes.Tarjeta.TiposTarjeta.valueOf(t.getTipo().getValue()),
		// t.getFechaExpedicion()));
		// }
		// return (es.deusto.arquiSW.JAXB.classes.Tarjeta[])
		// tempcoleccion.toArray();
		es.deusto.arquiSW.JAXB.classes.Tarjeta[] colleccion = new es.deusto.arquiSW.JAXB.classes.Tarjeta[tarjetas.length];

		for (int i = 0; i < tarjetas.length; i++) {

			colleccion[i] = new es.deusto.arquiSW.JAXB.classes.Tarjeta(tarjetas[i].getNumero(),
					tarjetas[i].getCuenta().getIBAN(),
					tarjetas[i].getLimiteExtraccion(), tarjetas[i].getFechaCaducidad(),
					 es.deusto.arquiSW.JAXB.classes.Tarjeta.EnumProveedores.valueOf(tarjetas[i].getProveedor().getValue()),
					 es.deusto.arquiSW.JAXB.classes.Tarjeta.TiposTarjeta.valueOf(tarjetas[i].getTipo().getValue()),
					 tarjetas[i].getFechaExpedicion());
		}
		return colleccion;

	}
	
	

}
