package es.deusto.arquiSW.persistencia;

import es.deusto.arquiSW.DAO.HibernateDAO;
import es.deusto.arquiSW.classes.Cliente;

/**
 * Clase para probar los metodos del DAO de Hibernate contra la base de datos
 * @author aitor & daniel
 *
 */
public class Main {

	public static void main(String[] args) {
		// Declaramos e instanciamos el DAO para la comunicación con la base de datos:
		HibernateDAO miDAO = new HibernateDAO();
		
		// A continnuación llamamos a metodos y hacemos pruebas con los datos obtenidos y enviados:
		
		// Obtener cliente:
		Cliente c = miDAO.obtenerCliente("58485442", 25784);
		System.out.println("To string cliente: " + c.getNombre());
	}

}
