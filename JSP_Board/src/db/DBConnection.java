package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

	static final String URL = "jdbc:mariadb://localhost:3306/jsp_board";
	static final String DB_USER = "root";
	static final String DB_PWD = "1234";
	static private Connection dbConn = null;

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException{

		// DB Driver Class Load
		Class.forName("org.mariadb.jdbc.Driver");
		
		//URL, ID, PWD Set And Get Connection
		dbConn = DriverManager.getConnection(URL, DB_USER, DB_PWD);
	
		return dbConn;

	}

}
