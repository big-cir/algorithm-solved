https://www.codetree.ai/problems/picking-score/description

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] scores = new int[4][info[0]];
        for (int i = 0; i < 4; i++) {
            scores[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < info[0]; i++) {
            for (int j = 0; j < info[0]; j++) {
                int sum = scores[0][i] + scores[1][j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int answer = 0;
        int target = info[1];
        for (int i = 0; i < info[0]; i++) {
            for (int j = 0; j < info[0]; j++) {
                int gap = target - (scores[2][i] + scores[3][j]);

                if (map.containsKey(gap)) answer += map.get(gap);
            }
        }

        System.out.println(answer);
    }
}
