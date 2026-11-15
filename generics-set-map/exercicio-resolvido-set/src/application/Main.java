package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Set<LogEntry> set = new HashSet<>();
            String line =  br.readLine();

            while (line != null) {
                 String[] fields = line.split(" ");
                 String username = fields[0];
                LocalDate moment = Instant.parse(fields[1]).atZone(ZoneId.systemDefault()).toLocalDate();
                set.add(new LogEntry(username,moment));
                line = br.readLine();
            }

            System.out.println("Total users: " + set.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}