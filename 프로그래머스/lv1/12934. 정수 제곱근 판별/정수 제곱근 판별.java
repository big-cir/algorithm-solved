class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        answer = (long) sqrt;

        if (sqrt == (int) sqrt) {
            answer++;
            answer *= answer;
        } else {
            answer = -1;
        }
        return answer;
    }
}