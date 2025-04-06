import java.util.*;

class Solution {

    static class Traffic {
        int start;
        int end;

        public Traffic(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[] lines) {
        List<Traffic> traffics = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            String[] timeParts = parts[1].split(":");

            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            double seconds = Double.parseDouble(timeParts[2]);
            int endTime = toMilliseconds(hours, minutes, seconds);
            
            double duration = Double.parseDouble(parts[2].replace("s", ""));
            int startTime = endTime - (int) (duration * 1000) + 1; // 시작 시간 보정
            
            traffics.add(new Traffic(startTime, endTime));
        }

        traffics.sort((a, b) -> a.start - b.start);

        int max = 0;
        PriorityQueue<Integer> activeEnds = new PriorityQueue<>();
        for (Traffic traffic : traffics) {
            int windowStart = traffic.start;

            while (!activeEnds.isEmpty() && activeEnds.peek() < windowStart - 999) {
                activeEnds.poll();
            }

            activeEnds.offer(traffic.end);
            max = Math.max(max, activeEnds.size());
        }

        return max;
    }

    private int toMilliseconds(int hours, int minutes, double seconds) {
        int total = 0;
        total += hours * 60 * 60 * 1000;
        total += minutes * 60 * 1000;
        total += (int) Math.round(seconds * 1000);
        
        return total;
    }
}
