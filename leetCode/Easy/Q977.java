// sol1
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int square = nums[i] * nums[i];
            nums[i] = square;
        }
        // nlogn
        Arrays.sort(nums); 

        // bubble sort O(n^2)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }
}

// sol2: two pointer
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int lt = 0, rt = nums.length - 1;
        int idx = rt;
        while (lt <= rt) {
            int leftSquare = nums[lt] * nums[lt];
            int rightSquare = nums[rt] * nums[rt];

            if (leftSquare < rightSquare) {
                answer[idx--] = rightSquare;
                rt--;
            } else {
                answer[idx--] = leftSquare;
                lt++;
            }
        }

        return answer;
    }
}
