import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < players.length; i++) {
            int player = players[i];

            if (player > 0) {
                if (queue.isEmpty()) {
                    int server = player / m;
                    answer += server;
                    for (int j = 0; j < server; j++) queue.offer(i + k);
                } else {
                    if (player >= queue.size() * m) {
                        int server = (player - queue.size() * m) / m;
                        answer += server;
                        for (int j = 0; j < server; j++) queue.offer(i + k);
                    }
                }
            }

            while (!queue.isEmpty()) {
                int end = queue.peek();

                if (end == i + 1) queue.poll();
                else break;
            }

        }

        return answer;
    }
}
