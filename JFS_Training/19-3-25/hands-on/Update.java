package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your mail id:");
        String gmail = sc.nextLine();
        System.out.println("Enter your current password:");
        String oldPass = sc.nextLine();
        
        System.out.println("What do you want to update?");
        System.out.println("1. College Name");
        System.out.println("2. Event Name");
        System.out.println("3. Participant 1 Name");
        System.out.println("4. Participant 2 Name");
        System.out.println("5. Gmail");
        System.out.println("6. Password");
        System.out.print("Enter your choice (1-6): ");
        int choice = sc.nextInt();
        sc.nextLine();  
        
        String update = "";
        switch (choice) {
            case 1: 
            	update= "collegename"; 
                System.out.println("Enter College name:");
            	break;
            case 2: 
                System.out.println("Enter Event Name:");
            	update = "eventname"; 
            	break;
            case 3:
                System.out.println("Enter Participant 1 name:");
            	update= "participant1"; 
            	break;
            case 4: 
                System.out.println("Enter participant 2 name:");
            	update = "participant2"; 
            	break;
            case 5: 
                System.out.println("Enter Email id");
            	update = "gmail"; 
            	break;
            case 6: 
                System.out.println("Enter new password:");
            	update = "userpass"; 
            	break;
        }

        String newValue = sc.nextLine();
        
        String query = "UPDATE user SET " + update + " = ? WHERE gmail = ? AND userpass = ?;";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "root");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, gmail);
            ps.setString(3, oldPass);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(update + " updated successfully.");
            } else {
                System.out.println("Update failed. Please check your credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
