package es.deusto.arquiSW.JAXB.util;

import java.util.ArrayList;
import java.util.Arrays;

import es.deusto.arquiSW.JAXB.classes.ClienteJAXB;
import es.deusto.arquiSW.JAXB.classes.CuentaJAXB;
import es.deusto.arquiSW.JAXB.classes.OperacionJAXB;
import es.deusto.arquiSW.JAXB.classes.TarjetaJAXB;
import es.deusto.arquiSW.SOAP.classes.xsd.Cliente;
import es.deusto.arquiSW.SOAP.classes.xsd.Cuenta;
import es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta;

public class ConversorSOAPtoJAXB {
	/**
	 * Convierte del tipo Cliente de SOAP al tipo Cliente de JAXB
	 * 
	 * @param clientes
	 * @return
	 */
	public ClienteJAXB[] convertFromSOAPclienteToJAXBcliente(Cliente[] clientes) {
		ClienteJAXB[] colleccion = new ClienteJAXB[clientes.length];

		for (int i = 0; i < clientes.length; i++) {

			colleccion[i] = new ClienteJAXB(clientes[i].getDNI(), clientes[i].getNombre(),
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
	public CuentaJAXB[] convertFromSOAPcuentaToJAXBcuenta(Cuenta[] cuentas) {
		// ArrayList<Cuenta> tempcoleccion = new
		// ArrayList<Cuenta>();
		// for (Cuenta c : cuentas) {
		// Operacion[] operaciones =
		// convertFromSOAPoperacionToJAXBoperacion(
		// c.getOperaciones());
		// tempcoleccion.add(new
		// Cuenta(c.getIBAN(), c.getSWIFT(),
		// c.getFechaApertura(),
		// c.getActiva(), c.getSaldoActual(), c.getInteres(),
		// c.getTitular().getDNI(),
		// new
		// ArrayList<Operacion>(Arrays.asList(operaciones))));
		// }
		// return (Cuenta[])
		// tempcoleccion.toArray();
		CuentaJAXB[] colleccion = new CuentaJAXB[cuentas.length];
		for (int i = 0; i < cuentas.length; i++) {
			OperacionJAXB[] operaciones = convertFromSOAPoperacionToJAXBoperacion(
					cuentas[i].getOperaciones());
			colleccion[i] = new CuentaJAXB(cuentas[i].getIBAN(), cuentas[i].getSWIFT(),
					cuentas[i].getFechaApertura(), cuentas[i].getActiva(), cuentas[i].getSaldoActual(),
					cuentas[i].getInteres(), cuentas[i].getTitular().getDNI(),
					new ArrayList<OperacionJAXB>(Arrays.asList(operaciones)));
			
		}
		return colleccion;

	}

	/**
	 * Convierte del tipo Operacion de SOAP al tipo Operacion de JAXB
	 * 
	 * @param operaciones
	 * @return
	 */
	public OperacionJAXB[] convertFromSOAPoperacionToJAXBoperacion(
			es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] operaciones) {
		// ArrayList<Operacion> tempcoleccion =
		// new ArrayList<Operacion>();
		// for (Operacion o : operaciones) {
		// tempcoleccion.add(new
		// Operacion(o.getId(), o.getFecha(),
		// Operacion.EnumTipoOperacion.valueOf(o.getTipo().getValue()),
		// o.getImporte(), o.getCuenta().getIBAN()));
		// }
		// return (Operacion[])
		// tempcoleccion.toArray();

		OperacionJAXB[] colleccion = new OperacionJAXB[operaciones.length];

		for (int i = 0; i < operaciones.length; i++) {

			colleccion[i] = new OperacionJAXB(operaciones[i].getId(),
					operaciones[i].getFecha(),
					OperacionJAXB.EnumTipoOperacion
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
	public TarjetaJAXB[] convertFromSOAPtarjetaToJAXBtarjeta(Tarjeta[] tarjetas) {
		// ArrayList<Tarjeta> tempcoleccion = new
		// ArrayList<Tarjeta>();
		// for (Tarjeta t : tarjetas) {
		// tempcoleccion.add(new
		// Tarjeta(t.getNumero(),
		// t.getCuenta().getIBAN(),
		// t.getLimiteExtraccion(), t.getFechaCaducidad(),
		// Tarjeta.EnumProveedores.valueOf(t.getProveedor().getValue()),
		// Tarjeta.TiposTarjeta.valueOf(t.getTipo().getValue()),
		// t.getFechaExpedicion()));
		// }
		// return (Tarjeta[])
		// tempcoleccion.toArray();
		TarjetaJAXB[] colleccion = new TarjetaJAXB[tarjetas.length];

		for (int i = 0; i < tarjetas.length; i++) {

			colleccion[i] = new TarjetaJAXB(tarjetas[i].getNumero(),
					tarjetas[i].getCuenta().getIBAN(),
					tarjetas[i].getLimiteExtraccion(), tarjetas[i].getFechaCaducidad(),
					 TarjetaJAXB.EnumProveedores.valueOf(tarjetas[i].getProveedor().getValue()),
					 TarjetaJAXB.TiposTarjeta.valueOf(tarjetas[i].getTipo().getValue()),
					 tarjetas[i].getFechaExpedicion());
		}
		return colleccion;

	}

}
