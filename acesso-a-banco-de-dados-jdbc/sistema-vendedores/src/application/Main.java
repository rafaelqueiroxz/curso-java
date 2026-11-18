package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDAO = DAOFactory.createSellerDAO();

        System.out.println("\n=== Test 1: seller findById ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDAO.findByDepartment(department);
        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("\n=== Test 3: seller findByAll ===");
        sellers = sellerDAO.findAll();
        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("\n=== Test 4: seller insert ===");
        Seller newSeller = new Seller(null, "Rafael Queiroz", "rafael@gmail.com", LocalDate.parse("01/12/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 4000.00, department);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== Test 5: seller update ===");
        seller = sellerDAO.findById(1);
        seller.setName("Antony Stark");
        sellerDAO.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== Test 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        Integer id = sc.nextInt();
        sellerDAO.deleteById(id);
        System.out.println("Delete completed");


        sc.close();
    }
}