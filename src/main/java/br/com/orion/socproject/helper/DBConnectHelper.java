package br.com.orion.socproject.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBConnectHelper {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:6543/soc";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "postgre";
	private static  Connection conn;

	static {
		try {
			Class.forName(DRIVER);

		} catch (ClassNotFoundException ex) {
			log.error(DBConnectHelper.class.getName(),  ex);
		}
	}

	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(CONNECTION_STRING, USUARIO, SENHA);
		return conn;
	}

}
