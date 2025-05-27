package Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class create {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:student.db";

        // SQL to create the students table
        String sqlCreateTable = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    grade INTEGER
                );
                """;

        // SQL to insert sample data
        String sqlInsertData = """
                INSERT INTO students (name, grade) VALUES
                ('Alice', 85),
                ('Bob', 92),
                ('Charlie', 78);
                """;

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            // Create the table
            stmt.execute(sqlCreateTable);

            // Check if table is empty to avoid duplicate inserts
            ResultSet rsCheck = stmt.executeQuery("SELECT COUNT(*) AS count FROM students");
            int count = rsCheck.getInt("count");
            rsCheck.close();

            if (count == 0) {
                // Insert sample data only if table is empty
                stmt.execute(sqlInsertData);
                System.out.println("Data inserted into table.");
            } else {
                System.out.println("Table already has data, skipping insert.");
            }

            // Query and display the data
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("Students data:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int grade = rs.getInt("grade");
                System.out.printf("ID: %d, Name: %s, Grade: %d%n", id, name, grade);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
