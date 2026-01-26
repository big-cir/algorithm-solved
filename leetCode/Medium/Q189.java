// 시간복잡도: O(N), 공간복잡도: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int rotationIdx = k % n;
        helper(0, n - 1, nums);
        helper(0, rotationIdx - 1, nums);
        helper(rotationIdx, n - 1, nums);
    }

    private void helper(int idx1, int idx2, int[] nums) {
        while (idx1 < idx2) {
            swap(idx1, idx2, nums);
            idx1++;
            idx2--;
        }
    }

    private void swap(int idx1, int idx2, int[] nums) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

// 시간복잡도: O(N), 공간복잡도: O(N)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}
