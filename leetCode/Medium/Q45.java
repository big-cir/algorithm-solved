// greedy
class Solution {
    public int jump(int[] nums) {
        int answer = 0;
        int end = 0;
        int farEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int farDis = nums[i];
            farEnd = Math.max(farEnd, i + farDis);

            if (i == end) {
                end = farEnd;
                answer++;
            }
        }

        return answer;
    }
}

// dp
class Solution {
    public int jump(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (result[i] == Integer.MAX_VALUE) continue;

            for (int j = i + 1; j <= i + num; j++) {
                if (j >= nums.length) break;
                result[j] = Math.min(result[j], result[i] + 1);
            }
        }

        return result[nums.length - 1];
    }
}
