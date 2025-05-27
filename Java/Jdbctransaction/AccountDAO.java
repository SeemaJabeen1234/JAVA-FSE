package Jdbctransaction;


import java.sql.*;

public class AccountDAO {
    private final String url = "jdbc:sqlite:bank.db";

    public void transferMoney(int fromId, int toId, int amount) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            // Disable auto-commit
            conn.setAutoCommit(false);

            // 1. Debit from sender
            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
            debitStmt.setInt(1, amount);
            debitStmt.setInt(2, fromId);
            int debitResult = debitStmt.executeUpdate();

            // 2. Credit to receiver
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            PreparedStatement creditStmt = conn.prepareStatement(creditSQL);
            creditStmt.setInt(1, amount);
            creditStmt.setInt(2, toId);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult == 1 && creditResult == 1) {
                conn.commit(); // Both succeeded
                System.out.println("Transfer successful!");
            } else {
                conn.rollback(); // One failed
                System.out.println("Transfer failed. Transaction rolled back.");
            }

            // Clean up
            debitStmt.close();
            creditStmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
