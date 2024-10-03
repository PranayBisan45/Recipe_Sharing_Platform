package com.codon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/Recipe";
	private static final String user ="postgres";
	private static final String password = "123456";
	
	public static Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(URL,user,password);
	}
}