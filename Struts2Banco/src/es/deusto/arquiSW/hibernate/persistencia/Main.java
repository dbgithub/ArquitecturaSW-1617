package es.deusto.arquiSW.hibernate.persistencia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import es.deusto.arquiSW.hibernate.DAO.HibernateDAO;
import es.deusto.arquiSW.hibernate.classes.Cliente;
import es.deusto.arquiSW.hibernate.classes.Cuenta;
import es.deusto.arquiSW.hibernate.classes.Operacion;
import es.deusto.arquiSW.hibernate.classes.Tarjeta;

/**
 * Clase para probar los metodos del DAO de Hibernate contra la base de datos
 * @author aitor & daniel
 *
 */
public class Main {

	public static void main(String[] args) {
		// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
		HibernateDAO miDAO = new HibernateDAO();
		
		// A continnuación llamamos a los metodos expuestos y hacemos pruebas con los datos obtenidos y enviados:
		
		// Obtener cliente:
		Cliente c = miDAO.obtenerCliente("58485442", 25777);
		System.out.println("Cliente obtenido: " + c.getNombre());
		// Actualizar cliente:
		miDAO.actualizarCliente("58485442", "tortxu@gmail.es", 660098912, 25777);
		System.out.println("Cliente actualizado: " + c.getNombre());
		// Obtener cuentas:
		ArrayList<Cuenta> cuentas = miDAO.obtenerCuentas("2525252");
		System.out.println("Cuenta(s) obtenida(s) (ej.): iban# " + cuentas.get(0).getIBAN());
		// Obtener operaciones:
		ArrayList<Operacion> operaciones = miDAO.obtenerOperaciones(5555555);
		System.out.println("Operacione(s) obtenida(s) (ej.): id# " + operaciones.get(0).getId());
		// Obtener tarjetas: 
		ArrayList<Tarjeta> tarjetas = miDAO.obtenerTarjetas(15151515);
		System.out.println("Tarjeta(s) obtenida(s) (ej.): numero# " + tarjetas.get(0).getNumero());
		// Insertar operaciones en cuenta dada:
		Set<Operacion> operacioness = new HashSet<Operacion>();
		operacioness.add(new Operacion(6,"2016-12-12", "Ingreso", 555f)); // El ID de la Operacion no importa cual poner porque en el archivo mapping, el generador esta pueso como "increment", si quieres establecer tu el ID, escribe "assigned".
		operacioness.add(new Operacion(7,"2016-12-20", "Ingreso", 25f)); // El ID de la Operacion no importa cual poner porque en el archivo mapping, el generador esta pueso como "increment", si quieres establecer tu el ID, escribe "assigned".
		operacioness.add(new Operacion(8,"2016-12-21", "Ingreso", 5f)); // El ID de la Operacion no importa cual poner porque en el archivo mapping, el generador esta pueso como "increment", si quieres establecer tu el ID, escribe "assigned".
		operacioness.add(new Operacion(9,"2016-12-24", "Extraccion", 500f)); // El ID de la Operacion no importa cual poner porque en el archivo mapping, el generador esta pueso como "increment", si quieres establecer tu el ID, escribe "assigned".
		miDAO.insertarOperacionesEnCuenta(operacioness, 15151515);
		// Eliminar operacion:
		miDAO.eliminarOperacion(4);
		miDAO.eliminarOperacion(5);
		miDAO.eliminarOperacion(6);
		miDAO.eliminarOperacion(7);
	}

}
