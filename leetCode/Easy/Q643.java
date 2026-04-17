class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double answer = -Double.MAX_VALUE;
        double[] prefixSum = new double[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (double) nums[i - 1];
        }

        for (int i = 0; i < prefixSum.length - k; i++) {
            answer = Math.max(answer, prefixSum[i + k] - prefixSum[i]);
        }

        return answer / k;
    }
}
