import db.DB;
import db.DBIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DB.getConnection();

            statement = connection.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE Id = ?");

            statement.setInt(1, 2);

            int rowsAffected = statement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DBIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}