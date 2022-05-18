package paqueteMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TerminalGame implements Variables{
	static Connection con;
	static Scanner input = new Scanner(System.in);
	static Statement statement;
	static ResultSet result;
	static int id_user;
	static Planet currentPlanet;
	static ConnectionBBDD ConnectionBBDD;
	static int rep = 0;
public static void main(String[] args) throws SQLException, ResourceException {
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
	ConnectionBBDD = new ConnectionBBDD(con);
	//MENU LOGIN/REGISTER #######################################################################################################################
	boolean valid = false;
	String username = null;
	while (valid == false) {
	valid = true;
	System.out.println(" ");
	System.out.println("#########################################################################################################################");
	System.out.println("IDENTIFICATION MENU");
	System.out.println("1)LOGIN");
	System.out.println("2)REGISTER");
	System.out.println("");
	System.out.println("Option:");
	String option = input.next();
	if (option.equals("1")) { //login
		//LOGIN #####################################################################################################################################
		System.out.println(" ");
		System.out.println("#########################################################################################################################");
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
	
	else if (option.equals("2")) { //register
		//REGISTRO ##################################################################################################################################
		valid = false;
		System.out.println(" ");
		System.out.println("#########################################################################################################################");
		System.out.println("REGISTER NEW USER");
		System.out.println("Username:");
		username = input.next();
		System.out.println("Password:");
		String password = input.next();
		result = statement.executeQuery("select max(id_user)+1 from users");
		result.next();
		String id = String.valueOf(result.getInt(1));
		statement.executeUpdate(String.valueOf("insert into users (id_user,user_name,user_password,birth_date) values ("+id+",'"+username+"','"+password+"',null)"));
		result = statement.executeQuery("select id_user from users where user_name = '"+username+"'");
		System.out.println("User added");
	}
	else {
		System.out.println("ERROR:_INVALID OPTION_");
		valid = false;
	}
	}//while valid
	System.out.println("#########################################################################################################################");
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
		for (int a = 0; a < planetIdList.size() ; a++) {
			planetName = result.getString(1);
			System.out.println(planetIdList.get(a)+")Planet "+planetName);
			result.next();
		}
	};
	String option = input.next();
	//CREAR PLANETA ############################################################################################################################
	if (option.equals("+")) {//create planet
		System.out.println("");
		System.out.println("#########################################################################################################################");
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
		result = statement.executeQuery("select max(id_planet)+1 from planets");
		result.next();
		int id = result.getInt(1);
		currentPlanet = new Planet(planetName);
		statement.executeUpdate(String.valueOf("insert into planets (ID_PLANET,PLANET_NAME,TECH_ATTACK,TECH_DEFENSE,TECH_ATTACK_UPGRADE_COST,TECH_DEFENSE_UPGRADE_COST,DEUTERIUM,METAL,CRYSTAL,ID_USER) values ("+id+",'"+currentPlanet.getName()+"',"+currentPlanet.getTechnologyAtack()+","+currentPlanet.getTechnologyDefense()+","+Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST+","+Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST+","+currentPlanet.getDeuterium()+","+currentPlanet.getMetal()+","+0+","+id_user+")"));
		int planetMetal = currentPlanet.getMetal();
		int planetDeuterium = currentPlanet.getDeuterium();
		//Generació nau i defensa mínima ========================================================================================================
		currentPlanet.newLigthHunter(1);
		currentPlanet.setMetal(planetMetal);
		currentPlanet.setDeuterium(planetDeuterium);
		currentPlanet.newMissileLauncher(1);
		currentPlanet.setMetal(planetMetal);
		currentPlanet.setDeuterium(planetDeuterium);
		System.out.println("Analisis complete");
	}
	//SELECCIONAR PLANETA EXISTENTE #############################################################################################################
	else if (planetIdList.contains(option)) {//choose planet with id
		//obtenció id planeta
		result = statement.executeQuery("select planet_name from planets where id_planet = "+option);
		result.next();
		planetName = result.getString(1);
		//RECUPERACIO PLANETA DE LA BBDD ========================================================================================================
		currentPlanet = new Planet(planetName);
		result = statement.executeQuery("select * from planets where planet_name = '"+planetName+"'");
		result.next();
		int planetDeuterium = result.getInt(7);
		int planetMetal = result.getInt(8);
		currentPlanet.setTechnologyAtack(result.getInt(3));
		currentPlanet.setTechnologyDefense(result.getInt(4));
		//RECUPERACIO ARMY =====================================================================================================================
		result = statement.executeQuery("select id_planet from planets where planet_name = '"+planetName+"'");
		result.next();
		int id_planet = result.getInt(1);
		//ships
		result = statement.executeQuery("select * from planet_ships where id_planet = "+id_planet);
		currentPlanet.setMetal(1000000);
		currentPlanet.setDeuterium(1000000);
		while (result.next()) {
			String shipType = result.getString(2);
			if (shipType.equals("Light hunter")) {
				currentPlanet.newLigthHunter(1);
				currentPlanet.setMetal(1000000);
				currentPlanet.setDeuterium(1000000);
				}
			else if (shipType.equals("Heavy Hunter")) {
					currentPlanet.newHeavyHunter(1);
					currentPlanet.setMetal(1000000);
					currentPlanet.setDeuterium(1000000);
				}
			else if (shipType.equals("Battle Ship")) {
					currentPlanet.newBattleShip(1);
					currentPlanet.setMetal(1000000);
					currentPlanet.setDeuterium(1000000);
				}
			else if (shipType.equals("Armored Ship")) {
					currentPlanet.newArmoredShip(1);
					currentPlanet.setMetal(1000000);
					currentPlanet.setDeuterium(1000000);
				}
			}
		//RECUPERACIO DEFENSES  =====================================================================================================================
				//defenses
				result = statement.executeQuery("select * from planet_defenses where id_planet = "+id_planet);
				while (result.next()) {
					String type = result.getString(2);
					if (type.equals("Missile Launcher")) {
						currentPlanet.newMissileLauncher(1);
						currentPlanet.setMetal(1000000);
						currentPlanet.setDeuterium(1000000);
						}
					else if (type.equals("Ion Cannon")) {
							currentPlanet.newIonCannon(1);
							currentPlanet.setMetal(1000000);
							currentPlanet.setDeuterium(1000000);
						}
					else if (type.equals("Plasma Cannon")) {
							currentPlanet.newPlasmaCannon(1);
							currentPlanet.setMetal(1000000);
							currentPlanet.setDeuterium(1000000);
						}
				}
		//RESTAURACIO METALL I DEUTERI ==============================================================================================================
				currentPlanet.setDeuterium(planetDeuterium);
				currentPlanet.setMetal(planetMetal);
		}
		//Planet status ###########################################################################################################
		Main main = new Main();
		//Temporitzador ===========================================================================================================
//		rep = 0;
//		TimerTask task = new TimerTask() {
//			public void run(){
//			System.out.println("Timer");
//			rep ++;
//			if (rep == 1) {//after 2 min
//				System.out.println("!!!Our radar detects an enemy army aproaching!!!");
//				System.out.println("Identifying...");
//				main.createEnemyArmy(main.enemyArmy);
//				System.out.println("\nEnemy army identified:");
//				main.viewThread();
//				System.out.println("\nYou've got 3 minutes");
//			}
//			if (rep == 2) {//after 5 min (3 min later)
//				System.out.println("Enemys are here, battle ensues...");
//				System.out.println("Pray for victory\n");
//				Battle battle = new Battle(currentPlanet.getArmy(), main.getEnemyArmy(), currentPlanet);
//				battle.startBattle(currentPlanet);
//				System.out.println(battle.getBattleReportStepByStep()); 
//				System.out.println("\nBATTLE FINISHED\n");
//				System.out.println(battle.getBattleReportGeneral());
//				rep = 0;
//			}
//			}
//		};
//		Timer timer = new Timer();
//		timer.schedule(task, 0, 60000);//1 minut
		//=========================================================================================================================
		System.out.println("");
		System.out.println("#########################################################################################################################");
		System.out.println("Landed onto planet "+planetName);
		System.out.println("Welcome to "+planetName);
		//abre planetstatus con planeta id option
		valid = false;
		while (valid == false) {
		System.out.println(" ");
		System.out.println("#########################################################################################################################");
		System.out.println("PLANET STATUS MENU");
		System.out.println("1)VIEW PLANET STATS");
		System.out.println("2)BUILD ARMY");
		System.out.println("3)UPGRADE TECHNOLOGIES");
		System.out.println("4)VIEW BATTLE REPORTS");//60 pasar 80 practicas (M12:EIE)
		System.out.println("5)EXIT");
		System.out.println("");
		System.out.println("Option:");
		option = input.next();
		
		if (option.equals("1")) {//view stats
			System.out.println("");
			currentPlanet.printStats();
		}
		else if (option.equals("2")) {//build army
			System.out.println("");
			buildArmy(currentPlanet);
			
		}
		else if (option.equals("3")) {//upgrade techs
			System.out.println("");
			Seleccionar_Opciones_techDefense_techAttack(currentPlanet);
		}
		else if (option.equals("4")) {//view reports
			System.out.println("");
			
		}
		else if (option.equals("5")) {//exit
			main.createEnemyArmy(main.enemyArmy);
			main.viewThread();
			System.out.println("");
			System.out.println("Enemys are here, battle ensues...");
  			System.out.println("Pray for victory\n");
  			Battle battle = new Battle(currentPlanet.getArmy(), main.getEnemyArmy(), currentPlanet);
 			System.out.println("Battle starts");
			battle.startBattle(currentPlanet);
			System.out.println(battle.getBattleReportStepByStep()); 
			System.out.println("\nBATTLE FINISHED\n");
			System.out.println(battle.getBattleReportGeneral());
			valid = true;
			
		}
		else {
			System.out.println("");
			System.out.println("ERROR:_INVALID OPTION_");
		}
		}
	
	
	
	//###########################################################################################################################################
	
}//main method

//METODO SELECCIONAR UPGRADE_TECHNOLOGY_DEFENSE O UPGRADE_TECHNOLOGY_ATTACK
public static void Seleccionar_Opciones_techDefense_techAttack(Planet planet) throws ResourceException, SQLException {
    Scanner scan = new Scanner(System.in);
	Statement statement = con.createStatement();
    int option = 0;
    do {
    	System.out.println(" ");
    	System.out.println("#########################################################################################################################");
        System.out.println("1. quiero updatear TechnologyDefense");
        System.out.println("2. quiero updatear TechnologyAttack");
        System.out.println("3. no quiero updatear nada.");
        option = scan.nextInt();

    switch (option) {
    case 1:
        planet.upgradeTechnologyDefense();
        String update1 = "UPDATE planets SET tech_defense = " + planet.getTechnologyDefense() + " WHERE (planet_name = '" + planet.getName() +"' )";
        String update11 = "UPDATE planets SET deuterium = " + planet.getDeuterium() + " WHERE (planet_name = '" + planet.getName() +"' )";
        String update111 = "UPDATE planets SET metal = " + planet.getMetal() + " WHERE (planet_name = '" + planet.getName() +"' )";
        System.out.println(update1);
        statement.executeUpdate(update1);
        statement.executeUpdate(update11);
        statement.executeUpdate(update111);

        break;
    case 2:
        planet.upgradeTechnologyAttack();
        String update2 = "UPDATE planets SET tech_attack = " + planet.getTechnologyAtack() + " WHERE (planet_name = '" + planet.getName() +"' )";
        String update22 = "UPDATE planets SET deuterium = " + planet.getDeuterium() + " WHERE (planet_name = '" + planet.getName() +"' )";
        String update222 = "UPDATE planets SET metal = " + planet.getMetal() + " WHERE (planet_name = '" + planet.getName() +"' )";
        statement.executeUpdate(update2);
        statement.executeUpdate(update22);
        statement.executeUpdate(update222);
        break;
    case 3:

        break;
    default:
    }

} while (option != 3 );

}


//#######################################################################################################################################################
public static void buildArmy(Planet planet) {
	Scanner scanner = new Scanner(System.in);
	int userOption;
	boolean inBuildArmy = true;
	String[] menuBuildArmy= {"Build troops", "Build defenses", "Go back"};
	String[] menuOptionsTroops = {"Build Light Hunter", "Build Heavy Hunter", "Build Battle Ship", "Build Armored Ship", "Go back"};
	String[] menuOptionsDefenses = {"Build Missile Launcher", "Build Ion Cannon", "Build Plasma Cannon", "Go back"};
	
	boolean flagMenuBuildArmy = true, flagMenuOptionsTroops = false, flagMenuOptionsDefenses = false;
	
	int currentMenu = 1;
	

	while(inBuildArmy) {
		
		if(flagMenuBuildArmy) {
			System.out.println(" ");
			System.out.println("#########################################################################################################################");
			System.out.println("\nBUILD");
			for(int i = 0; i < menuBuildArmy.length; i++) {		
				System.out.println((i + 1) + ")" + menuBuildArmy[i]);	
			}
			
			System.out.print("\nOption: ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
			
			case 1:
				flagMenuBuildArmy = false;
				flagMenuOptionsTroops = true;
				break;
				
			case 2:
				flagMenuBuildArmy = false;
				flagMenuOptionsDefenses = true;
				break;
				
			case 3:
				flagMenuBuildArmy = false;
				inBuildArmy = false;
				break;
				
			default:
				System.out.println("ERROR: Opcion incorrecta");
				break;		
			}

			
		}else if(flagMenuOptionsTroops) {
			
			int units;
			System.out.println(" ");
			System.out.println("#########################################################################################################################");
			System.out.println("\nBUILD TROOPS");
			for(int i = 0; i < menuOptionsTroops.length; i++) {		
				System.out.println((i + 1) + ")" + menuOptionsTroops[i]);	
			}
			
			System.out.print("\nOption: ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
			
			case 1:
			
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newLigthHunter(units);
					System.out.println("newlighthunters");
				} catch (ResourceException e) {
					System.out.println("nope");
					e.printStackTrace();
				}
			
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_SHIP) + 1, 1) from planet_ships");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_ships(ID_PLANET_SHIP, SHIP_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Light Hunter");
					preStatement.setInt(3, Variables.METAL_COST_LIGTHHUNTER);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_LIGTHHUNTER);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_LIGTHHUNTER);
					preStatement.setInt(7, Variables.ARMOR_LIGTHHUNTER);
					preStatement.setInt(8, Variables.BASE_DAMAGE_LIGTHHUNTER);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_SHIP) + 1, 1) from planet_ships");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_ships(ID_PLANET_SHIP, SHIP_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Ligth Hunter");
					preStatement.setInt(3, Variables.METAL_COST_LIGTHHUNTER);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_LIGTHHUNTER);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_LIGTHHUNTER);
					preStatement.setInt(7, Variables.ARMOR_LIGTHHUNTER);
					preStatement.setInt(8, Variables.BASE_DAMAGE_LIGTHHUNTER);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
				break;
			
			case 2:
				
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newHeavyHunter(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_SHIP) + 1, 1) from planet_ships");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_ships(ID_PLANET_SHIP, SHIP_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Heavy Hunter");
					preStatement.setInt(3, Variables.METAL_COST_HEAVYHUNTER);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_HEAVYHUNTER);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_HEAVYHUNTER);
					preStatement.setInt(7, Variables.ARMOR_HEAVYHUNTER);
					preStatement.setInt(8, Variables.BASE_DAMAGE_HEAVYHUNTER);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
				break;
		
			case 3:

				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newBattleShip(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_SHIP) + 1, 1) from planet_ships");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_ships(ID_PLANET_SHIP, SHIP_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Battle Ship");
					preStatement.setInt(3, Variables.METAL_COST_BATTLESHIP);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_BATTLESHIP);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_BATTLESHIP);
					preStatement.setInt(7, Variables.ARMOR_BATTLESHIP);
					preStatement.setInt(8, Variables.BASE_DAMAGE_BATTLESHIP);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
				break;
				
			case 4:
				
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newArmoredShip(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_SHIP) + 1, 1) from planet_ships");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_ships(ID_PLANET_SHIP, SHIP_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Armored Ship");
					preStatement.setInt(3, Variables.METAL_COST_ARMOREDSHIP);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_ARMOREDSHIP);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_ARMOREDSHIP);
					preStatement.setInt(7, Variables.ARMOR_ARMOREDSHIP);
					preStatement.setInt(8, Variables.BASE_DAMAGE_ARMOREDSHIP);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
				break;
							
			case 5:
				flagMenuOptionsTroops = false;
				flagMenuBuildArmy = true;
				break;
				
				
			default:
				System.out.println("ERROR: Opcion incorrecta");
				break;		
			}
			
			
		}else if(flagMenuOptionsDefenses) {
			
			int units;
			System.out.println(" ");
			System.out.println("#########################################################################################################################");
			System.out.println("\nBUILD DEFESES");
			for(int i = 0; i < menuOptionsDefenses.length; i++) {		
				System.out.println((i + 1) + ")" + menuOptionsDefenses[i]);	
			}
			
			System.out.print("\nOption: ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
			
			case 1:
			
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newMissileLauncher(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_DEFENSE) + 1, 1) from planet_defenses");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_defenses(ID_PLANET_DEFENSE, DEFENSE_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Missile Launcher");
					preStatement.setInt(3, Variables.METAL_COST_MISSILELAUNCHER);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_MISSILELAUNCHER);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_MISSILELAUNCHER);
					preStatement.setInt(7, Variables.ARMOR_MISSILELAUNCHER);
					preStatement.setInt(8, Variables.BASE_DAMAGE_MISSILELAUNCHER);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}					
				break;
				
			case 2:
				
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newIonCannon(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_DEFENSE) + 1, 1) from planet_defenses");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_defenses(ID_PLANET_DEFENSE, DEFENSE_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Ion Cannon");
					preStatement.setInt(3, Variables.METAL_COST_IONCANNON);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_IONCANNON);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_IONCANNON);
					preStatement.setInt(7, Variables.ARMOR_IONCANNON);
					preStatement.setInt(8, Variables.BASE_DAMAGE_IONCANNON);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_IONCANNON);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
				break;
				
			case 3:
		
				System.out.print("Amount of units: ");
				units = scanner.nextInt();
				try {
					planet.newPlasmaCannon(units);
				} catch (ResourceException e) {
					e.printStackTrace();
				}
				
				try {
					int idPlanet = 0;
					int newIdShip = 0;
					Statement statement = con.createStatement();
					ResultSet result1 = statement.executeQuery("select ID_PLANET from planets where PLANET_NAME = '" + planet.getName() + "'");
					result1.next();
					idPlanet = result1.getInt(1);

					ResultSet result2 = statement.executeQuery("select nvl(max(ID_PLANET_DEFENSE) + 1, 1) from planet_defenses");
					result2.next();
					newIdShip = result2.getInt(1);
											
					PreparedStatement preStatement = con.prepareStatement("insert into planet_defenses(ID_PLANET_DEFENSE, DEFENSE_NAME, METAL_COST, DEUTERIUM_COST, CRYSTAL_COST, INITIAL_ARMOR, ARMOR, BASE_DAMAGE, SPEED, GENERATE_WASTINGS, ID_PLANET) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
					
					preStatement.setInt(1, newIdShip);
					preStatement.setString(2, "Plasma Cannon");
					preStatement.setInt(3, Variables.METAL_COST_PLASMACANNON);
					preStatement.setInt(4, Variables.DEUTERIUM_COST_PLASMACANNON);
					preStatement.setInt(5, 0);
					preStatement.setInt(6, Variables.ARMOR_PLASMACANNON);
					preStatement.setInt(7, Variables.ARMOR_PLASMACANNON);
					preStatement.setInt(8, Variables.BASE_DAMAGE_PLASMACANNON);
					preStatement.setInt(9, 0);
					preStatement.setInt(10, Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON);
					preStatement.setInt(11, idPlanet);
					preStatement.executeUpdate();
								
				} catch (SQLException e1) {
					e1.printStackTrace();
				}						
				break;
			
			case 4:
				flagMenuOptionsDefenses = false;
				flagMenuBuildArmy = true;
				break;
						
			default:
				System.out.println("ERROR: Opcion incorrecta");
				break;		
			}			
		}						
	}		
}


}//main class
