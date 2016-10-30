package es.deusto.arquiSW.threats;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.axis2.AxisFault;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.arquiSW.SOAP.DeustoBankServiceStub;
import es.deusto.arquiSW.SOAP.ObtenerClientes;
import es.deusto.arquiSW.SOAP.ObtenerClientesResponse;
import es.deusto.arquiSW.SOAP.ObtenerCuentas;
import es.deusto.arquiSW.SOAP.ObtenerCuentasResponse;
import es.deusto.arquiSW.SOAP.ObtenerTarjetas;
import es.deusto.arquiSW.SOAP.ObtenerTarjetasResponse;
import es.deusto.arquiSW.SOAP.classes.xsd.Cliente;
import es.deusto.arquiSW.SOAP.classes.xsd.Cuenta;
import es.deusto.arquiSW.SOAP.classes.xsd.Tarjeta;

public class InicializacionThreat implements Runnable {
	
	DeustoBankServiceStub service;
	boolean stop = false;
	
	public InicializacionThreat() {
		try {
			
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
			ObtenerClientes obtClientes;
			ObtenerCuentas obtCuentas;
			ObtenerTarjetas obtTarjetas;
			ObtenerClientesResponse obtClientesRes;
			ObtenerCuentasResponse obtCuentasRes;
			ObtenerTarjetasResponse obtTarjetasRes;
			boolean bolClientes = false;
			boolean bolCuentas = false;
			boolean bolTarjetas = false;
			
			// Instanciacion de los atributos a utilizar de cara al servicio:
			obtClientes = new ObtenerClientes();
			obtCuentas = new ObtenerCuentas();
			obtTarjetas = new ObtenerTarjetas();
	
			// Llamadas a metodos del servicio:
				// Obtener todos los clientes:
				try {
					obtClientesRes = service.obtenerClientes(obtClientes);
					arrayClientes = obtClientesRes.get_return();
					System.out.println("arrayClientes.length() = " + arrayClientes[0].getDNI()); // ESTO DA ERROR!
					bolClientes = true;
				} catch (RemoteException e) {
					System.out.println("[InicializacionThreat] Error en 'obtenerClientes'");
					e.printStackTrace();
				}
				// Obtener todas las cuentas.
				try {
					obtCuentasRes = service.obtenerCuentas(obtCuentas);
					arrayCuentas = obtCuentasRes.get_return();
					System.out.println("arrayCuentas.length() = " + arrayCuentas.length); // ESTO DE VUELVE '1' y no tiene sentido porque no hay nada metido en la BD
					bolCuentas = true;
				} catch (RemoteException e) {
					System.out.println("[InicializacionThreat] Error en 'obtenerCuentas'");
					e.printStackTrace();
				}
				// Obtener todas las tarjetas:
				try {
					obtTarjetasRes = service.obtenerTarjetas(obtTarjetas);
					arrayTarjetas = obtTarjetasRes.get_return();
					System.out.println("arrayTarjetas.length() = " + arrayTarjetas.length); // ESTO DE VUELVE '1' y no tiene sentido porque no hay nada metido en la BD
					bolTarjetas = true;
				} catch (RemoteException e) {
					System.out.println("[InicializacionThreat] Error en 'obtenerTarjetas'");
					e.printStackTrace();
				}
					
			// Paramos el Thread:
			if (bolClientes && bolCuentas && bolTarjetas) {
				stop = true;
			}
			
			
			// Pasos a seguir:
			// Añadir contenido de la lista de Clientes a la Table model de Clientes
			// Añadir contenido de la lista de Cuentas a la Table model de Cuentas
			// Añadir contenido de la lista de Tarjetas a la Table model de Tarjetas
			// ASIGNAR el servicio que hemoss instaciado en esta clase, al servicio SOAP de la clase principal (Mainwindow.java).
		}
		System.out.println("[InicializacionThreat] Bucle WHILE parado. Thread terminado! :)");
		
	}

}
