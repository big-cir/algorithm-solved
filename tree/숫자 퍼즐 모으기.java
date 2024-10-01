import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static List<List<Integer>> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = N;
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> sub = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) sub.add(Integer.parseInt(st.nextToken()));
            list.add(sub);
        }

        backtrack(0, new ArrayList<Integer>());

        System.out.println(answer);
    }

    private static void backtrack(int start, List<Integer> index) {
        int cnt = index.size();
        if (cnt >= 1) {
            Set<Integer> set = new HashSet<>();
            for (int idx : index) {
                set.addAll(list.get(idx));
            }

            if (set.size() == 10) {
                answer = Math.min(answer, cnt);
                return;
            }
        }

        for (int i = start; i < N; i++) {
            index.add(i);
            backtrack(i + 1, index);
            index.remove(index.size() - 1);
        }
    }
}
