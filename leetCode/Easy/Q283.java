class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[p] = num;
                p++;
            }
        }

        while (p < n) {
            nums[p] = 0;
            p++;
        }
    }
}
