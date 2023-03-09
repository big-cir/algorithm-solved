class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int x = n % 3;
            sb.append(x);
            n /= 3;
        }

        int answer = 0;
        int x = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            answer += Math.pow((double) 3, x) * (sb.charAt(i) - 48);
            x++;
        }
        return answer;
    }
}