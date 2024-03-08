package Tests.OrderedKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Create a method that takes a Map<String, String> and return the values as a separate array.
// Return the keys sorted alphabetically, and their corresponding values in the same order.
//
// Examples
// getValues({ "a": "1", "b": "2", "c": "3" })
// -> ["1", "2", "3"]
public class Main {

    public static String[] getValuesSol1(Map<String, String> map) {
        String[] arr = new String[map.size()];
        int i=0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            arr[i] = entry.getValue();
            i++;
        }
        Arrays.sort(arr);
        return arr;
    }

    public static String[] getValuesSol2(Map<String, String> map) {
        List<String> values = new ArrayList<>();

        // Obtenemos las claves y las ordenamos alfabéticamente
        List<String> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        // Iteramos sobre las claves ordenadas y obtenemos los valores correspondientes
        for (String key : sortedKeys) {
            String value = map.get(key);
            values.add(value);
        }

        // Convertimos la lista de valores a un arreglo de cadenas
        return values.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] keysSol1 = getValuesSol1(Map.of("a","1","b","2","c","3"));
        Arrays.asList(keysSol1).forEach(System.out::println);
        System.out.println("---");
        String[] keysSol2 = getValuesSol2(Map.of("a","1","b","2","c","3"));
        Arrays.asList(keysSol2).forEach(System.out::println);
    }
}
