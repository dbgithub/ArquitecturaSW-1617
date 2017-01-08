package es.deusto.arquiSW.hibernate.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import es.deusto.arquiSW.hibernate.classes.Cliente;
import es.deusto.arquiSW.hibernate.classes.Cuenta;
import es.deusto.arquiSW.hibernate.classes.Operacion;
import es.deusto.arquiSW.hibernate.classes.Tarjeta;


/**
 * This class gathers methods that will be used to communicate with the database through Hibernate.
 * It is necessary to determine and use properly a SessionFactory, a Session and the corresponding Transactions.
 * *Nota: Informacion sobre las diferencias y buenas practicas ente los componentes de HIbernate (Session, Transaction etc.): https://docs.jboss.org/hibernate/orm/3.3/reference/en-US/html/transactions.html
 * *Nota#2: Diferencias entre 'get' y 'load': Use get method to determine if an instance exists or not because it can return null.
 *  Use load method to retrieve instance only if you think that instance should exists and non availability is an error condition
 *  Mas info sobre 'get' vs. 'load' en: http://stackoverflow.com/questions/608947/hibernate-difference-between-session-get-and-session-load
 *  *Nota#3: dom4j is an easy to use library for working with XML, XPath and XSLT on the Java platform. Hibernate usesdom4j as API for manipulating XML trees. ¡Es necesario importar la libreria!
 * @author aitor & daniel
 *
 */
public class HibernateDAO {
	// Hibernate related variables:
	private SessionFactory factory; // A SessionFactory is set up once for an application!
	private Session s; // The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database
					   // The session objects should not be kept open for a long time because they are not usually thread safe.
	
	// *Note: a Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality.
	// Actually, a transaction is associated with Session and instantiated by calling session.beginTransaction().
	
	public HibernateDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory(); // 'configure()' configures settings from hibernate.cfg.xml			
		} catch (Throwable ex) { 
	         System.err.println("[HibernateDAO]: Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	/**
	 * Obtiene un determinado cliente con DNI pasasdo por parametro. Comprueba a su vez que el PIN es correcto.
	 * Si no es correcto devuelve null, si es correcto devuelve el Cliente.
	 * @param DNI
	 * @param PIN
	 * @return
	 */
	public Cliente obtenerCliente(String DNI, int PIN) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: obteniendo Cliente (DNI="+DNI+")...");
			tx = s.beginTransaction();
			Cliente resul = (Cliente) s.get(Cliente.class, DNI);
			s.flush();
			if (resul != null) {
				if (resul.getPIN() == PIN) {
					System.out.println("[HibernateDAO]: Cliente obtenido con exito!");
					tx.commit();
					return resul;
				} else {
					System.out.println("[HibernateDAO]: El PIN introducido no es correcto. ¡No coincide!");
					tx.commit();
					return null;
				}
			}
			tx.commit();
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'obtenerCliente'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
		return null;
	}
	
	/**
	 * Actualiza un cliente con los campos pasados por parametro, dado un DNI.
	 * @param DNI
	 * @param email
	 * @param movil
	 * @param PIN
	 */
	public void actualizarCliente(String DNI, String email, int movil, int PIN) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: actualizando Cliente (DNI="+DNI+")...");
			tx = s.beginTransaction();
			// You can perform updates with s.update(Object) or making a query:
				// Using method query:
				Cliente c = s.get(Cliente.class, DNI);
				c.setEmail(email);
				c.setMovil(movil);
				c.setPIN(PIN);
				s.update(c);
				// Query-like:
//				s.createQuery("update Cliente set email = :nemail, movil = :nmovil, PIN = :npin where DNI = :DNI") // Cuando usas HQL, las queries hacen referencia al nombre de la clase, no al nombre de la tabla de la base de datos! Idem para los atributos!
//					.setParameter("nemail", email)
//					.setParameter("nmovil", movil)
//					.setParameter("npin", PIN)
//					.setParameter("DNI", DNI)
//					.executeUpdate();
			tx.commit();
			System.out.println("[HibernateDAO]: Cliente actualizado con exito!");
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'actualizarCliente'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
	}
	
	/**
	 * Obtiene todas las cuentas vinculadas a un determinado Cliente con DNI dado por parametro
	 * @param DNI
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Cuenta> obtenerCuentas(String DNI) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: obteniendo cuentas...");
			tx = s.beginTransaction();
			ArrayList<Cuenta> resul = (ArrayList<Cuenta>) s.createQuery("from Cuenta where cliente.DNI = :DNI").setParameter("DNI", DNI).getResultList();
					// Obteniendo titular de una de las cuentas (a modo de ejemplo):
					Cliente titular = resul.get(0).getCliente();
					System.out.println("Titular de la cuenta(IBAN="+resul.get(0).getIBAN()+"): " + titular.getNombre() + " (DNI="+titular.getDNI()+")");
			tx.commit(); 
			System.out.println("[HibernateDAO]: Cuentas obtenidas con exito!");
			return resul;
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'obtenerCuentas'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
		return null;
	}
	
	/**
	 * Obtiene todas las operaciones de una determinada cuenta con IBAN pasado por parametro.
	 * @param IBAN
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Operacion> obtenerOperaciones(int IBAN) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: obteniendo operaciones (IBAN="+IBAN+")...");
			tx = s.beginTransaction();
			ArrayList<Operacion> resul = (ArrayList<Operacion>) s.createQuery("from Operacion where cuenta.IBAN = :IBAN").setParameter("IBAN", IBAN).getResultList();
					
			tx.commit();
			System.out.println("[HibernateDAO]: Operaciones obtenidas con exito!");
			return resul;
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'obtenerOperaciones'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
		return null;
	}
	
	/**
	 * Obtiene todas las tarjetas vinuladas a una determinada cuenta con IBAN pasado por parametro
	 * @param IBAN
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Tarjeta> obtenerTarjetas(int IBAN) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: obteniendo tarjetas (IBAN="+IBAN+")...");
			tx = s.beginTransaction();
			ArrayList<Tarjeta> resul = (ArrayList<Tarjeta>) s.createQuery("from Tarjeta where cuenta.IBAN = :IBAN").setParameter("IBAN", IBAN).getResultList();		
					
			tx.commit();
			System.out.println("[HibernateDAO]: Tarjetas obtenidas con exito!");
			return resul;
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'obtenerTarjetas'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
		return null;
	}
	
	/**
	 * Inserta operaciones vinculadas a una determinada cuenta bancaria con IBAN pasado por parametro.
	 * Las operaciones se pasan por parametro en una lista.
	 * @param opes
	 * @param IBAN
	 */
	public void insertarOperacionesEnCuenta(Set<Operacion> opes, int IBAN) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: insertando Operaciones en cuenta con IBAN='"+IBAN+"'...");
			tx = s.beginTransaction();
			Cuenta temp = s.get(Cuenta.class, 141414);
			s.flush();
			Iterator<Operacion> it = opes.iterator();
			while (it.hasNext()) {
				Operacion o = it.next();
				o.setCuenta(temp); 
				s.save(o);
				}
			tx.commit();
			System.out.println("[HibernateDAO]: Operaciones insertadas con exito!");
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'insertarOperacionesEnCuenta'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
	}
	
	/**
	 * Elimina una operacion dado su ID de operacion por parametro
	 * @param ID
	 */
	public void eliminarOperacion(int ID) {
		s = factory.openSession();
		Transaction tx = null;
		
		try {
			System.out.println("[HibernateDAO]: eliminando Operacion (ID="+ID+")...");
			tx = s.beginTransaction();
			Operacion o = (Operacion) s.get(Operacion.class, ID);
			s.delete(o);
					
			tx.commit();
			System.out.println("[HibernateDAO]: Operacion eliminada con exito!");
		} catch (Exception e) {
			System.err.println("[HibernateDAO]: Error en la transaccion 'eliminarOperacion'");
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close(); // Cerramos la sesion
		}
	}
}
