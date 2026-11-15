import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        set.remove("Tablet");

        set.removeIf(x -> x.length() > 3);

        System.out.println(set.contains("Notebook"));

        for (String p : set) {
            System.out.println(p);
        }

        System.out.println("--------------------------");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // União
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        // Interseção
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        // Diferença
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);


    }
}