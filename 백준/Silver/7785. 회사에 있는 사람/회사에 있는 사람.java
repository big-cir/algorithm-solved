import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            String name = strs[0];
            String status = strs[1];

            if (status.equals("leave")) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for (String str : list) {
            System.out.println(str);
        }
    }
}