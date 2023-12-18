import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int x : d) {
            sum += x;
            if (sum <= budget) {
                answer++;
            }
            
            if (sum > budget) break;
        }
        return answer;
    }
}