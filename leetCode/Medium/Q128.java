// 시간복잡도: O(N), 공간복잡도: O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int answer = 1;
        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int length = 1;
            while (set.contains(num + 1)) {
                num++;
                length++;
            }

            answer = Math.max(answer, length);
        }

        return answer;
    }
}

// 시간복잡도: O(N log N), 공간복잡도: O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);
        int count = 1;
        int answer = count;
        int previous = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == previous + 1) answer = Math.max(answer, ++count);
            else if (nums[i] == previous) {
                continue;
            } else {
                count = 1;
            }

            previous = nums[i];
        }

        return answer;
    }
}
