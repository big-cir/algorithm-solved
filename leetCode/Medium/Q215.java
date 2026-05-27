class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];

        for (int num : nums) {
            count[num + 10000]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[idx++] = i - 10000;
                count[i]--;
            }
        }

        return nums[nums.length - k];
    }
}
