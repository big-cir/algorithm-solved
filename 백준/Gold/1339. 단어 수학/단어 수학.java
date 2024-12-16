import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<Character, Integer> score;
    static Map<Character, Integer> rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new HashMap<>();
        rank = new HashMap<>();

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
            int length = strs[i].length();
            int initScore = (int) Math.pow(10, length);
            int tmp = initScore;

            for (char ch : strs[i].toCharArray()) {
                tmp /= 10;
                if (!score.containsKey(ch)) {
                    score.put(ch, tmp);
                    continue;
                }

                int cur = score.get(ch);
                score.put(ch, cur + tmp);
            }
        }

        List<Character> sortKey = new ArrayList<>(score.keySet());
        Collections.sort(sortKey, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return score.get(o2) - score.get(o1);
            }
        });

        int value = 9;
        for (char ch : sortKey) {
            rank.put(ch, value--);
        }

        int answer = 0;
        for (String s : strs) {
            String tmp = "";
            for (char ch : s.toCharArray()) {
                tmp += String.valueOf(rank.get(ch));
            }

            answer += Integer.parseInt(tmp);
        }

        System.out.println(answer);
    }
}