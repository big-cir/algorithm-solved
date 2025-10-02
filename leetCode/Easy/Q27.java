class Solution {
    public int removeElement(int[] nums, int val) {
        int lt = 0, rt = nums.length - 1;
        int size = nums.length;
        while (lt <= rt) {
            if (nums[rt] == val) {
                rt--;
                size--;
            } else if (nums[lt] == val) {
                int tmp = nums[rt];
                nums[lt++] = tmp;
                nums[rt--] = val;
                size--;
            } else {
                lt++;
            }
        }

        return size;
    }
}
