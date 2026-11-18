package application;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Main2 {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

        System.out.println("\n=== Test 1: department findById ===");
        Department department = departmentDAO.findById(7);
        System.out.println(department);

        System.out.println("\n=== Test 2: department findAll ===");
        departmentDAO.findAll().forEach(System.out::println);

        System.out.println("\n=== Test 3: department insert ===");
        Department newDepartment = new Department(null, "Fashion");
        departmentDAO.insert(newDepartment);
        System.out.println("Inserted! New Id: " + newDepartment.getId());

        System.out.println("\n=== Test 4: department update ===");
        department.setName("Utilidade");
        departmentDAO.update(department);
        System.out.println("Update completed!");

        System.out.println("\n=== Test 5: department deleteById ===");
        departmentDAO.deleteById(11);
        System.out.println("Delete completed");


    }
}
