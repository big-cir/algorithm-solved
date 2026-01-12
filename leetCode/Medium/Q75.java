// 시간복잡도: O(N)
class Solution {
    public void sortColors(int[] nums) {
        int lt = 0, mid = 0, rt = nums.length - 1;
        while (mid <= rt) {
            if (nums[mid] == 0) {
                swap(lt, mid, nums);
                lt++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(mid, rt, nums);
                rt--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int idx1, int idx2, int[] nums) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

// 시간복잡도: O(N log N)
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
