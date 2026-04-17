// hashmap
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operation = 0;
        for (int num : nums) {
            int gap = k - num;
            if (map.containsKey(gap)) {
                int count = map.get(gap);
                if (count > 0) {
                    operation++;
                    map.put(gap, count - 1);
                } else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operation;
    }
}

// sorting + two point
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1;
        int operation = 0;
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum == k) {
                operation++;
                p1++;
                p2--;
            } else if (sum > k) {
                p2--;
            } else {
                p1++;
            }
        }

        return operation;
    }
}
