package paqueteMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBBDD {

	private static Connection con;
	
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
    public static int ARMOR_LIGTHHUNTER;
    public static int ARMOR_HEAVYHUNTER;
    public static int ARMOR_BATTLESHIP;
    public static int ARMOR_ARMOREDSHIP;
    
    // ARMOR DEFENSES
    public static int ARMOR_MISSILELAUNCHER;
    public static int ARMOR_IONCANNON;
    public static int ARMOR_PLASMACANNON;
    
    // BASE DAMAGE SHIPS
    public static int BASE_DAMAGE_LIGTHHUNTER;
    public static int BASE_DAMAGE_HEAVYHUNTER;
    public static int BASE_DAMAGE_BATTLESHIP;
    public static int BASE_DAMAGE_ARMOREDSHIP;    
    // BASE DAMAGE DEFENSES   
    public static int BASE_DAMAGE_MISSILELAUNCHER;
    public static int BASE_DAMAGE_IONCANNON;
    public static int BASE_DAMAGE_PLASMACANNON;
    // PLANET TECHNOLOGY COST
    public static int UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
    public static int UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
    public static int UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
    public static int UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
	
    
    
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
									
			
			result = statement.executeQuery("select * from defenses");	
			
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}		
			
		
	}
	
	public static ResultSet SelectQuery(Connection con, String query) {
		
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			stmnt=con.createStatement();//conectar statement con la base de datos
			rs=stmnt.executeQuery(query);//ejecutar query
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void insertPlanetTechnologyDefense(int planetId, int lvl) {
		
		try {
			
			Statement statement = con.createStatement();
			statement.executeUpdate("insert into planets(id_planet, tech_defense) values(" + planetId + "," + lvl + ")");
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void insertPlanetTechnologyAttack(int planetId, int lvl) {
		
		try {
			
			Statement statement = con.createStatement();
			statement.executeUpdate("insert into planets(id_planet, tech_attack) values(" + planetId + "," + lvl + ")");
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
	public static void insertarNuevoUsuario(int idUser, String userName, String password, String date) {
		
		try {
			
			Statement statement = con.createStatement();
			PreparedStatement preStatement = con.prepareStatement("insert into users(ID_USER, USER_NAME, USER_PASSWORD, BIRTH_DATE) values(?,?,?,?)");
			preStatement.setInt(1, idUser);
			preStatement.setString(2, userName);
			preStatement.setString(3, password);
			preStatement.setString(4, date);
			preStatement.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

	
	
}
