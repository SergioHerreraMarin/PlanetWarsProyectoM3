package paqueteMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class TerminalGame implements Variables{
	static Connection con;
	static Scanner input = new Scanner(System.in);
	static Statement statement;
	static ResultSet result;
	static int id_user;
public static void main(String[] args) throws SQLException {
	//CONNECTION ################################################################################################################################
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "PLANETWARS", "PLANETWARS");
		System.out.println("CONNECTED");
	} 
	catch (SQLException e) {
		System.out.println("ERROR:_CONNECTION FAILED_");
		System.exit(0);
		e.printStackTrace();
	}
	Statement statement = con.createStatement();
	//MENU LOGIN/REGISTER #######################################################################################################################
	boolean valid = false;
	String username = null;
	while (valid == false) {
	valid = true;
	System.out.println(" ");
	System.out.println("IDENTIFICATION MENU");
	System.out.println("1)LOGIN");
	System.out.println("2)REGISTER");
	System.out.println("");
	System.out.println("Option:");
	String option = input.next();
	if (option.contains("1")) { //login
		//LOGIN #####################################################################################################################################
		System.out.println(" ");
		System.out.println("LOGIN");
		System.out.println("Username:");
		username = input.next();
		System.out.println("Password:");
		String password = input.next();
		result = statement.executeQuery("select count(user_name) from users where user_name = '"+username+"' and user_password = '"+password+"'");
		result.next();
		if (result.getInt(1) != 1) {
			valid = false;
			System.out.println("ERROR:_USUARI NO REGISTRAT O CONTRASENYA INCORRECTA_");
		}
		result = statement.executeQuery("select id_user from users where user_name = '"+username+"'");
		}
	
	else if (option.contains("2")) { //register
		//REGISTRO ##################################################################################################################################
		valid = false;
		System.out.println("Username:");
		username = input.next();
		System.out.println("Password:");
		String password = input.next();
		result = statement.executeQuery("select max(id_user)+1 from users");
		result.next();
		String id = String.valueOf(result.getInt(1));
		System.out.println(id);
		statement.executeUpdate(String.valueOf("insert into users (id_user,user_name,user_password,birth_date) values ("+id+",'"+username+"','"+password+"',null)"));
		result = statement.executeQuery("select id_user from users where user_name = '"+username+"'");
		System.out.println("User added");
	}
	else {
		System.out.println("ERROR:_INVALID OPTION_");
	}
	}//while valid
	System.out.println("\nWELCOME");
	result = statement.executeQuery("select id_user from users where user_name = '"+username+"'");
	result.next();
	id_user = result.getInt(1);
	
	
	//ESCOGER PLANETA ###########################################################################################################################
	System.out.println("");
	System.out.println("PLANET MENU");
	System.out.println("+)Create planet");
	
	//Sacar ids de planeta
	ArrayList<String> planetIdList = new ArrayList<String>(0);
	result = statement.executeQuery("select * from planets where id_user = "+id_user);
	while (result.next() == true) {
		planetIdList.add(String.valueOf(result.getInt(1)));
	}
	//impressió planetes com a opcions de la llista mostrant el seu nom
	String planetName = null;
	if (planetIdList.size() != 0) {
		result = statement.executeQuery("select planet_name from planets where id_user = "+id_user);
		result.next();
		for (int a = 0; a == planetIdList.size()-1 ; a++) {
			planetName = result.getString(1);
			System.out.println(planetIdList.get(a)+")Planet "+planetName);
			result.next();
		}
	};
	String option = input.next();
	//CREAR PLANETA ############################################################################################################################
	if (option.contains("+")) {//create planet
		System.out.println("");
		System.out.println("!!!A new planet has been found!!!");
		valid = false;
		while (valid == false) {
			valid = true;
			System.out.println("What do you wanna name it?");
			planetName = input.next();
			result = statement.executeQuery("select count(planet_name) from planets where planet_name = '"+planetName+"'");
			result.next();
			if (result.getInt(1) != 0) {
				System.out.println("ERROR:_There is a planet already named like that_\nPlease, choose another name");
				valid = false;
			}
		}//nom valid
		System.out.println("Analyzing and registering planet...");
		result = statement.executeQuery("select max(id_planet) from planets where planet_name = '"+planetName+"'");
		result.next();
		int id = result.getInt(1);
		Planet currentPlanet = new Planet(planetName);
		statement.executeUpdate(String.valueOf("insert into planets (ID_PLANET,PLANET_NAME,TECH_ATTACK,TECH_DEFENSE,TECH_ATTACK_UPGRADE_COST,TECH_DEFENSE_UPGRADE_COST,DEUTERIUM,METAL,CRYSTAL,ID_USER) values ("+id+",'"+currentPlanet.getName()+"',"+currentPlanet.getTechnologyAtack()+","+currentPlanet.getTechnologyDefense()+","+Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST+","+Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST+","+currentPlanet.getDeuterium()+","+currentPlanet.getMetal()+","+0+","+id_user+")"));
		System.out.println("Analisis complete");
	}
	else if (planetIdList.contains(option)) {//choose planet with id
		System.out.println("Landed onto planet "+planetName);
		//abre planetstatus con planeta id option
	}
	else {
		System.out.println("ERROR:_INVALID OPTION_");
	}
	
	//###########################################################################################################################################
	
}//main method

}//main class
