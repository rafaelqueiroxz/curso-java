import db.DB;
import db.DBException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DB.getConnection();

            connection.setAutoCommit(false);

            statement = connection.createStatement();

            int rows1 = statement.executeUpdate(
                    "UPDATE seller "
                    + "SET BaseSalary = 2090 "
                    + "WHERE DepartmentId = 1");

//            int x = 2;
//
//            if (x > 1) {
//                throw  new SQLException("Fake error");
//            }

            int rows2 = statement.executeUpdate(
                    "UPDATE seller "
                    + "SET BaseSalary = 3090 "
                    + "WHERE DepartmentId = 2");

            connection.commit();

            System.out.println("Rows updated: " + rows1);
            System.out.println("Rows updated: " + rows2);

        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DBException("Error trying to roll back transaction! Caused by: " + e1.getMessage());
            }

        } finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}