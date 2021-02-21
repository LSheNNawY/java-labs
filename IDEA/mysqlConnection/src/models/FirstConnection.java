package models;
import java.sql.*;

public class FirstConnection {
    public FirstConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
            Statement stmt = con.createStatement();
            String queryString1 = new String("SELECT * FROM `Employee`");
            String queryString2 = new String("DELETE FROM `Employee` WHERE SSN=321654");
            String queryString3 = new String("UPDATE `Employee` SET Fname = 'Amr' WHERE SSN=321654" );
            // Delete
//            stmt.executeUpdate(queryString3);
            // Update
//            stmt.executeUpdate(queryString2);
            // Fetch
            ResultSet rs = stmt.executeQuery(queryString1);


            while(rs.next()){
                System.out.print(rs.getString(2) + "\t");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FirstConnection();
    }
}