package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class checkconn {
    public static void main(String args[]){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "root");
            System.out.println("Connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
