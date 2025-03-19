package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Email:");
        String gmail = sc.nextLine();

        System.out.println("Enter Password:");
        String userpass = sc.nextLine();

        String query = "SELECT userid, participant1 FROM user WHERE gmail = ? AND userpass = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "root");
            System.out.println("Connection established successfully");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, gmail);
            ps.setString(2, userpass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userid = rs.getInt("userid");
                String participant = rs.getString("participant1");
                System.out.println("Login Successful. Welcome " + participant + ". Your User ID is: " + userid);
            } else {
                System.out.println("Invalid Email or Password. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
