class Solution {
    public int largestAltitude(int[] gain) {
        int answer = 0;
        int sum = 0;
        for (int num : gain) {
            sum += num;
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
