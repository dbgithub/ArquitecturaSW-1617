package dao;

import java.sql.*;
import java.util.ArrayList;

import sw.Cliente;

public class GestorBD {
	private Connection con;

	private String dataSource = "//localhost/ArquitecturaSW";
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
	
	public String obtenerDNI()throws SQLException{
		
    	String select = "select dni from CLIENTE";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        String dni= rs.getString("dni");
        	
       
        rs.close();
        stmt.close();  
        return dni;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GestorBD gbd=new GestorBD();
		gbd.conectar();
		System.out.println(gbd.obtenerDNI());
		gbd.desconectar();
	}
}
