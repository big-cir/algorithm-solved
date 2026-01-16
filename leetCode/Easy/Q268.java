// 시간복잡도: O(N)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1)/ 2;
        for (int x : nums) sum -= x;
        
        return sum;
    }
}

// 시간복잡도: O(N log N)
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return nums.length;
    }
}
