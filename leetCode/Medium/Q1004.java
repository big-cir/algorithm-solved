class Solution {
    public int longestOnes(int[] nums, int k) {
        int answer = 0;
        int count = k;
        int n = nums.length;
        int lt = 0, rt = 0;
        while (rt < n) {
            int value = nums[rt];
            if (value == 0) count--;

            while (count < 0) {
                if (nums[lt] == 0) count++;
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
            rt++;
        }

        return answer;
    }
}
