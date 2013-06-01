package br.com.caelum.tarefas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21",
					"root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
