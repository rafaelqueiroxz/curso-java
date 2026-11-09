import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("Folders:");
        for (File f : folders) {
            System.out.println(f.getName());
        }

        File[] files = path.listFiles(File::isFile);
        System.out.println("\nFiles:");
        for (File f : files) {
            System.out.println(f.getName());
        }

        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("\nDirectory created: " + success);



        sc.close();
    }
}