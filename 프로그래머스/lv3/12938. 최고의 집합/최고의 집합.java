class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        } else {
            int quotient = s / n;

            int[] answer = new int[n];
            for (int i = n; i >= 1; i--) {
                answer[n - i] = s / i;
                s -= s/i;
            }

            return answer;
        }
    }
}