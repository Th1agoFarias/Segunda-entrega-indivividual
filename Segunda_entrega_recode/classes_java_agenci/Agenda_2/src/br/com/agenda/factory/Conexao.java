package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Fariasneo0810.";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

	public static Connection createConnectionToMySQL() throws Exception {
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}

}