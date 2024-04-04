import java.util.*;

class Solution {
    
    class Info implements Comparable<Info> {
        private int idx;
        private int progress;
        private int speed;
        private int day;
        
        public Info(int idx, int progress, int speed) {
            this.idx = idx;
            this.progress = progress;
            this.speed = speed;
            this.day = 0;
        }
        
        public boolean isEnd() {
            return progress + (speed * day)  >= 100;
        }
    
        public int compareTo(Info o) {
            return this.idx - o.idx;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Info(i, progresses[i], speeds[i]));
        }

        int day = 1;
        while (day <= 100) {
            if (queue.isEmpty()) break;
            int endCnt = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info now = queue.poll();
                now.day = day;

                queue.offer(now);
            }

            while (!queue.isEmpty() && queue.peek().isEnd()) {
                queue.poll();
                endCnt++;
            }

            if (endCnt > 0) list.add(endCnt);
            day++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}