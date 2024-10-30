import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] ch;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        ch = new int[N + 1];
        solution(1, new ArrayList());

        for (List<Integer> answer : list) {
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void solution(int idx, List<Integer> tmp) {
        if (tmp.size() == M) {
            list.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                tmp.add(i);
                solution(i + 1, tmp);
                tmp.remove(tmp.size() - 1);
                ch[i] = 0;
            }
        }
    }
}
