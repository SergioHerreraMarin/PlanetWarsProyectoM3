package paqueteMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			// COST SHIPS
			CallableStatement getCostShips = con.prepareCall("{call get_cost_ships (?,?,?)}");
			getCostShips.setInt(1, 1);
			
			getCostShips.registerOutParameter(2, java.sql.Types.INTEGER);
			getCostShips.registerOutParameter(3, java.sql.Types.INTEGER);
			
			getCostShips.execute();
			METAL_COST_LIGTHHUNTER = getCostShips.getInt(2);
			DEUTERIUM_COST_LIGTHHUNTER = getCostShips.getInt(3);
					
			getCostShips.setInt(1, 2);
			getCostShips.execute();
			METAL_COST_HEAVYHUNTER = getCostShips.getInt(2);
			DEUTERIUM_COST_HEAVYHUNTER = getCostShips.getInt(3);
		
			getCostShips.setInt(1, 3);
			getCostShips.execute();
			METAL_COST_BATTLESHIP = getCostShips.getInt(2);
			DEUTERIUM_COST_BATTLESHIP = getCostShips.getInt(3);
			
			getCostShips.setInt(1, 4);
			getCostShips.execute();
			METAL_COST_ARMOREDSHIP = getCostShips.getInt(2);
			DEUTERIUM_COST_ARMOREDSHIP = getCostShips.getInt(3);

			// COST DEFENSES 
			CallableStatement getCostDefenses = con.prepareCall("{call get_cost_defenses (?,?,?)}");
			getCostDefenses.setInt(1, 1);
			
			getCostDefenses.registerOutParameter(2, java.sql.Types.INTEGER);
			getCostDefenses.registerOutParameter(3, java.sql.Types.INTEGER);
			
			getCostDefenses.execute();	
			METAL_COST_MISSILELAUNCHER = getCostDefenses.getInt(2);
			DEUTERIUM_COST_MISSILELAUNCHER = getCostDefenses.getInt(3);
			
			getCostDefenses.setInt(1, 2);
			getCostDefenses.execute();	
			METAL_COST_IONCANNON = getCostDefenses.getInt(2);
			DEUTERIUM_COST_IONCANNON = getCostDefenses.getInt(3);
		
			getCostDefenses.setInt(1, 3);
			getCostDefenses.execute();	
			METAL_COST_PLASMACANNON = getCostDefenses.getInt(2);
			DEUTERIUM_COST_PLASMACANNON = getCostDefenses.getInt(3);

			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}
}
