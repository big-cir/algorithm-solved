import java.util.*;
import java.io.*;

public class Main {

    static int N, K, answer;
    static int[] ch;
    static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        int idx = 1;
        char start = 'a';
        map.put(idx++, start);
        for (int i = 1; i <= 25; i++) {
            map.put(idx++, (char) (start + i));
        }

        if (5 > K) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        int subS = 4;
        int subE = 4;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            word = word.substring(subS, word.length() - subE);
            words[i] = word;
        }

        ch = new int[map.size() + 1];
        String exist = "antatica";
        char[] tmp = exist.toCharArray();
        for (char ch1 : tmp) {
            ch[ch1 - '0' - 48] = 1;
        }

        answer = 0;
        backtrack(5, 1, words);
        System.out.println(answer);
    }

    private static void backtrack(int level, int start, String[] words) {
        if (level == K) {
            int cnt = 0;
            for (String word : words) {
                boolean flag = true;
                for (char ch1 : word.toCharArray()) {
                    if (ch[ch1 - '0' - 48] == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = start; i <= map.size(); i++) {
            char ch1 = map.get(i);
            if (ch[ch1 - '0' - 48] == 0) {
                ch[ch1 - '0' - 48] = 1;
                backtrack(level + 1, i + 1, words);
                ch[ch1 - '0' - 48] = 0;
            }
        }
    }
}