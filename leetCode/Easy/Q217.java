// sol1: 시간 - O(nlogn), 공간 - O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;;
        }

        return false;
    }
}

// sol2: 시간 - O(n), 공간 - O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }

        return false;
    }
}
