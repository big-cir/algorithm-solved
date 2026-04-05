import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static boolean checkMagazine(List<String> magazine, List<String> note) {
        boolean result = true;
        Map<String, Integer> map = new HashMap<>();
        for (String word : magazine) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String word : note) {
            if (!map.containsKey(word)) {
                return false;
            }
            
            int value = map.get(word);
            if (value == 0) {
                return false;
            }
                
            map.put(word, value - 1); 
        }
        
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        boolean result = Result.checkMagazine(magazine, note);
        if (result) System.out.println("Yes");
        else System.out.println("No");

        bufferedReader.close();
    }
}
