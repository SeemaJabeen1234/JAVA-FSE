package Jdbctransaction;


public class JdbcTransactionDemo {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.transferMoney(1, 2, 200); // Transfer ₹200 from Alice to Bob
    }
}
