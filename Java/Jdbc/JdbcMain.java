package Jdbc;

public class JdbcMain {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a new student
        dao.insertStudent("David", 88);

        // Update an existing student's grade (make sure ID exists)
        dao.updateGrade(1, 95);
    }
}
