import java.util.*;

public class PhoneBook {
    static HashMap<String, Integer> pb = new HashMap<>();
    public static void main(String[] args) {
        Map<String, HashSet<String>> map = new HashMap<>();

        updateBook(map, "Pavel Movchan", "89244445533" );
        updateBook(map, "Roman Zhukov", "89145633322" );
        updateBook(map, "Aleksandr Dorofeev", "89098165544" );
        updateBook(map, "Sergei Shevnin", "84162530502" );
        updateBook(map, "Sarkis Petrosyan", "89244444444" );
        updateBook(map, "Svyatoslav Zenin", "85968663322" );
        updateBook(map, "Maksim Slastin", "89633332255" );

        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            HashSet<String> value = entry.getValue();
            System.out.println(key + value);
        }

        pb.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    private static void updateBook(Map<String, HashSet<String>> map, String key, String value) {
        if (map.containsKey(key)) {
            HashSet<String> oldVal = map.get(key);
            oldVal.add(value);
        } else {
            HashSet<String> newList = new HashSet<>();
            newList.add(value);
            map.put(key, newList);
        }
    }
}