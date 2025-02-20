import java.io.*;
import java.util.*;

public class Main {

    static int N, M, maxMusic;
    static int[] used, playedMusic, answer;
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();

            String play = br.readLine().split(" ")[1];
            for (int j = 0; j < M; j++) {
                if (play.charAt(j) == 'Y') {
                    set.add(j);
                }
            }

            map.put(i, set);
        }

        answer = new int[M + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        maxMusic = 0;
        used = new int[N];
        playedMusic = new int[M];
        backtrack(0);


        for (int i = M; i > 0; i--) {
            if (answer[i] != Integer.MAX_VALUE) {
                System.out.println(answer[i]);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void backtrack(int idx) {
        if (idx >= 1) {
            int gCount = 0;
            for (int i = 0; i < N; i++) {
                if (used[i] == 1) {
                    gCount++;

                    for (int mn : map.get(i)) {
                        playedMusic[mn] = 1;
                    }
                }
            }

            int mCount = 0;
            for (int i = 0; i < M; i++) {
                if (playedMusic[i] == 1) mCount++;
            }

            answer[mCount] = Math.min(answer[mCount], gCount);
            Arrays.fill(playedMusic, 0);
        }

        for (int i = idx; i < N; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                backtrack(i + 1);
                used[i] = 0;
            }
        }
    }
}
