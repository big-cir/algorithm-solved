import java.util.*;

class Solution {
    
     class Class implements Comparable<Class> {
        private String name;
        private int start;
        private int play;

        public Class(String name, int start, int play) {
            this.name = name;
            this.start = start;
            this.play = play;
        }

        @Override
        public int compareTo(Class o) {
            return start - o.start;
        }
    }

    // [과제, "start", "play time"]
    public String[] solution(String[][] plans) {
        Queue<Class> pq = new PriorityQueue<>();
        Stack<Class> stop = new Stack<>();

        for (String[] plan : plans) {
            pq.offer(new Class(plan[0], transMinute(plan[1]), transMinute(plan[2])));
        }

        List<String> list = new ArrayList<>();
        int t = pq.peek().start;
        boolean prg = true;
        Class c = pq.poll();
        while (list.size() != plans.length) {
            // 끝났을 경우
            if (c.play == 0) {
                list.add(c.name);

                if (!stop.isEmpty()) c = stop.pop();
            }

            if (!pq.isEmpty() && t == pq.peek().start) {
                if (prg) {
                    stop.push(c);
                }

                c = pq.poll();
            }
            t++;
            c.play--;
        }

        return list.stream().toArray(String[]::new);
    }

    private int transMinute(String time) {
        String[] sp = time.split(":");

        if (sp.length == 1) {
            return Integer.parseInt(time);
        } else {
            int h = Integer.parseInt(sp[0]) * 60;
            int m = Integer.parseInt(sp[1]);
            return h + m;
        }
    }
}