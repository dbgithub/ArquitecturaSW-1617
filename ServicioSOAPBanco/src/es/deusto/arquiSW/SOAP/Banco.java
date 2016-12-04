package es.deusto.arquiSW.SOAP;

import java.sql.SQLException;
import java.util.ArrayList;
import es.deusto.arquiSW.classes.Cliente;
import es.deusto.arquiSW.classes.Cuenta;
import es.deusto.arquiSW.classes.Operacion;
import es.deusto.arquiSW.classes.Tarjeta;
import es.deusto.arquiSW.dao.GestorBD;

/**
 * Esta es la clase principal que queremos que haga las veces de Servicio Web
 * @author aitor & daniel
 *
 */
public class Banco {
	
	GestorBD gestorbd;
	
	public Banco() {
		gestorbd = new GestorBD(); // Obtenemos una conexion a la base de datos.
		try {
			gestorbd.conectar();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de conectar con la BD:");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de conectar con la BD:");
			e.printStackTrace();
		}
	}
	
	// ****************************
	// METODOS EXPUESTOS AL CLIENTE:
	
	/**
	 * Obtiene un(os) cliente(s) en base al filtro especificado por los parametros
	 * @param DNI
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param movil
	 * @param empleado
	 */
	public ArrayList<Cliente> obtenerCliente(String DNI, String nombre, String apellidos, String email, String movil, Boolean empleado) {
		try {
			return gestorbd.obtenerCliente(DNI, nombre, apellidos, email, movil, empleado);
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener cliente(s) de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene todos los clientes
	 */
	public ArrayList<Cliente> obtenerClientes() {
		try {
			return gestorbd.obtenerClientes();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener todos los clientes de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene una(s) cuenta(s) en base al filtro especificado por los parametros 
	 * @param IBAN
	 * @param DNI
	 * @param fechaApertura
	 * @param activa
	 * @param interes
	 */
	public ArrayList<Cuenta> obtenerCuenta(String IBAN, String DNI, String fechaApertura, Boolean activa, String interes) {
		try {
			return gestorbd.obtenerCuenta(IBAN, DNI, fechaApertura, activa, interes);
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener cuenta(s) de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene todas las cuentas
	 */
	public ArrayList<Cuenta> obtenerCuentas() {
		try {
			return gestorbd.obtenerCuentas();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener todos las cuentas de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene un(as) operacion(es) en base al IBAN especificado por los parametros
	 * @param IBAN
	 */
	public ArrayList<Operacion> obtenerOperacion(String IBAN) {
		try {
			return gestorbd.obtenerOperacion(IBAN);
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener una(s) operacion(es) de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene todas las operaciones
	 */
	public ArrayList<Operacion> obtenerOperaciones() {
		try {
			return gestorbd.obtenerOperaciones();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener todos las operaciones de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene una(s) tarjeta(s) en base al filtro especificado por los parametros
	 * @param numero
	 * @param DNI
	 * @param proveedor
	 * @param tipo
	 */
	public ArrayList<Tarjeta> obtenerTarjeta(String numero, String DNI, String proveedor, String tipo) {
		try {
			return gestorbd.obtenerTarjeta(numero, DNI, proveedor, tipo);
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener tarjeta(s) de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtiene todas las tarjetas
	 */
	public ArrayList<Tarjeta> obtenerTarjetas() {
		try {
			return gestorbd.obtenerTarjetas();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener todos las tarjetas de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Importar datos del lado cliente al lado servidor.
	 * Desde el lado cliente se carga un XML, este es convertido a objetos Java mediante JAXB
	 * A continuacion, se quiere importar esos objetos en lado servidor introduciendolos en la base de datos
	 * @param clientes
	 * @param cuentas
	 * @param tarjetas
	 */
	public void importar(ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas, ArrayList<Tarjeta> tarjetas) {
		try {
			gestorbd.importar(clientes, cuentas, tarjetas);
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de importar datos a la BD:");
			e.printStackTrace();
		}
	}
}
