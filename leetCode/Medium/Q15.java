class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int p1 = i + 1, p2 = nums.length - 1;

            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if (sum == 0) {
                    String key = nums[i] + " " + nums[p1] + " " + nums[p2];
                    if (!set.contains(key)) {
                        answer.add(List.of(nums[i], nums[p1], nums[p2]));
                        set.add(key);
                    }
                    
                    p1++;
                    p2--;
                } else if (sum > 0) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }

        return answer;
    }
}
