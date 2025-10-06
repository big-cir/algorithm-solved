class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int lt = 0, rt = numbers.length - 1;
        while (lt < rt) {
            int sum = numbers[lt] + numbers[rt];
            if (sum <= target) {
                if (sum == target) break;
                lt++;
            } else {
                rt--;
            }
        }

        return new int[] {lt + 1, rt + 1};
    }
}
