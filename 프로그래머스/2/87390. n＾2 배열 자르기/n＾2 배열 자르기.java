class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        for (long i = left; i <= right; i++) {
            long[] pos = new long[] {i / n, i % n};
            answer[(int) (i - left)] = (int) Math.max(pos[0], pos[1]) + 1;
        }
        
        return answer;
    }
}