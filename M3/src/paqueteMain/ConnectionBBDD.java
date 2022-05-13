package paqueteMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBBDD {

	private Connection con;
	
	// COST SHIPS
    public static int METAL_COST_LIGTHHUNTER;
    public static int METAL_COST_HEAVYHUNTER;
    public static int METAL_COST_BATTLESHIP;
    public static int METAL_COST_ARMOREDSHIP;
    public static int DEUTERIUM_COST_LIGTHHUNTER;
    public static int DEUTERIUM_COST_HEAVYHUNTER;
    public static int DEUTERIUM_COST_BATTLESHIP;
    public static int DEUTERIUM_COST_ARMOREDSHIP;
    // COST DEFENSES 
    public static int METAL_COST_MISSILELAUNCHER;
    public static int METAL_COST_IONCANNON;
    public static int METAL_COST_PLASMACANNON;
    public static int DEUTERIUM_COST_MISSILELAUNCHER;
    public static int DEUTERIUM_COST_IONCANNON;
    public static int DEUTERIUM_COST_PLASMACANNON;  
    // ARMOR SHIPS
    public static int ARMOR_LIGTHHUNTER = 400;
    public static int ARMOR_HEAVYHUNTER = 1000;
    public static int ARMOR_BATTLESHIP = 6000;
    public static int ARMOR_ARMOREDSHIP = 8000;
    
    // ARMOR DEFENSES
    public static int ARMOR_MISSILELAUNCHER = 200;
    public static int ARMOR_IONCANNON = 1200;
    public static int ARMOR_PLASMACANNON = 7000;
    
    // BASE DAMAGE SHIPS
    public static int BASE_DAMAGE_LIGTHHUNTER = 80;
    public static int BASE_DAMAGE_HEAVYHUNTER = 150;
    public static int BASE_DAMAGE_BATTLESHIP = 1000;
    public static int BASE_DAMAGE_ARMOREDSHIP = 700;    
    // BASE DAMAGE DEFENSES   
    public static int BASE_DAMAGE_MISSILELAUNCHER = 80;
    public static int BASE_DAMAGE_IONCANNON = 250;
    public static int BASE_DAMAGE_PLASMACANNON = 2000;
    
	
	public ConnectionBBDD(String user, String password) {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
        try {
        	
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", user, password);
						
        } catch (SQLException e) {
				
			e.printStackTrace();
		}	
        
        updateData(con);//Se cargan todos los datos de la BBDD
        
	}
	
	public Connection getCon() {
		return this.con;
	}	
	
	
	
	private void updateData(Connection con) {
		
		
		try {
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from ships");
			
			while(result.next()) {
				
				switch(result.getInt(1)) {
				
				case 1:
					METAL_COST_LIGTHHUNTER = result.getInt(3);
					DEUTERIUM_COST_LIGTHHUNTER = result.getInt(4);
					ARMOR_LIGTHHUNTER = result.getInt(6);
					BASE_DAMAGE_LIGTHHUNTER = result.getInt(8);
					break;
				case 2:
					METAL_COST_HEAVYHUNTER = result.getInt(3);
					DEUTERIUM_COST_HEAVYHUNTER = result.getInt(4);
					ARMOR_HEAVYHUNTER = result.getInt(6);
				    BASE_DAMAGE_HEAVYHUNTER = result.getInt(8);
					break;
				case 3:
					METAL_COST_BATTLESHIP = result.getInt(3);
					DEUTERIUM_COST_BATTLESHIP = result.getInt(4);
					ARMOR_BATTLESHIP = result.getInt(6);
					BASE_DAMAGE_BATTLESHIP = result.getInt(8);
					break;
				case 4:
					METAL_COST_ARMOREDSHIP = result.getInt(3);
					DEUTERIUM_COST_ARMOREDSHIP = result.getInt(4);
					ARMOR_ARMOREDSHIP = result.getInt(6);
					BASE_DAMAGE_ARMOREDSHIP = result.getInt(8);
					break;			
				}		
			}
				
			result = statement.executeQuery("select * from defenses");
			
			
			while(result.next()) {
				
				switch(result.getInt(1)) {
				
				case 1:
					METAL_COST_MISSILELAUNCHER = result.getInt(3);
					DEUTERIUM_COST_MISSILELAUNCHER = result.getInt(4);
					ARMOR_MISSILELAUNCHER = result.getInt(6);
					BASE_DAMAGE_MISSILELAUNCHER = result.getInt(8);
					break;
				case 2:
					METAL_COST_IONCANNON = result.getInt(3);
					DEUTERIUM_COST_IONCANNON = result.getInt(4);
					ARMOR_IONCANNON = result.getInt(6);
					BASE_DAMAGE_IONCANNON = result.getInt(8);
					break;
				case 3:
					METAL_COST_PLASMACANNON = result.getInt(3);
					DEUTERIUM_COST_PLASMACANNON = result.getInt(4);		
					ARMOR_PLASMACANNON = result.getInt(6);
					BASE_DAMAGE_PLASMACANNON = result.getInt(8);
					break;	
				}		
			}
									
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}		
		
		
		
		
		
		
		
	}
}
