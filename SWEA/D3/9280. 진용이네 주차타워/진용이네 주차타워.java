import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 주차 공간
            int m = Integer.parseInt(st.nextToken());       // 차량 무게
            int[] cost = new int[n];
            int[] ch = new int[n];
            int[] weight = new int[m];

            for (int i = 0; i < n; i++) {
                cost[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < m; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            Queue<Integer> command = new LinkedList<>();
            Queue<Integer> hold = new LinkedList<>();
            for (int i = 0; i < 2 * m; i++) {
                command.add(Integer.parseInt(br.readLine()));
            }

            int answer = 0;
            while (!command.isEmpty()) {
                int val = command.poll();
                if (val > 0) {
                    hold.add(val);
                    for (int i = 0; i < n; i++) {
                        if (ch[i] == 0) {
                            answer += cost[i] * weight[val - 1];
                            ch[i] = val;
                            hold.poll();
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (ch[i] == Math.abs(val)) {
                            ch[i] = 0;
                            if (!hold.isEmpty()) {
                                int val2 = hold.poll();
                                ch[i] = val2;
                                answer += cost[i] * weight[val2 - 1];
                            }
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
