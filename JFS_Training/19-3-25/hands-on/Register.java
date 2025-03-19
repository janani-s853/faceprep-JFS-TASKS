package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("EVENT REGISTRATION");
        System.out.println("Enter College Name:");
        String collegename = sc.nextLine();
        
        System.out.println("Enter Event Name:");
        String eventname = sc.nextLine();
        
        System.out.println("Enter Participant 1 Name:");
        String participant1 = sc.nextLine();
        
        System.out.println("Enter Participant 2 Name (Enter NIL if individual participation):");
        String participant2 = sc.nextLine();
        
        System.out.println("Enter Email:");
        String gmail = sc.nextLine();
        
        System.out.println("Enter Password:");
        String userpass = sc.nextLine();
        
        String query = "INSERT INTO user (collegename, eventname, participant1, participant2, gmail, userpass) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "root");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, collegename);
            ps.setString(2, eventname);
            ps.setString(3, participant1);
            ps.setString(4, participant2);
            ps.setString(5, gmail);
            ps.setString(6, userpass);

            int rows = ps.executeUpdate();
            System.out.println("Registration done successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
