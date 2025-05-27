package Jdbc;

import java.sql.*;

public class StudentDAO {
    private final String url = "jdbc:sqlite:student.db";

    // Insert a new student
    public void insertStudent(String name, int grade) {
        String sql = "INSERT INTO students(name, grade) VALUES(?, ?)";

        try {
            Class.forName("org.sqlite.JDBC"); // Ensure driver is loaded
            try (Connection conn = DriverManager.getConnection(url);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, name);
                pstmt.setInt(2, grade);
                pstmt.executeUpdate();
                System.out.println("Student inserted: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update existing student grade
    public void updateGrade(int id, int newGrade) {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";

        try {
            Class.forName("org.sqlite.JDBC"); // Ensure driver is loaded
            try (Connection conn = DriverManager.getConnection(url);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, newGrade);
                pstmt.setInt(2, id);
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Updated student ID " + id + " with new grade: " + newGrade);
                } else {
                    System.out.println("Student with ID " + id + " not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
