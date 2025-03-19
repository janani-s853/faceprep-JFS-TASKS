package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class auth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Email: ");
        String mail = sc.next();

        String url = "jdbc:mysql://localhost:3306/ecomdb";
        String query = "SELECT * FROM users WHERE gmail = '" + mail + "';";

        try {
            Connection con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connection Established Successfully...");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.print("Enter your Password: ");
                String password = sc.next();

                if (password.equals(rs.getString("pass"))) {
                    System.out.println("Welcome back, User ID: " + rs.getInt("userid"));
                } else {
                    System.out.println("Incorrect password. Try again.");
                }
            } else {
                System.out.println("User not found...");
            }

            st.close();
            rs.close();
            con.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
