import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            dfs(i + 1, "" + str.charAt(i), str, set);
        }
        System.out.println(set.size());
    }

    private static void dfs(int level, String tmp, String str, Set<String> set) {
        set.add(tmp);
        if (level == str.length()) return;
        dfs(level + 1, tmp + str.charAt(level), str, set);
    }
}
