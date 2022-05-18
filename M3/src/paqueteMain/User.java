package paqueteMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class User {

	//ATRIBUTOS
	private int id_user;
	private String user_name;
	private String user_password;
	private Date birth_date;
	
	//CONSTRUCTOR
	public User(int id_user, String user_name, String user_password, Date date) {
		super();
		this.id_user = id_user;
		this.user_name = user_name;
		this.user_password = user_password;
		this.birth_date = date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", birth_date=" + birth_date + "]";
	}

	
	//METODO CONTAR PLANETAS DEL USUARIO
	public int getPlanetasCount(Connection con) {
			
		String query = "SELECT count(planet_name) FROM proyecto_suns.planets where id_user = " + getId_user() + ";";
		ResultSet rs = null;
		int resultado = 0;
		try {
			rs = ConnectionBBDD.SelectQuery(con, query) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.next();
			resultado = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	//METODO IMPRIMIR LISTADO DE PLANETAS
	public String[] getPlanetasListado(Connection con, int totalPlanets) {
		
		String[] planetNames = new String[totalPlanets];
		String query = "SELECT planet_name FROM proyecto_suns.planets where id_user = " + getId_user() +";";
		ResultSet rs = null;
		
		try {
			rs = ConnectionBBDD.SelectQuery(con, query) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0;
		
		try {
			while (rs.next() == true) {
				//OBTENER VALORES DEL RESULTSET
				planetNames[count] = rs.getString(1);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planetNames;
	}
	
	
	//METODO CREAR PLANETA NUEVO PARA NUEVO USUARIO, INSERTAR EN LA TABLA
	public void crearPlaneta(Connection con, String planet_name, int technologyAtack, int technologyDefense,
			int upgradeAttackTechnologyDeuteriumCost, int upgradeDefenseTechnologyDeuteriumCost, int deuterium,
			int metal, int crystal) {
		
		PreparedStatement stmnt = null;
		int resultado = 0;
		int idNewPlanet = 0; 
		ResultSet rs = null;
		rs = ConnectionBBDD.SelectQuery(con, "SELECT max(id_planet)+1 FROM proyecto_suns.planets;");

		try {
			rs.next();
			idNewPlanet = rs.getInt(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
		String insert = "INSERT INTO planets(id_planet, planet_name, tech_attack, tech_defense, tech_attack_upgrade_cost, tech_defense_upgrade_cost, deuterium, metal, crystal, id_user) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";//parametrizado
		stmnt = con.prepareStatement(insert);
		stmnt.setInt(1, idNewPlanet);
		stmnt.setString(2, planet_name);
		stmnt.setInt(3, technologyAtack);
		stmnt.setInt(4, technologyDefense);
		stmnt.setInt(5, upgradeAttackTechnologyDeuteriumCost);
		stmnt.setInt(6, upgradeDefenseTechnologyDeuteriumCost);
		stmnt.setInt(7, deuterium);
		stmnt.setInt(8, metal);
		stmnt.setInt(9, crystal);
		stmnt.setInt(10, id_user);

		resultado = stmnt.executeUpdate();//solo devuelve 0 o 1
		
		if (resultado == 0) {
			System.out.println("no se ha realizado la modificaci�n");
		} else {
			System.out.println("se ha realizado la modificaci�n");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	
	
	
}

