package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Practice5 {

	public static void main(String[] args) {
        String query = "SELECT * FROM users";
        
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project19db", "root", "root");
			System.out.println("Connection established success");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			ResultSetMetaData meta=rs.getMetaData();
			
			System.out.println(meta.getColumnCount());
			System.out.println(meta.getColumnName(1));
			System.out.println(meta.getColumnTypeName(1));
			System.out.println(meta.getTableName(1));
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}