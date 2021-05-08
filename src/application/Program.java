package application;

import java.sql.Connection;

import dbProperties.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
