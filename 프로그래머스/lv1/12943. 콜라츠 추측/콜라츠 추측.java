class Solution {
    public int solution(int num) {
        int tmp = num;
        if (tmp == 1) return 0;
        
        int answer = 0;
        
        while (tmp != 1) {
            if (tmp % 2 == 0) {
                tmp /= 2;
            } else if (tmp % 2 == 1) {
                tmp = tmp * 3 + 1;
            }
            answer++;
            if (answer > 500) return -1;
        }
        
        return answer;
    }
}