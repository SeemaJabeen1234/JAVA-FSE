package Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:student.db";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            // Query students table
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int grade = rs.getInt("grade");
                System.out.printf("ID: %d, Name: %s, Grade: %d%n", id, name, grade);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
