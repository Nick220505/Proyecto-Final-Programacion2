package co.edu.unbosque.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class MySQLDB<T extends Object> {

	private final String cxString = "jdbc:mysql://localhost:3306/forrestm?serverTimezone=UTC&useSSL=false";
	private final String user = "root";
	private final String pass = "";
	private Connection con = null;
	private Statement stmt;
	private ResultSet rs;

	public void conectar() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(cxString, user, pass);
	}

	public void insertarDB(String cadena) throws Exception {
		conectar();
		stmt = con.createStatement();
		stmt.executeUpdate(cadena);
		con.close();
	}
	
	public Optional<T> consultarFilaDB(String cadena, RowMapper<T> rm) throws Exception {
		T objeto = null;
		conectar();
		stmt = con.createStatement();
		rs = stmt.executeQuery(cadena);
		if (rs.next()) {
			objeto = rm.mapRow(rs);
		}
		return Optional.ofNullable(objeto);
	}
	
	public ArrayList<T> consultarTablaDB(String cadena, RowMapper<T> rm) throws Exception {
		ArrayList<T> listaObjetos = new ArrayList<>();
		conectar();
		stmt = con.createStatement();
		rs = stmt.executeQuery(cadena);
		while (rs.next()) {
			T objeto = rm.mapRow(rs);
			listaObjetos.add(objeto);
		}
		return listaObjetos;
	}
}
