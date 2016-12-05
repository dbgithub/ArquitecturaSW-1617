package es.deusto.arquiSW.REST.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import es.deusto.arquiSW.REST.classes.Cliente;
import es.deusto.arquiSW.REST.classes.Cuenta;
import es.deusto.arquiSW.REST.classes.Operacion;
import es.deusto.arquiSW.REST.classes.Operacion.EnumTipoOperacion;
import es.deusto.arquiSW.REST.classes.Tarjeta;
import es.deusto.arquiSW.REST.classes.Tarjeta.EnumProveedores;
import es.deusto.arquiSW.REST.classes.Tarjeta.TiposTarjeta;

/**
 * Esta clase gestiona el acceso a la base de datos, asi como de las operaciones
 * CRUD (Create, Read, Update and Delete) La principal diferencia entre
 * executeUpdate y executeQuery es que el primero devuelve un int y el segudno
 * un ResultSet para poder iterar sobre el. Es decir, 'estado de la operacion' y
 * 'conjunto de resultados' respectivamente.
 * 
 * @author aitor & daniel
 *
 */
public class GestorBD {
	private Connection con;

	private String dataSource = "//localhost:3306/ArquitecturaSW";
	private String username = "root";
	private String password = "root";
	private String driver = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql";

	// TODO: Estaria bien implementar un Logger???
	/**
	 * Constructor vacio con los parametros de conexion por defecto
	 */
	public GestorBD() {
	}

	/**
	 * Establecemos los parametros de conexion
	 * 
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
	 * Conectar con la base de datos tras haber establecido los parametros
	 * anteriormente
	 * 
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
	 * 
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		con.close();
	}

	/**
	 * Comprueba si la conexion está abierta o cerrada
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean conexionAbierta() throws SQLException {
		// return con.isValid(8000);
		return (!con.isClosed() || con != null);
	}

	/**
	 * Resetear todas las bases de datos eliminando todos los datos dejandolos
	 * limpios.
	 * 
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

	// ****************************************
	// SELECT queries sin FILTRO (todas las tuplas)

	/**
	 * Obtiene una coleccion de clientes de la base de datos
	 * 
	 * @return una coleccion de clientes
	 * @throws SQLException
	 */
	public ArrayList<Cliente> obtenerClientes() throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM cliente";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
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
	 * 
	 * @return una coleccion de cuentas
	 * @throws SQLException
	 * @throws ParseException
	 */
	public ArrayList<Cuenta> obtenerCuentas() throws SQLException, ParseException {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM cuenta";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			Cuenta cuenta = new Cuenta();
			cuenta.setIBAN(rs.getInt("iban"));
			cuenta.setSWIFT(rs.getString("swift"));
			String date = rs.getString("fechaapertura");
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
			java.util.Date utildate = formatter.parse(date);
			cuenta.setFechaApertura(utildate);
			cuenta.setActiva(rs.getBoolean("activa"));
			cuenta.setSaldoActual(rs.getFloat("saldoactual"));
			cuenta.setInteres(rs.getFloat("interes"));
			Cliente c = new Cliente();
			c.setDNI(rs.getString("Cliente"));
			cuenta.setTitular(c);
			cuentas.add(cuenta);
		}
		rs.close();
		statement.close();
		return cuentas;
	}

	/**
	 * Obtiene una coleccion de operaciones de la base de datos
	 * 
	 * @return una coleccion de operaciones
	 * @throws SQLException
	 */
	public ArrayList<Operacion> obtenerOperaciones() throws SQLException {
		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM operacion";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
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
	 * 
	 * @return una coleccion de tarjetas
	 * @throws SQLException
	 * @throws ParseException
	 */
	public ArrayList<Tarjeta> obtenerTarjetas() throws SQLException, ParseException {
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM tarjeta";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			Tarjeta tarjeta = new Tarjeta();
			tarjeta.setNumero(rs.getInt("numero"));
			tarjeta.setLimiteExtraccion(rs.getInt("limiteextraccion"));
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
			String datecaducidad = rs.getString("fechacaducidad");
			java.util.Date utildatecaducidad = formatter.parse(datecaducidad);
			tarjeta.setFechaCaducidad(utildatecaducidad);
			tarjeta.setProveedor(EnumProveedores.valueOf(rs.getString("proveedor")));
			tarjeta.setTipo(TiposTarjeta.valueOf(rs.getString("tipo")));
			String dateexpedicion = rs.getString("fechaexpedicion");
			java.util.Date utildateexpedicion = formatter.parse(dateexpedicion);
			tarjeta.setFechaExpedicion(utildateexpedicion);
			Cuenta c = new Cuenta();
			c.setIBAN(rs.getInt("cuenta"));
			tarjeta.setCuenta(c);
			tarjetas.add(tarjeta);
		}
		rs.close();
		statement.close();
		return tarjetas;
	}

	// ****************************************
	// INSERT queries

	/**
	 * Desde el lado cliente se carga un XML, este es convertido a objetos Java
	 * mediante JAXB A continuacion, se quiere importar esos objetos en lado
	 * servidor introduciendolos en la base de datos. Si las coleccions de
	 * clientes, cuentas y tarjetas no estan vacias, se llamara a los
	 * respectivos metodos para insertar individualmente las tuplas.
	 * 
	 * @param clientes
	 * @param cuentas
	 * @param tarjetas
	 * @throws SQLException
	 */
	public void importar(ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas, ArrayList<Tarjeta> tarjetas)
			throws SQLException {
		if (!clientes.isEmpty()) {
			insertarClientes(clientes);
		}
		if (!cuentas.isEmpty()) {
			insertarCuentas(cuentas);
		}
		if (!tarjetas.isEmpty()) {
			insertarTarjetas(tarjetas);
		}
	}

	/**
	 * Insertamos cliente(s) en la base de datos
	 * 
	 * @param clientes
	 * @throws SQLException
	 */
	public void insertarClientes(ArrayList<Cliente> clientes) throws SQLException {
		Iterator<Cliente> it = clientes.iterator();
		Statement statement = con.createStatement();
		while (it.hasNext()) {
			Cliente temp = it.next();
			String sqlString = "INSERT INTO cliente "
					+ "(DNI, Nombre, Apellidos, Direccion, email, movil, empleado, PIN) " + "VALUES ('" + temp.getDNI()
					+ "','" + temp.getNombre() + "','" + temp.getApellidos() + "','" + temp.getDireccion() + "','"
					+ temp.getEmail() + "'," + temp.getMovil() + "," + ((temp.isEmpleado()) ? 1 : 0) + ",'"
					+ temp.getPIN() + "')";
			statement.executeUpdate(sqlString);
		}
		statement.close();
	}

	/**
	 * Insertamos cuenta(s) en la base de datos
	 * 
	 * @param cuentas
	 * @throws SQLException
	 */
	public void insertarCuentas(ArrayList<Cuenta> cuentas) throws SQLException {
		Iterator<Cuenta> it = cuentas.iterator();
		Statement statement = con.createStatement();
		while (it.hasNext()) {
			Cuenta temp = it.next();
			String sqlString = "INSERT INTO cuenta "
					+ "(IBAN, SWIFT, FechaApertura, Activa, SaldoActual, Interes, Cliente) " + "VALUES ("
					+ temp.getIBAN() + ",'" + temp.getSWIFT() + "','" + temp.getFechaApertura().toString() + "',"
					+ ((temp.isActiva()) ? 1 : 0) + "," + temp.getSaldoActual() + "," + temp.getInteres() + ",'"
					+ temp.getTitular().getDNI() + "')";
			statement.executeUpdate(sqlString);
		}
		statement.close();
	}

	/**
	 * Insertamos operacion(es) en la base de datos
	 * 
	 * @param cuentas
	 * @throws SQLException
	 */
	public void insertarOperaciones(ArrayList<Operacion> operaciones) throws SQLException {
		Iterator<Operacion> it = operaciones.iterator();
		Statement statement = con.createStatement();
		while (it.hasNext()) {
			Operacion temp = it.next();
			String sqlString = "INSERT INTO operacion " + "(ID, Fecha, Tipo, Importe, Cuenta) " + "VALUES ("
					+ temp.getId() + ",'" + temp.getFecha().toString() + "','" + temp.getTipo().name() + "',"
					+ temp.getImporte() + "," + temp.getCuenta().getIBAN() + ")";
			statement.executeUpdate(sqlString);
		}
		statement.close();
	}

	/**
	 * Insertamos tarjeta(s) en la base de datos
	 * 
	 * @param tarjetas
	 * @throws SQLException
	 */
	public void insertarTarjetas(ArrayList<Tarjeta> tarjetas) throws SQLException {
		Iterator<Tarjeta> it = tarjetas.iterator();
		Statement statement = con.createStatement();
		while (it.hasNext()) {
			Tarjeta temp = it.next();
			String sqlString = "INSERT INTO tarjeta "
					+ "(Numero, LimiteExtraccion, FechaCaducidad, Proveedor, Tipo, FechaExpedicion, Cuenta) "
					+ "VALUES (" + temp.getNumero() + "," + temp.getLimiteExtraccion() + ",'"
					+ temp.getFechaCaducidad().toString() + "','" + temp.getProveedor().name() + "','"
					+ temp.getTipo().name() + "','" + temp.getFechaExpedicion().toString() + "',"
					+ temp.getCuenta().getIBAN() + ")";
			statement.executeUpdate(sqlString);
		}
		statement.close();
	}

	// ****************************************
	// SELECT queries con FILTRO

	/**
	 * Obtiene cliente(s) en base a un filtro establecido en la parte cliente.
	 * 
	 * @param DNI
	 * @param Nombre
	 * @param Apellidos
	 * @param email
	 * @param movil
	 * @param empleado
	 * @return una coleccion de clientes
	 * @throws SQLException
	 */
	public ArrayList<Cliente> obtenerCliente(String DNI, String Nombre, String Apellidos, String email, String movil,
			Boolean empleado) throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement statement;
		String sqlString = "SELECT * FROM cliente" + " WHERE @1 AND @2 AND @3 AND @4 AND @5 AND @6";
		if (DNI != null) {
			sqlString = sqlString.replace("@1", "Dni=" + DNI);
		} else {
			sqlString = sqlString.replace("@1", "Dni = Dni");
		}
		if (Nombre != null) {
			sqlString = sqlString.replace("@2", "Nombre=" + Nombre);
		} else {
			sqlString = sqlString.replace("@2", "Nombre = Nombre");
		}
		if (Apellidos != null) {
			sqlString = sqlString.replace("@3", "Apellidos=" + Apellidos);
		} else {
			sqlString = sqlString.replace("@3", "Apellidos = Apellidos");
		}
		if (email != null) {
			sqlString = sqlString.replace("@4", "Email=" + email);
		} else {
			sqlString = sqlString.replace("@4", "Email = Email");
		}
		if (movil != null) {
			sqlString = sqlString.replace("@5", "Movil=" + movil);
		} else {
			sqlString = sqlString.replace("@5", "Movil = Movil");
		}
		if (empleado != null) {
			sqlString = sqlString.replace("@6", (empleado) ? "Empleado=1" : "Empleado=0");
		} else {
			sqlString = sqlString.replace("@6", "Empleado = Empleado");
		}
		statement = con.prepareStatement(sqlString);
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
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
	 * Obtiene cuenta(s) en base a un filtro estableido en la parte cliente.
	 * 
	 * @param IBAN
	 * @param fechaApertura
	 * @param activa
	 * @param interes
	 * @return una coleccion de cuentas
	 * @throws SQLException
	 * @throws ParseException
	 */
	public ArrayList<Cuenta> obtenerCuenta(String IBAN, String DNI, String fechaApertura, Boolean activa,
			String interes) throws SQLException, ParseException {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		PreparedStatement statement;
		String sqlString = "SELECT * FROM cuenta" + " WHERE @1 AND @2 AND @3 AND @4 AND @5";
		if (IBAN != null) {
			sqlString = sqlString.replace("@1", "IBAN=" + IBAN);
		} else {
			sqlString = sqlString.replace("@1", "IBAN = IBAN");
		}
		if (DNI != null) {
			sqlString = sqlString.replace("@2", "Cliente=" + DNI);
		} else {
			sqlString = sqlString.replace("@2", "Cliente = Cliente");
		}
		if (fechaApertura != null) {
			sqlString = sqlString.replace("@3", "FechaApertura=" + fechaApertura);
		} else {
			sqlString = sqlString.replace("@3", "FechaApertura = FechaApertura");
		}
		if (activa != null) {
			sqlString = sqlString.replace("@4", (activa) ? "Activa=1" : "Activa=0");
		} else {
			sqlString = sqlString.replace("@4", "Activa = Activa");
		}
		if (interes != null) {
			sqlString = sqlString.replace("@5", "Interes=" + Float.parseFloat(interes));
		} else {
			sqlString = sqlString.replace("@5", "Interes = Interes");
		}
		statement = con.prepareStatement(sqlString);
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Cuenta cuenta = new Cuenta();
			cuenta.setIBAN(rs.getInt("iban"));
			cuenta.setSWIFT(rs.getString("swift"));
			String date = rs.getString("fechaapertura");
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
			java.util.Date utildate = formatter.parse(date);
			cuenta.setFechaApertura(utildate);
			cuenta.setActiva(rs.getBoolean("activa"));
			cuenta.setSaldoActual(rs.getFloat("saldoactual"));
			cuenta.setInteres(rs.getFloat("interes"));
			Cliente c = new Cliente();
			c.setDNI(rs.getString("Cliente"));
			cuenta.setTitular(c);
			cuentas.add(cuenta);
		}
		rs.close();
		statement.close();
		return cuentas;
	}

	/**
	 * Obtiene cuenta(s) en base al IBAN de una cuenta.
	 * 
	 * @return una coleccion de operaciones
	 * @throws SQLException
	 */
	public ArrayList<Operacion> obtenerOperacion(String IBAN) throws SQLException {
		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		Statement statement = con.createStatement();
		String sqlString = "SELECT * FROM operacion WHERE Cuenta=" + IBAN;
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
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
	 * Obtiene tarjeta(s) en base a un filtro establecido en la parte del
	 * cliente
	 * 
	 * @param Numero
	 * @param proveedor
	 * @param tipo
	 * @return una coleccion de tarjetas
	 * @throws SQLException
	 * @throws ParseException
	 */
	public ArrayList<Tarjeta> obtenerTarjeta(String Numero, String DNI, String proveedor, String tipo)
			throws SQLException, ParseException {
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		PreparedStatement statement;
		String sqlString = "SELECT newtable.Numero, newtable.LimiteExtraccion, newtable.FechaCaducidad, newtable.Proveedor, newtable.Tipo, "
				+ "newtable.FechaExpedicion, newtable.Cuenta FROM"
				+ "(SELECT * FROM tarjeta INNER JOIN cuenta ON tarjeta.Cuenta = cuenta.IBAN) as newtable"
				+ " WHERE @1 AND @2 AND @3 AND @4";
		if (Numero != null) {
			sqlString = sqlString.replace("@1", "Numero=" + Numero);
		} else {
			sqlString = sqlString.replace("@1", "Numero = Numero");
		}
		if (DNI != null) {
			sqlString = sqlString.replace("@2", "Cliente=" + DNI);
		} else {
			sqlString = sqlString.replace("@2", "Cliente = Cliente");
		}
		if (proveedor != null) {
			sqlString = sqlString.replace("@3", "Proveedor=" + proveedor);
		} else {
			sqlString = sqlString.replace("@3", "Proveedor = Proveedor");
		}
		if (tipo != null) {
			sqlString = sqlString.replace("@4", "Tipo=" + tipo);
		} else {
			sqlString = sqlString.replace("@4", "Tipo = Tipo");
		}
		statement = con.prepareStatement(sqlString);
		System.out.println("sql string: " + sqlString);
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			Tarjeta tarjeta = new Tarjeta();
			tarjeta.setNumero(rs.getInt("Numero"));
			tarjeta.setLimiteExtraccion(rs.getInt("LimiteExtraccion"));
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
			String datecaducidad = rs.getString("fechacaducidad");
			java.util.Date utildatecaducidad = formatter.parse(datecaducidad);
			tarjeta.setFechaCaducidad(utildatecaducidad);
			tarjeta.setProveedor(EnumProveedores.valueOf(rs.getString("Proveedor")));
			tarjeta.setTipo(TiposTarjeta.valueOf(rs.getString("Tipo")));
			String dateexpedicion = rs.getString("fechaexpedicion");
			java.util.Date utildateexpedicion = formatter.parse(dateexpedicion);
			tarjeta.setFechaExpedicion(utildateexpedicion);
			Cuenta c = new Cuenta();
			c.setIBAN(rs.getInt("Cuenta"));
			tarjeta.setCuenta(c);
			tarjetas.add(tarjeta);
		}
		rs.close();
		statement.close();
		return tarjetas;
	}

	// ****************************************
	// UPDATE queries

	/**
	 * Actualiza el cliente con el determinado DNI y los campos correspondientes
	 * al cliente
	 * 
	 * @param c
	 * @throws SQLException
	 */
	public void updateCliente(Cliente c) throws SQLException {
		String sqlupdate = "UPDATE cliente SET Nombre = ?, Apellidos = ?, Direccion = ?, Email = ?, Movil = ?, Empleado = ?, PIN = ? "
				+ "WHERE DNI = " + c.getDNI();
		PreparedStatement statement = con.prepareStatement(sqlupdate);
		statement.setString(1, c.getNombre());
		statement.setString(2, c.getApellidos());
		statement.setString(3, c.getDireccion());
		statement.setString(4, c.getEmail());
		statement.setInt(5, c.getMovil());
		statement.setBoolean(6, c.isEmpleado());
		statement.setInt(7, c.getPIN());
		statement.executeUpdate();
		statement.close();
	}

	/**
	 * Actualiza la cuenta con el determinado IBAN y los campos correspondientes
	 * a la cuenta
	 * 
	 * @param cu
	 * @throws SQLException
	 */
	public void updateCuenta(Cuenta cu) throws SQLException {
		String sqlupdate = "UPDATE cuenta SET SWIFT = ?, FechaApertura = ?, Activa = ?, SaldoActual = ?, Interes = ?, Cliente = ? "
				+ "WHERE IBAN = " + cu.getIBAN();
		PreparedStatement statement = con.prepareStatement(sqlupdate);
		statement.setString(1, cu.getSWIFT());
		statement.setString(2, cu.getFechaApertura().toString());
		statement.setBoolean(3, cu.isActiva());
		statement.setFloat(4, cu.getSaldoActual());
		statement.setFloat(5, cu.getInteres());
		statement.setString(6, cu.getTitular().getDNI());
		statement.executeUpdate();
		statement.close();
	}

	/**
	 * Actualiza la tarjeta con el determinado Numero de tarjeta y los campos
	 * correspondientes a la tarjeta
	 * 
	 * @param t
	 * @throws SQLException
	 */
	public void updateTarjeta(Tarjeta t) throws SQLException {
		String sqlupdate = "UPDATE tarjeta SET LimiteExtraccion = ?, FechaCaducidad = ?, Proveedor = ?, Tipo = ?, FechaExpedicion = ?, Cuenta = ? "
				+ "WHERE Numero = " + t.getNumero();
		PreparedStatement statement = con.prepareStatement(sqlupdate);
		statement.setInt(1, t.getLimiteExtraccion());
		statement.setString(2, t.getFechaCaducidad().toString());
		statement.setString(3, t.getProveedor().name());
		statement.setString(4, t.getTipo().name());
		statement.setString(5, t.getFechaExpedicion().toString());
		statement.setInt(6, t.getCuenta().getIBAN());
		statement.executeUpdate();
		statement.close();
	}

	// ****************************************
	// DELETE queries

	/**
	 * Elimina el cliente con el correspondiente DNI
	 * 
	 * @param DNI
	 * @throws SQLException
	 */
	public void deleteCliente(String DNI) throws SQLException {
		Statement statement = con.createStatement();
		String sqldelete = "DELETE FROM cliente WHERE DNI = " + DNI;
		statement.executeUpdate(sqldelete);
	}

	/**
	 * Elimina la cuenta con el correspondiente IBAN
	 * 
	 * @param IBAN
	 * @throws SQLException
	 */
	public void deleteCuenta(String IBAN) throws SQLException {
		Statement statement = con.createStatement();
		String sqldelete = "DELETE FROM cuenta WHERE IBAN = " + IBAN;
		statement.executeUpdate(sqldelete);
	}

	/**
	 * Elimina la tarjeta con el correspondiente numero de tarjeta
	 * 
	 * @param num
	 * @throws SQLException
	 */
	public void deleteTarjeta(String num) throws SQLException {
		Statement statement = con.createStatement();
		String sqldelete = "DELETE FROM tarjeta WHERE Numero = " + num;
		statement.executeUpdate(sqldelete);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GestorBD gbd = new GestorBD();
		gbd.conectar();
		// // Variables auxiliares
		// Cuenta aux = new Cuenta();
		// aux.setIBAN(454545);
		// ArrayList<Cuenta> auxlista = new ArrayList<Cuenta>();
		// auxlista.add(aux);
		// Cliente tempc = new Cliente("9898989", "Danielo", "Guzman", "Colegio
		// mayor Deusto", "d.g@hola.com", 69455454,false,9876,auxlista);
		// gbd.updateCliente(tempc);
		// Cuenta tempcu = new Cuenta(454545, "SXXKUTXA-09", new
		// Date(2016,11,17), true, 2122f, 0.7f, tempc, null, null);
		// gbd.updateCuenta(tempcu);
		// // Aux
		// Calendar calen1 = Calendar.getInstance();
		// calen1.set(2020, 11, 17);
		// Calendar calen2 = Calendar.getInstance();
		// calen2.set(2016, 11, 17);
		// Tarjeta tempt = new
		// Tarjeta(555556,tempcu,1300,calen2.getTime(),EnumProveedores.AmericanExpress,TiposTarjeta.Credito,calen2.getTime());
		// gbd.updateTarjeta(tempt);
		// System.out.println(gbd.obtenerTarjeta("555556",null,null,null));

		// System.out.println(gbd.obtenerTarjeta("555556", null, null,
		// null).size());

		gbd.desconectar(	);
	}

}
