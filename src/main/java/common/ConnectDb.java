package common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.MstCustomerDAO;

public class ConnectDb {
    
	public static Connection getConnect() throws ClassNotFoundException {

		Connection con = null;
		
		try {
			java.security.Security.setProperty("jdk.tls.disabledAlgorithms","SSLv3, RC4, DES, MD5withRSA, DH keySize < "
					+ "1024,EC keySize < 224, 3DES_EDE_CBC, anon, NULL");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      String dbURL = "jdbc:sqlserver://NGHIAPHAM\\SQLEXPRESS:1433;databaseName=test;user=sa;password=123";
		        String user = "sa";
		        String pass = "123";
		        
		        con = DriverManager.getConnection(dbURL);
		        if(con != null) {
		        	DatabaseMetaData dm = con.getMetaData();
	                System.out.println("Driver name: " + dm.getDriverName());
	                System.out.println("Driver version: " + dm.getDriverVersion());
	                System.out.println("Product name: " + dm.getDatabaseProductName());
	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
		        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
