package Jdbctransaction;

import java.sql.*;

public class CreateAccounts {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";

        String createTable = """
                    CREATE TABLE IF NOT EXISTS accounts (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        balance INTEGER NOT NULL
                    );
                """;

        String insertData = """
                    INSERT INTO accounts (id, name, balance) VALUES
                    (1, 'Alice', 1000),
                    (2, 'Bob', 500);
                """;

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            stmt.execute(createTable);
            stmt.execute(insertData);

            stmt.close();
            conn.close();
            System.out.println("Accounts created and initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
