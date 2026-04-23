class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int left = prefixSum[i] - nums[i];
            int right = prefixSum[n - 1] - left - nums[i];

            if (left == right) return i;
        }

        return -1;
    }
}
