class Solution {
    public int search(int[] nums, int target) {
        int lt = 0, rt = nums.length - 1;
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (nums[mid] < target) {
                lt = mid + 1;
            } else {
                if (nums[mid] == target) return mid;
                rt = mid - 1;
            }
        }

        return -1;
    }
}
