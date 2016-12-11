package es.deusto.arquiSW.persistencia;

public class Main {

	public static void main(String[] args) {
		// TODO Hacer pruebas con Hibernate

		// A SessionFactory is set up once for an application!
		// .configure() // configures settings from hibernate.cfg.xml
		
		// A Session is used to get a physical connection with a database.
		
		// A Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality.
		
		// Dentro de un catch(Exception e) {
		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				//StandardServiceRegistryBuilder.destroy( registry );
				//}
	}

}
