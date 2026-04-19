class Solution {
    public int longestSubarray(int[] nums) {
        int approve = 1;
        int lt = -1, rt = 0;
        int answer = 0;
        while (rt < nums.length) {
            int num = nums[rt];
            if (num == 0) {
                if (approve > 0)  {
                    approve--;
                    rt++;
                } else {
                    lt++;
                    if (nums[lt] == 0) approve++;
                }
            } else {
                rt++;
            }

            answer = Math.max(answer, rt - lt - 1);
        }

        return answer - 1;
    }
}
