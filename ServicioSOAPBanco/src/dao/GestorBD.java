package dao;

import java.sql.*;
import java.util.ArrayList;

import sw.Cliente;

public class GestorBD {
	private Connection con;

	private String dataSource = "//localhost:3306/ArquitecturaSW";
	private String username = "root";
	private String password = "root";
	private String driver = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql";

	public GestorBD() {
	}

	public GestorBD(String dataSource, String username, String password) {
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
	}

	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		String url = protocol + ":" + dataSource;
		con = DriverManager.getConnection(url, username, password);
	}

	public void desconectar() throws SQLException {
		con.close();
	}

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
	public Cliente obtenerClienteDNI(String dni) throws SQLException {
		Cliente cliente = null;
		String select = "select * from CLIENTE where dni='" + dni + "'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(select);
		if (rs.next()) {
			cliente = new Cliente();
			cliente.setDNI(rs.getString("dni"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setEmail(rs.getString("email"));
		}
		rs.close();
		stmt.close();
		return cliente;
	}

	public ArrayList<Cliente> obtenerClientes() throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String select = "select * from CLIENTE";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setDNI(rs.getString("dni"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setEmail(rs.getString("email"));
			clientes.add(cliente);
		}
		rs.close();
		stmt.close();
		return clientes;
	}


}
