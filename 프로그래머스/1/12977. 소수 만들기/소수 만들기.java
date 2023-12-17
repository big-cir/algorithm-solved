class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPrime(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++){
            if (sum % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}