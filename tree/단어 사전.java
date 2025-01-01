import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        solution1(list);
        solution2(list);
    }

    private static void solution1(List<String> list) {
        Collections.sort(list);
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String answer : list) {
            if (!set.contains(answer)) {
                sb.append(answer).append(" ");
                set.add(answer);
            }
        }

        System.out.println(sb);
    }

    private static void solution2(List<String> list) {
        TreeSet<String> set = new TreeSet<>();
        for (String str : list) {
            set.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String answer : set) {
            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}
