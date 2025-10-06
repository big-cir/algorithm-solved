// in-place

// sol 1: 4ms
class Solution {
    public int removeDuplicates(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for (int x : nums) {
            if (!set.contains(x)) {
                set.add(x);
                stack.push(x);
            }
        }

        int idx = stack.size() - 1;
        while (idx >= 0) {
            nums[idx--] = stack.pop();
        }

        return set.size();
    }
}

// sol 2: 1ms
class Solution {
    public int removeDuplicates(int[] nums) {
        int pIdx = 0, vIdx = 0;
        while (pIdx < nums.length && vIdx < nums.length) {
            if (nums[pIdx] == nums[vIdx]) {
                vIdx++;
            } else {
                nums[++pIdx] = nums[vIdx];
            }
        }

        return pIdx + 1;
    }
}

// sol 3: 0ms
class Solution {
    public int removeDuplicates(int[] nums) {
        int pIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[pIdx++] = nums[i];
            } 
        }

        return pIdx;
    }
}
