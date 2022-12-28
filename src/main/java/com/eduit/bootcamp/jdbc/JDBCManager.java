package com.eduit.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCManager {

	public static Connection getConnection(final Properties prop) throws Exception {
		
		java.lang.String dbDriver = prop.getProperty("db.driver");
		String usr = prop.getProperty("db.user");
		String pwd = prop.getProperty("db.pwd");
		String dbName = prop.getProperty("db.dbName");
		String host = prop.getProperty("db.host");
		String port = prop.getProperty("db.port");
		
		// jdbc:mysql://localhost:3306/sistemaadministrativo
		
		String jdbcUrl = new StringBuilder()
				.append("jdbc:mysql://")
				.append(host)
				.append(":")
				.append(port)
				.append("/")
				.append(dbName)
				.toString();
		dbDriver.split(".");
	
		Connection cnx = DriverManager.getConnection(jdbcUrl, usr, pwd);
		
		return cnx;
	}

}
