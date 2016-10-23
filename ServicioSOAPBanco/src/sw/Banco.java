package sw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import dao.GestorBD;

/**
 * Esta es la clase principal que queremos que haga las veces de Servicio Web
 * @author aitor
 *
 */
public class Banco {
	
//	NOTA! Para los metodos que reciban parametros referentes al filtrado de datos, estos serna
//	pasados mediante un hash map (coleccion clave-valor)
	
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
	
	/**
	 * Obtiene los clientes en base al filtro especificado por los parametros
	 * @param DNI
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param movil
	 * @param empleado
	 */
	public void obtenerCliente(String DNI, String nombre, String apellidos, String email, String movil, Boolean empleado) {
		// TODO obtenerCliente en base al filtro
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
	 * Las tuplas relacionadas con la tabla Operaciones van incluidas al solicitar la(s) cuenta(s)
	 * @param IBAN
	 * @param DNI
	 * @param fechaApertura
	 * @param activa
	 * @param interes
	 */
	public void obtenerCuenta(String IBAN, String DNI, Date fechaApertura, Boolean activa, Double interes) {
		// TODO obtenerCuenta en base al filtro
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
	 * Obtiene las tarjetas en base al filtro especificado por los parametros
	 * @param numero
	 * @param DNI
	 * @param proveedor
	 * @param tipo
	 */
	public void obtenerTarjeta(String numero, String DNI, String proveedor, String tipo) {
		// TODO obtenerTarjeta en base al filtro
	}
	
	/**
	 * Obtiene todas las tarjetas
	 */
	public ArrayList<Tarjeta> obtieneTarjetas() {
		try {
			return gestorbd.obtenerTarjetas();
		} catch (SQLException e) {
			System.out.println("ERROR/EXCEPCION. Error a la hora de obtener todos las tarjetas de la BD:");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Desde el lado cliente se carga un XML, este es convertido a objetos Java mediante JAXB
	 * A continuacion, se quiere importar esos objetos en lado servidor introduciendolos en la base de datos
	 * @param c
	 * @param cu
	 * @param t
	 */
	public void importar(ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas, ArrayList<Tarjeta> tarjetas) {
		gestorbd.importar(clientes, cuentas, tarjetas);
	}
}
