package es.deusto.arquiSW.JAXB.util;

import es.deusto.arquiSW.SOAP.classes.xsd.Cuenta;
import es.deusto.arquiSW.SOAP.classes.xsd.Operacion;

public class ConversorJAXBtoSOAP {
	/**
	 * Convierte del tipo Cliente de JAXB al tipo Cliente de SOAP
	 * 
	 * @param clientes
	 * @return
	 */
	public es.deusto.arquiSW.SOAP.classes.xsd.Cliente[] convertFromJAXBclienteToSOAPcliente(es.deusto.arquiSW.JAXB.classes.Cliente[] clientes) {

		es.deusto.arquiSW.SOAP.classes.xsd.Cliente[] colleccion = new es.deusto.arquiSW.SOAP.classes.xsd.Cliente[clientes.length];

		for (int i = 0; i < clientes.length; i++) {
			es.deusto.arquiSW.SOAP.classes.xsd.Cliente aux= new es.deusto.arquiSW.SOAP.classes.xsd.Cliente();
			aux.setDNI(clientes[i].getDNI());
			aux.setNombre(clientes[i].getNombre());
			aux.setApellidos(clientes[i].getApellidos());
			aux.setDireccion(clientes[i].getDireccion());
			aux.setEmail(clientes[i].getEmail());
			aux.setMovil(clientes[i].getMovil());
			aux.setEmpleado(clientes[i].isEmpleado());
			aux.setPIN(clientes[i].getPIN());
			colleccion[i] = aux;
		}
		return colleccion;
	}

	/**
	 * Convierte del tipo Cuenta de JAXB al tipo Cuenta de SOAP
	 * 
	 * @param cuentas
	 * @return
	 */
	public es.deusto.arquiSW.SOAP.classes.xsd.Cuenta[] convertFromJAXBcuentaToSOAPcuenta(es.deusto.arquiSW.JAXB.classes.Cuenta[] cuentas, es.deusto.arquiSW.JAXB.classes.Cliente[] clientes) {
		
		es.deusto.arquiSW.SOAP.classes.xsd.Cuenta[] colleccion = new es.deusto.arquiSW.SOAP.classes.xsd.Cuenta[cuentas.length];
		for (int i = 0; i < cuentas.length; i++) {
			es.deusto.arquiSW.SOAP.classes.xsd.Cuenta aux= new es.deusto.arquiSW.SOAP.classes.xsd.Cuenta();
			aux.setIBAN(cuentas[i].getIBAN());
			aux.setSWIFT(cuentas[i].getSWIFT());
			aux.setActiva(cuentas[i].isActiva());
			aux.setFechaApertura(cuentas[i].getFechaApertura());
			aux.setSaldoActual(cuentas[i].getSaldoActual());
			aux.setInteres(cuentas[i].getInteres());
			for(es.deusto.arquiSW.JAXB.classes.Cliente c: clientes){
				if(cuentas[i].getTitular()== c.getDNI()){
					es.deusto.arquiSW.SOAP.classes.xsd.Cliente auxc= new es.deusto.arquiSW.SOAP.classes.xsd.Cliente();
					auxc.setDNI(clientes[i].getDNI());
					auxc.setNombre(clientes[i].getNombre());
					auxc.setApellidos(clientes[i].getApellidos());
					auxc.setDireccion(clientes[i].getDireccion());
					auxc.setEmail(clientes[i].getEmail());
					auxc.setMovil(clientes[i].getMovil());
					auxc.setEmpleado(clientes[i].isEmpleado());
					auxc.setPIN(clientes[i].getPIN());
					aux.setTitular(auxc);
				}
			}
			
			Operacion[] operaciones= new Operacion[cuentas[i].getOperaciones().size()];
			int j=0;
//			for(es.deusto.arquiSW.JAXB.classes.Operacion o: cuentas[i].getOperaciones()){
//				operaciones[j]=;
//			}
			colleccion[i]=aux;
			
			
		}
//		
		return colleccion;
		
		
//
	}

	/**
	 * Convierte del tipo Operacion de JAXB al tipo Operacion de SOAP
	 * 
	 * @param operaciones
	 * @return
	 */
	public es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] convertFromJAXBoperacionToSOAPoperacion(
			es.deusto.arquiSW.JAXB.classes.Operacion[] operaciones) {

		es.deusto.arquiSW.SOAP.classes.xsd.Operacion[] colleccion = new es.deusto.arquiSW.SOAP.classes.xsd.Operacion[operaciones.length];

		for (int i = 0; i < operaciones.length; i++) {
			es.deusto.arquiSW.SOAP.classes.xsd.Operacion aux= new es.deusto.arquiSW.SOAP.classes.xsd.Operacion();
			aux.setId(operaciones[i].getId());
			aux.setFecha(operaciones[i].getFecha());
			aux.setImporte(operaciones[i].getImporte());
			aux.setTipo(es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.EnumTipoOperacion.Factory.fromValue(operaciones[i].getTipo().name()));
			Cuenta cu= new Cuenta();
			cu.setIBAN(operaciones[i].getCuenta());
			aux.setCuenta(cu);
			colleccion[i]= aux;

		}
		return colleccion;

	}

	/**
	 * Convierte del tipo Tarjeta de JAXB al tipo Tarjeta de SOAP
	 * 
	 * @param tarjetas
	 * @return
	 */
	public es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta[] convertFromJAXBtarjetaToSOAPtarjeta(es.deusto.arquiSW.JAXB.classes.Tarjeta[] tarjetas) {
		
		es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta[] colleccion = new es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta[tarjetas.length];
		for (int i = 0; i < tarjetas.length; i++) {
			es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta aux= new es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta();
			aux.setNumero(tarjetas[i].getNumero());
			aux.setLimiteExtraccion(tarjetas[i].getLimiteExtraccion());
			aux.setFechaCaducidad(tarjetas[i].getFechaCaducidad());
			aux.setProveedor(es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.EnumProveedores.Factory.fromValue(tarjetas[i].getProveedor().name()));
			aux.setTipo(es.deusto.arquiSW.SOAP.ws.namespaces.axis2.Enum.TiposTarjeta.Factory.fromValue(tarjetas[i].getTipo().name()));
			aux.setFechaExpedicion(tarjetas[i].getFechaExpedicion());
			Cuenta cu= new Cuenta();
			cu.setIBAN(tarjetas[i].getCuenta());
			aux.setCuenta(cu);
			colleccion[i]=aux;
		}
		return colleccion;

	}
}
