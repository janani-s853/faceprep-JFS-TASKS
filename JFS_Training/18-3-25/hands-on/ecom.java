
package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ecom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/ecomdb";

        try {
            Connection con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connection Established");

            System.out.print("Enter your Email: ");
            String mail = sc.next();

            String query = "SELECT * FROM users WHERE gmail = '" + mail + "';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.println("User already exists.");
            } else {
                System.out.print("Enter your Password: ");
                String pass = sc.next();

                String insertQuery = "INSERT INTO users (gmail, password) VALUES ('" + mail + "', '" + pass + "');";
                int rowsAffected = st.executeUpdate(insertQuery);

                if (rowsAffected > 0) {
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Failed to create an account.");
                }
            }

            rs.close();
            st.close();
            con.close();
            sc.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
