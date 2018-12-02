import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Hash Tables: Ransom Note
public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = getDictionary(magazine);
        Map<String, Integer> noteMap = getDictionary(note);
        boolean result = isOneMapInAnother(magazineMap, noteMap);
        System.out.println(result ? "Yes" : "No");

    }

    private static boolean isOneMapInAnother(Map<String, Integer> magazine, Map<String, Integer> note) {
        for (Map.Entry noteEntry : note.entrySet()) {
            Integer magazineCount = magazine.get(noteEntry.getKey());
            if (magazineCount == null || (int) magazineCount < (int) noteEntry.getValue())
                return false;
        }
        return true;
    }
    
    private static Map<String, Integer> getDictionary(String[] text) {
        Map<String, Integer> dictionary = new HashMap();
        for(String word : text) {
            Integer count = dictionary.get(word);
            if (count == null) {
                dictionary.put(word, 1);
            } else {
                dictionary.put(word, count + 1);
            }
        }
        return dictionary;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
