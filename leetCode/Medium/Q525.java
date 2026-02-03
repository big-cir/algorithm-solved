// 시간복잡도: O(N)
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        if (nums[0] == 0) {
            prefixSum[0] = -1;
        } else {
            prefixSum[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                prefixSum[i] = prefixSum[i - 1] - 1;
            } else {
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
        }

        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int sum = prefixSum[i];
            if (map.containsKey(sum)) {
                int idx = map.get(sum);
                answer = Math.max(answer, i - idx);
            } else {
                map.put(sum, i);
            }
        }

        return answer;
    }
}

// 시간복잡도: O(N^2)
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        if (nums[0] == 0) {
            prefixSum[0] = -1;
        } else {
            prefixSum[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                prefixSum[i] = prefixSum[i - 1] - 1;
            } else {
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int value = prefixSum[i];
            for (int j = i + 1; j < n; j++) {
                if (value == prefixSum[j]) {
                    answer = Math.max(answer, j - i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == 0) {
                answer = Math.max(answer, i + 1);
            }
        }

        return answer;
    }
}
