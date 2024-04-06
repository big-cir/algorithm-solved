import java.util.*;
class Solution {
    static int MISS = 5;
    static int HIT = 1;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String x : cities) {
            x = x.toLowerCase();

            if (!queue.contains(x)) {
                if (queue.size() == cacheSize) {
                    queue.addFirst(x);
                    queue.removeLast();
                } else {
                    queue.addFirst(x);
                }
                answer += MISS;
            } else {
                queue.remove(x);
                queue.addFirst(x);
                answer += HIT;
            }
        }
        return answer;
    }
}