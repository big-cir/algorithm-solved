class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[] {0, n - 1};
        
        int lt = 0;
        int rt = 1;
        int sum = sequence[lt];
        while (lt < rt) {
            if (sum == k) {
                if (rt - 1 - lt < answer[1] - answer[0]) {
                    answer[0] = lt;
                    answer[1] = rt - 1;
                }
                sum -= sequence[lt++];
            } else if (sum > k) {
                sum -= sequence[lt++];
            } else if (rt < n) {
                sum += sequence[rt++];
            } else break;
        }
        return answer;
    }
}