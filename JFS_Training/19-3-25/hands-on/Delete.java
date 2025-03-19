package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Team ID:");
        int teamid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Email:");
        String gmail = sc.nextLine();

        System.out.println("Enter Password:");
        String userpass = sc.nextLine();

        sc.close();

        String query = "DELETE FROM user WHERE teamid = ? AND gmail = ? AND userpass = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "root");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, teamid);
            ps.setString(2, gmail);
            ps.setString(3, userpass);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Registration deleted successfully.");
            } else {
                System.out.println("User not found or incorrect credentials.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
