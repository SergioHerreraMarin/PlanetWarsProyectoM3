
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;


public class DB_utils {
	
	//LEER DATOS -> QUERY LECTURA
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

}