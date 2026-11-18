package model.dao.implementation;

import db.DB;
import db.DBException;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOJDBC implements DepartmentDAO {

    private final Connection connection;

    public DepartmentDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM department WHERE Id = ?");

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("Id"));
                department.setName(resultSet.getString("Name"));
                return department;
            }
            return null;

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }

    }

    @Override
    public List<Department> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM department ORDER BY Id");
            resultSet = statement.executeQuery();

            List<Department> departments = new ArrayList<>();

            while(resultSet.next()) {

                Department department = new Department(resultSet.getInt("Id"),
                        resultSet.getString("Name"));

                departments.add(department);
            }
            return departments;

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public void insert(Department department) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO department "
                    + "(Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, department.getName());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(resultSet);
            } else {
                throw new DBException("Error while inserting department! No rows affected.");
            }

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "UPDATE department "
                    + "SET Name = ? WHERE Id = ?");

            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Error while updating department: " + e.getMessage());
        }  finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("DELETE FROM department WHERE Id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Error while deleting department: " + e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }
}
