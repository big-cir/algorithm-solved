class Solution {
    public String solution(int n) {
        String[] nums = new String[] {"4", "1", "2"};
        String answer = "";
        while (n > 0) {
            answer = nums[n % 3] + answer;
            System.out.println(answer);
            n = (n - 1) / 3;
        }
        return answer;
    }
}