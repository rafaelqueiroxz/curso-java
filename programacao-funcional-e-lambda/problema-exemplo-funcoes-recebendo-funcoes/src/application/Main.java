package application;

import entities.Product;
import services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv",900.00));
        products.add(new Product("Mouse",50.00));
        products.add(new Product("Tablet",350.50));
        products.add(new Product("HD Case",80.90));

        ProductService service = new ProductService();

        double sum = service.filteredSum(products, p -> p.getPrice() < 100.00);

        System.out.println("Sum: " + String.format("%.2f", sum));


    }
}