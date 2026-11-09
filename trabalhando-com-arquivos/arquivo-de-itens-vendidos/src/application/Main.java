package application;

import entities.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file path: ");
        String strPath = sc.nextLine();

        File file = new File(strPath);

        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(",");
                items.add(new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
        }

        boolean success = new File(file.getParent() + "\\out").mkdir();
        System.out.println("File created: " + success);

        strPath = "c:\\Temp\\exemplo\\out\\summary.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath))) {
            for (Item item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
        }


        sc.close();
    }
}