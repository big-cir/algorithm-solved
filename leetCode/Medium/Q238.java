// 시간복잡도: O(N), 공간복잡도: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            answer[i] = left;
        }

        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            answer[i] *= right;
        }

        return answer;
    }
}

// 시간복잡도: O(N), 공간복잡도: O(N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] subfix = new int[n];
        subfix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            subfix[i] = subfix[i + 1] * nums[i + 1];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * subfix[i];
        }

        return answer;
    }
}
