package es.deusto.arquiSW.persistencia;

import java.util.ArrayList;

import es.deusto.arquiSW.DAO.HibernateDAO;
import es.deusto.arquiSW.classes.Cliente;
import es.deusto.arquiSW.classes.Cuenta;
import es.deusto.arquiSW.classes.Operacion;
import es.deusto.arquiSW.classes.Tarjeta;

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
		System.out.println("Cuenta(s) obtenida(s): " + cuentas.get(0).getIBAN() + ", cliente: " +cuentas.get(0).getCliente() + "...");
		// Obtener operaciones:
		ArrayList<Operacion> operaciones = miDAO.obtenerOperaciones(5555555);
		System.out.println("Operacione(s) obtenida(s): id#" + operaciones.get(0).getId());
		// Obtener tarjetas: 
		ArrayList<Tarjeta> tarjetas = miDAO.obtenerTarjetas(15151515);
		System.out.println("Tarjeta(s) obtenida(s): " + tarjetas.get(0).getNumero());
		// Insertar operacion:
		miDAO.insertarOperacion(new Operacion("2016-12-12", "Ingreso", 555f, 15151515));
		// Eliminar operacion:
		miDAO.eliminarOperacion(4);
		// Insertar operaciones en cuenta dada:
//		ArrayList<Operacion> operacioness = new ArrayList<Operacion>();
//		operacioness.add(new Operacion("2016-12-12", "Ingreso", 555f, 15151515));
//		operacioness.add(new Operacion("2016-12-20", "Ingreso", 25f, 15151515));
//		operacioness.add(new Operacion("2016-12-21", "Ingreso", 5f, 15151515));
//		operacioness.add(new Operacion("2016-12-24", "Extraccion", 500f, 15151515));
	}

}
