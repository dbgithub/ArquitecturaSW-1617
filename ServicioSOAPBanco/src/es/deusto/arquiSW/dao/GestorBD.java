package es.deusto.arquiSW.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import es.deusto.arquiSW.classes.Cliente;
import es.deusto.arquiSW.classes.Cuenta;
import es.deusto.arquiSW.classes.Operacion;
import es.deusto.arquiSW.classes.Tarjeta;
import es.deusto.arquiSW.classes.Operacion.EnumTipoOperacion;
import es.deusto.arquiSW.classes.Tarjeta.EnumProveedores;
import es.deusto.arquiSW.classes.Tarjeta.TiposTarjeta;

public class GestorBD {
	private Connection con;

	private String dataSource = "//localhost:3306/ArquitecturaSW";
	private String username = "root";
	private String password = "root";
	private String driver = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql";

	/**
	 * Constructor vacio con los parametros de conexion por defecto
	 */
	public GestorBD() {
	}

	/**
	 * Establecemos los parametros de conexion
	 * @param dataSource
	 * @param username
	 * @param password
	 */
	public GestorBD(String dataSource, String username, String password) {
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
	}

	/**
	 * Conectar con la base de datos tras haber establecido los parametros anteriormente
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		String url = protocol + ":" + dataSource;
		con = DriverManager.getConnection(url, username, password);
	}

	/**
	 * Cerrar la conexion con la base de datos
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		con.close();
	}
	
	/**
	 * Resetear todas las bases de datos eliminando todos los datos dejandolos limpios.
	 * @throws SQLException
	 */
	public void resetearTodo() throws SQLException {
		Statement statement = con.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS cliente");
		statement.executeUpdate("DROP TABLE IF EXISTS cuenta");
		statement.executeUpdate("DROP TABLE IF EXISTS operacion");
		statement.executeUpdate("DROP TABLE IF EXISTS tarjeta");
		System.out.println("[GestorDB] tablas reseteadas satisfactoriamente");
	}
	
	/**
	 * Obtiene una coleccion de clientes de la base de datos
	 * @return una coleccion de clientes
	 * @throws SQLException
	 */
	public ArrayList<Cliente> obtenerClientes() throws SQLException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM cliente";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()){
        	Cliente cliente = new Cliente();
        	cliente.setDNI(rs.getString("dni"));
        	cliente.setNombre(rs.getString("nombre"));
        	cliente.setApellidos(rs.getString("apellidos"));
        	cliente.setDireccion(rs.getString("direccion"));
        	cliente.setEmail(rs.getString("email"));
        	cliente.setMovil(rs.getInt("movil"));
        	cliente.setEmpleado(rs.getBoolean("empleado"));
        	cliente.setPIN(rs.getInt("pin"));
        	clientes.add(cliente);
        }
        rs.close();
        statement.close();  
        return clientes;
	}
	
	/**
	 * Obtiene una coleccion de cuentas de la base de datos
	 * @return una coleccion de cuentas
	 * @throws SQLException
	 */
	public ArrayList<Cuenta> obtenerCuentas() throws SQLException{
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM cuenta";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()){
        	Cuenta cuenta = new Cuenta();
        	cuenta.setIBAN(rs.getInt("iban"));
        	cuenta.setSWIFT(rs.getString("swift"));
        	cuenta.setFechaApertura(rs.getDate("fechaapertura"));
        	cuenta.setActiva(rs.getBoolean("activa"));
        	cuenta.setSaldoActual(rs.getFloat("saldoactual"));
        	cuenta.setInteres(rs.getFloat("interes"));
        	Cliente c = new Cliente();
        	c.setDNI(rs.getString("Cliente"));
        	Tarjeta t = new Tarjeta();
        	t.setNumero(rs.getInt("tarjeta"));
        	ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
        	tarjetas.add(t);
        	cuenta.setTitular(c);
        	cuenta.setTarjetas(tarjetas);
        	cuentas.add(cuenta);
        }
        rs.close();
        statement.close();  
        return cuentas;
	}
	
	/**
	 * Obtiene una coleccion de operaciones de la base de datos
	 * @return una coleccion de operaciones
	 * @throws SQLException
	 */
	public ArrayList<Operacion> obtenerOperaciones() throws SQLException{
		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM operacion";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()){
        	Operacion operacion = new Operacion();
        	operacion.setId(rs.getInt("id"));
        	operacion.setFecha(rs.getDate("fecha"));
        	operacion.setTipo(EnumTipoOperacion.valueOf(rs.getString("tipo")));
        	operacion.setImporte(rs.getFloat("importe"));
        	Cuenta c = new Cuenta();
        	c.setIBAN(rs.getInt("cuenta"));
        	operacion.setCuenta(c);
        	operaciones.add(operacion);
        }
        rs.close();
        statement.close();  
        return operaciones;
	}
	
	/**
	 * Obtiene una coleccion de tarjetas de la base de datos
	 * @return una coleccion de tarjetas
	 * @throws SQLException
	 */
	public ArrayList<Tarjeta> obtenerTarjetas() throws SQLException{
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM tarjeta";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()){
			Tarjeta tarjeta = new Tarjeta();
        	tarjeta.setNumero(rs.getInt("numero"));
        	tarjeta.setLimiteExtraccion(rs.getInt("limiteextraccion"));
        	tarjeta.setFechaCaducidad(rs.getDate("fechacaducidad"));
        	tarjeta.setProveedor(EnumProveedores.valueOf(rs.getString("proveedor")));
        	tarjeta.setTipo(TiposTarjeta.valueOf(rs.getString("tipo")));
        	tarjeta.setFechaExpedicion(rs.getDate("fechaexpedicion"));
        	Cuenta c = new Cuenta();
        	c.setIBAN(rs.getInt("cuenta"));
        	tarjeta.setCuenta(c);
        	tarjetas.add(tarjeta);
        }
        rs.close();
        statement.close();  
        return tarjetas;
	}
	
	/**
	 * Desde el lado cliente se carga un XML, este es convertido a objetos Java mediante JAXB
	 * A continuacion, se quiere importar esos objetos en lado servidor introduciendolos en la base de datos
	 * Si las coleccions de clientes, cuentas y tarjetas no estan vacias, se llamara a los respectivos metodos
	 * para insertar individualmente las tuplas.
	 * @param clientes
	 * @param cuentas
	 * @param tarjetas
	 * @throws SQLException 
	 */
	public void importar(ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas, ArrayList<Tarjeta> tarjetas) throws SQLException {
		if (!clientes.isEmpty()) {insertarClientes(clientes);}
		if (!cuentas.isEmpty()) {insertarCuentas(cuentas);}
		if (!tarjetas.isEmpty()) {insertarTarjetas(tarjetas);}
	}
	
	/**
	 * Insertamos cliente(s) en la base de datos
	 * @param clientes
	 * @throws SQLException 
	 */
	public void insertarClientes(ArrayList<Cliente> clientes) throws SQLException {
		//TODO: Insertar cliente(s) (incluyendo todos los parametros)
		Iterator<Cliente> it = clientes.iterator();
		Statement statement = con.createStatement();
		while (it.hasNext()) {
			Cliente temp = it.next();
			String sqlString = "INSERT INTO Cliente " +
					"(DNI, Nombre, Apellidos, Direccion, email, movil, empleado, PIN) " +
					"VALUES ('" + temp.getDNI() +
					"','" + temp.getNombre() +
					"','" + temp.getApellidos() +
					"'," + temp.getDireccion() +
					"," + temp.getEmail() +
					"," + temp.getMovil() +
					"," + temp.isEmpleado() +
					","  + temp.getPIN() + ")";                        
			statement.executeUpdate(sqlString);
			
		}
		statement.close();   
	}
	
	/**
	 * Insertamos cuenta(s) en la base de datos
	 * @param cuentas
	 */
	public void insertarCuentas(ArrayList<Cuenta> cuentas) {
		//TODO: Insertar cuenta(s) (incluyendo todos los parametros)
		//TODO: Insertar operacion(s) (incluyendo todos los parametros)
	}
	
	/**
	 * Insertamos tarjeta(s) en la base de datos
	 * @param tarjetas
	 */
	public void insertarTarjetas(ArrayList<Tarjeta> tarjetas) {
		//TODO: Insertar tarjeta(s) (incluyendo todos los parametros)
	}
	
	/**
	 * Obtener cliente(s) en base a un filtro establecido en la parte cliente.
	 * @param DNI
	 * @param Nombre
	 * @param Apellidos
	 * @param email
	 * @param movil
	 * @param empleado
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Cliente> obtenerCliente(String DNI, String Nombre, String Apellidos, String email, String movil, Boolean empleado) throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement statement;
		String sqlString = "SELECT * FROM Cliente" +
			" WHERE @1 AND @2 AND @3 AND @4 AND @5 AND @6";
		if (DNI!=null) {sqlString = sqlString.replace("@1", "Dni="+DNI);} else {sqlString = sqlString.replace("@1", "Dni = Dni");}
		if (Nombre!=null) {sqlString = sqlString.replace("@2", "Nombre="+Nombre);} else {sqlString = sqlString.replace("@2", "Nombre = Nombre");}
		if (Apellidos!=null) {sqlString = sqlString.replace("@3", "Apellidos="+Apellidos);} else {sqlString = sqlString.replace("@3", "Apellidos = Apellidos");}
		if (email!=null) {sqlString = sqlString.replace("@4", "Email="+email);} else {sqlString = sqlString.replace("@4", "Email = Email");}
		if (movil!=null) {sqlString = sqlString.replace("@5", "Movil="+movil);} else {sqlString = sqlString.replace("@5", "Movil = Movil");}
		if (empleado!=null) {sqlString = sqlString.replace("@6", (empleado)? "Empleado=1":"Empleado=0");} else {sqlString = sqlString.replace("@6", "Empleado = Empleado");}
		statement = con.prepareStatement(sqlString);	
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery();
		while (rs.next()){
        	Cliente cliente = new Cliente();
        	cliente.setDNI(rs.getString("dni"));
        	cliente.setNombre(rs.getString("nombre"));
        	cliente.setApellidos(rs.getString("apellidos"));
        	cliente.setDireccion(rs.getString("direccion"));
        	cliente.setEmail(rs.getString("email"));
        	cliente.setMovil(rs.getInt("movil"));
        	cliente.setEmpleado(rs.getBoolean("empleado"));
        	cliente.setPIN(rs.getInt("pin"));
        	clientes.add(cliente);
        }
        rs.close();
        statement.close();  
        return clientes;
	}
	
	/**
	 * Obtiene cuenta(a) en base a un filtro estableido en la parte cliente.
	 * @param IBAN
	 * @param fechaApertura
	 * @param activa
	 * @param interes
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Cuenta> obtenerCuenta(String IBAN, String fechaApertura, Boolean activa, String interes) throws SQLException {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		PreparedStatement statement;
		String sqlString = "SELECT * FROM Cuenta" +
			" WHERE @1 AND @2 AND @3 AND @4";
		if (IBAN!=null) {sqlString = sqlString.replace("@1", "IBAN="+IBAN);} else {sqlString = sqlString.replace("@1", "IBAN = IBAN");}
		if (fechaApertura!=null) {sqlString = sqlString.replace("@2", "FechaApertura="+fechaApertura);} else {sqlString = sqlString.replace("@2", "FechaApertura = FechaApertura");}
		if (activa!=null) {sqlString = sqlString.replace("@3", (activa)? "Activa=1":"Activa=0");} else {sqlString = sqlString.replace("@3", "Activa = Activa");}
		if (interes!=null) {sqlString = sqlString.replace("@4", "Interes="+Float.parseFloat(interes));} else {sqlString = sqlString.replace("@4", "Interes = Interes");}
		statement = con.prepareStatement(sqlString);	
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery();
		while (rs.next()){
        	Cuenta cuenta = new Cuenta();
        	cuenta.setIBAN(rs.getInt("iban"));
        	cuenta.setSWIFT(rs.getString("swift"));
        	cuenta.setFechaApertura(rs.getDate("fechaapertura"));
        	cuenta.setActiva(rs.getBoolean("activa"));
        	cuenta.setSaldoActual(rs.getFloat("saldoactual"));
        	cuenta.setInteres(rs.getFloat("interes"));
        	Cliente c = new Cliente();
        	c.setDNI(rs.getString("Cliente"));
        	Tarjeta t = new Tarjeta();
        	t.setNumero(rs.getInt("tarjeta"));
        	ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
        	tarjetas.add(t);
        	cuenta.setTitular(c);
        	cuenta.setTarjetas(tarjetas);
        	cuentas.add(cuenta);
        }
        rs.close();
        statement.close();  
        return cuentas;
	}
	
	
	/**
	 * Obtiene tarjeta(s) en base a un filtro establecido en la parte del cliente
	 * @param Numero
	 * @param proveedor
	 * @param tipo
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Tarjeta> obtenerTarjeta(String Numero, String proveedor, String tipo) throws SQLException {
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		PreparedStatement statement;
		String sqlString = "SELECT * FROM Tarjeta" +
			" WHERE @1 AND @2 AND @3";
		if (Numero!=null) {sqlString = sqlString.replace("@1", "Numero="+Numero);} else {sqlString = sqlString.replace("@1", "Numero = Numero");}
		if (proveedor!=null) {sqlString = sqlString.replace("@2", "Proveedor="+proveedor);} else {sqlString = sqlString.replace("@2", "Proveedor = Proveedor");}
		if (tipo!=null) {sqlString = sqlString.replace("@3", "Tipo="+tipo);} else {sqlString = sqlString.replace("@3", "Tipo = Tipo");}
		statement = con.prepareStatement(sqlString);	
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()){
			Tarjeta tarjeta = new Tarjeta();
        	tarjeta.setNumero(rs.getInt("numero"));
        	tarjeta.setLimiteExtraccion(rs.getInt("limiteextraccion"));
        	tarjeta.setFechaCaducidad(rs.getDate("fechacaducidad"));
        	tarjeta.setProveedor(EnumProveedores.valueOf(rs.getString("proveedor")));
        	tarjeta.setTipo(TiposTarjeta.valueOf(rs.getString("tipo")));
        	tarjeta.setFechaExpedicion(rs.getDate("fechaexpedicion"));
        	Cuenta c = new Cuenta();
        	c.setIBAN(rs.getInt("cuenta"));
        	tarjeta.setCuenta(c);
        	tarjetas.add(tarjeta);
        }
        rs.close();
        statement.close();  
        return tarjetas;
	}
	
	
	//TODO: Obtener operacion mediante parameros del filtro
	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		GestorBD gbd=new GestorBD();
//		gbd.conectar();
//		ArrayList<Cliente> po = gbd.obtenerCliente("8656565", "Pepe", "Perez", "pepe.perez@pepe.com", "69696", false);
//		ArrayList<Cliente> po = gbd.obtenerCliente("8656565", null, null, null, null, null);
//		System.out.println(po.get(0).getNombre());
//		if (po.size() > 1) {System.out.println(po.get(1).getNombre());}
//		if (po.size() > 2) {System.out.println(po.get(2).getNombre());}
//		gbd.desconectar();
//	}

	// public String obtenerDNI() throws SQLException {
	// String select = "select * from CLIENTE";
	// Statement stmt = con.createStatement();
	// ResultSet rs = stmt.executeQuery(select);
	// String dni = null;
	// if (rs.next()) {
	// dni = rs.getString("dni");
	// }
	// rs.close();
	// stmt.close();
	// return dni;
	// }
	
//	public Cliente obtenerClienteDNI(String dni) throws SQLException {
//		Cliente cliente = null;
//		String select = "select * from CLIENTE where dni='" + dni + "'";
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery(select);
//		if (rs.next()) {
//			cliente = new Cliente();
//			cliente.setDNI(rs.getString("dni"));
//			cliente.setNombre(rs.getString("nombre"));
//			cliente.setApellidos(rs.getString("apellidos"));
//			cliente.setDireccion(rs.getString("direccion"));
//			cliente.setEmail(rs.getString("email"));
//		}
//		rs.close();
//		stmt.close();
//		return cliente;
//	}

//	public ArrayList<Cliente> obtenerClientes(String DNI, String nombre, String apellidos, String email, int movil,
//			boolean empleado) throws SQLException {
//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//		String select = "select * from CLIENTE where nombre like '%?%' and apellidos like '%?%' and email like '%?%' and movil like '%?%' and empleado=?";
//		PreparedStatement ps = con.prepareStatement(select);
//		if(DNI==null){
//			
//		}
//		updateemp.setInt(1, 23);
//		updateemp.setString(2, "Roshan");
//		updateemp.setString(3, "CEO");
//		updateemp.executeUpdate();
//		 ResultSet rs = stmt.executeQuery(select);
//		 while (rs.next()) {
//		 Cliente cliente = new Cliente();
//		 cliente.setDNI(rs.getString("dni"));
//		 cliente.setNombre(rs.getString("nombre"));
//		 cliente.setApellidos(rs.getString("apellidos"));
//		 cliente.setDireccion(rs.getString("direccion"));
//		 cliente.setEmail(rs.getString("email"));
//		 clientes.add(cliente);
//		 }
//		rs.close();
//		stmt.close();
//		return clientes;
//	}

}
