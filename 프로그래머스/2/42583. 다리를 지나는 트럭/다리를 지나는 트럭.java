import java.util.Queue;
import java.util.LinkedList;

// 트럭이 length 만큼 지나가는데, 1초씩 증가
// 지나간 거리를 어떻게 표시?
class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        int time = 0;
        int curWeight = 0;
        int idx = 0;
        while (idx < truck_weights.length) {
            if (queue.size() == bridge_length) {
                int gap = queue.poll();
                if (gap != -1) curWeight -= gap;
            } else if (curWeight + truck_weights[idx] <= weight) {
                curWeight += truck_weights[idx];
                queue.offer(truck_weights[idx++]);
                time++;
            } else {
                queue.offer(-1);
                time++;
            }
        }
        
        return time + bridge_length;
    }
}