package ttn.cloudwords.exercise3;

import java.util.*;

public class Anagram {

    private static Set<String> words =
            new HashSet<>(Arrays.asList("vase", "bat", "gods", "latte", "name", "apres", "spit", "joke", "ham", "dog", "act",
                    "tale", "parse", "pits", "asper", "tab", "table", "mane", "late", "god", "cat", "table", "save", "spare"));

    public static void main(String[] args) {
        List<String> copy = new ArrayList<>(words);
        int size = copy.size();
        char[] arr1;
        char[] arr2;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (copy.get(i).length() == copy.get(j).length()) {
                    arr1 = copy.get(i).toLowerCase().toCharArray();
                    arr2 = copy.get(j).toLowerCase().toCharArray();
                    Arrays.sort(arr1);
                    Arrays.sort(arr2);
                    if (Arrays.equals(arr1, arr2)) {
                        System.out.println(copy.get(i) + " " + copy.get(j));
                    }
                }
            }
        }

    }
}
