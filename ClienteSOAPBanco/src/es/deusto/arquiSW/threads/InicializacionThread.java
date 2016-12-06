package es.deusto.arquiSW.threads;

import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import es.deusto.arquiSW.JAXB.util.ConversorSOAPtoJAXB;
import es.deusto.arquiSW.SOAP.DeustoBankServiceStub;
import es.deusto.arquiSW.SOAP.ObtenerClientes;
import es.deusto.arquiSW.SOAP.ObtenerClientesResponse;
import es.deusto.arquiSW.SOAP.ObtenerCuentas;
import es.deusto.arquiSW.SOAP.ObtenerCuentasResponse;
import es.deusto.arquiSW.SOAP.ObtenerOperacion;
import es.deusto.arquiSW.SOAP.ObtenerOperacionResponse;
import es.deusto.arquiSW.SOAP.ObtenerTarjetas;
import es.deusto.arquiSW.SOAP.ObtenerTarjetasResponse;
import es.deusto.arquiSW.SOAP.classes.xsd.Cliente;
import es.deusto.arquiSW.SOAP.classes.xsd.Cuenta;
import es.deusto.arquiSW.SOAP.classes.xsd.Operacion;
import es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta;
import es.deusto.arquiSW.SOAP.gui.Mainwindow;

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
	DeustoBankServiceStub service; // variable temporal que hace uso del servicio web SOAP
	ConversorSOAPtoJAXB conversor; // Clase util conversor para convertir objetos de tipo SOAP a JAXB
	boolean stop = false; // booleano que detiene el Thread cuando ha realizado su cometido

	public InicializacionThread(Mainwindow window) {
		try {
			mw = window;
			conversor = new ConversorSOAPtoJAXB();
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
				if (arrayClientes != null) {
					mw.setTempClientes(conversor.convertFromSOAPclienteToJAXBcliente(arrayClientes));
					mw.loadClientes();
					System.out.println("[InicializacionThreat] coleccion de clientes obtenida y añadida con exito! :)");
				} else {
					System.out.println("[InicializacionThreat] No habia datos que recoger de la base de datos");
				}
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
				if (arrayCuentas != null) {
					// En relacion a operaciones:
					for (Cuenta cu : arrayCuentas) {
						obtOperacion.setIBAN(Integer.toString(cu.getIBAN()));
						obtOperacionRes = service.obtenerOperacion(obtOperacion);
						arrayOperacion = obtOperacionRes.get_return();
						if (arrayOperacion != null) {
							cu.setOperaciones(arrayOperacion);
						} else {
							cu.setOperaciones(new Operacion[0]);
						}
					}		
					mw.setTempCuentas(conversor.convertFromSOAPcuentaToJAXBcuenta(arrayCuentas));
					mw.loadCuentas();
					System.out.println("[InicializacionThreat] coleccion de cuentas obtenida y añadida con exito! :)");
				} else {
					System.out.println("[InicializacionThreat] No habia datos que recoger de la base de datos");
				}
				bolCuentas = true;
			} catch (RemoteException e) {
				System.out.println("[InicializacionThreat] Error en 'obtenerCuentas'");
				e.printStackTrace();
			}
			// Obtener todas las tarjetas:
			try {
				obtTarjetasRes = service.obtenerTarjetas(obtTarjetas);
				arrayTarjetas = obtTarjetasRes.get_return();
				if (arrayTarjetas != null) {
					mw.setTempTarjetas(conversor.convertFromSOAPtarjetaToJAXBtarjeta(arrayTarjetas));
					mw.loadTarjetas();
					System.out.println("[InicializacionThreat] coleccion de tarjetas obtenida y añadida con exito! :)");
				} else {
					System.out.println("[InicializacionThreat] No habia datos que recoger de la base de datos");
				}
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
			// (para no tener que instanciarla en el hilo principal de nuevo):
			mw.setSOAPservice(service);

		}
		System.out.println("[InicializacionThreat] Bucle WHILE parado. Thread terminado! :)");

	}
}
