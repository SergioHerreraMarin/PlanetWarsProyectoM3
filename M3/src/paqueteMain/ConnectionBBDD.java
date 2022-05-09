package paqueteMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBBDD {

	private Connection con;
	
	public ConnectionBBDD(String user, String password) {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
        try {
        	
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", user, password);
						
        } catch (SQLException e) {
				
			e.printStackTrace();
		}	
	}
	
	
	public Connection getCon() {
		return this.con;
	}
	
	
}
