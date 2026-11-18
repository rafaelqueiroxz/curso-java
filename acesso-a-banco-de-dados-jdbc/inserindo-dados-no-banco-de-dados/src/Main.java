import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DB.getConnection();

            /* statement = connection.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate,BaseSalary, DepartmentId) "
                    + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, "Beatriz Oliveira");
            statement.setString(2, "beatriz@gmail.com");
            statement.setDate(3,
                    new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy")
                            .parse("25/09/2007").getTime()));
            statement.setDouble(4, 3000.00);
            statement.setInt(5, 4);
             */

            statement = connection.prepareStatement("insert into department (Name) values ('D1'), ('D2')",
                    Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}