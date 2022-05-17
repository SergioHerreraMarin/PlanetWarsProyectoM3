package paqueteMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TerminalGame {
	static Connection con;
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
	//MENU LOGIN/REGISTER #######################################################################################################################
	boolean valid = false;
	while (valid == false) {
	valid = true;
	Scanner input = new Scanner(System.in);
	System.out.println(" ");
	System.out.println("IDENTIFICATION MENU");
	System.out.println("1)LOGIN");
	System.out.println("2)REGISTER");
	System.out.println("");
	System.out.println("Option:");
	String option = input.next();
	Statement statement = con.createStatement();
	if (option.contains("1")) { //login
		//LOGIN #####################################################################################################################################
		System.out.println(" ");
		System.out.println("LOGIN");
		System.out.println("Username:");
		String username = input.next();
		System.out.println("Password:");
		String password = input.next();
		ResultSet result = statement.executeQuery("select count(user_name) from users where user_name = '"+username+"' and user_password = '"+password+"'");
		result.next();
		if (result.getInt(1) != 1) {
			valid = false;
			System.out.println("ERROR:_USUARI NO REGISTRAT O CONTRASENYA INCORRECTA_");
		}
		}
	
	else if (option.contains("2")) { //register
		//REGISTRO ##################################################################################################################################
		valid = false;
		System.out.println("Username:");
		String username = input.next();
		System.out.println("Password:");
		String password = input.next();
		ResultSet result = statement.executeQuery("select max(id_user) from users");
		result.next();
		String id = String.valueOf(result.getInt(1));
		System.out.println(id);
		statement.executeUpdate(String.valueOf("insert into users (user_id,user_name,user_password,birth_date) values "+1+",'"+username+"','"+password+"',null"));
		System.out.println("User added");
	}
	else {
		System.out.println("ERROR:_INVALID OPTION_");
	}
	}//while valid
	
	//ESCOGER PLANETA ###########################################################################################################################
	
	//CREAR PLANETA ############################################################################################################################
	
	//###########################################################################################################################################
	
}//main method

}//main class
