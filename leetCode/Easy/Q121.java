class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minValue = Integer.MAX_VALUE;
        for (int x : prices) {
            if (minValue > x) {
                minValue = Math.min(minValue, x);
            }

            if (minValue < x) {
                answer = Math.max(answer, x - minValue);
            }
        }

        return answer;
    }
}
