class Solution {
    static int answer;
    public static void dfs(int Level, int cur, int N, int number) {
        if (Level > 8) return;

        if (cur == number) {
            answer = Math.min(Level, answer);
            return;
        }

        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            if (Level + i < 8) {
                tmp = tmp * 10 + N;
                dfs(Level + i + 1, cur + tmp, N, number);
                dfs(Level + i + 1, cur - tmp, N, number);
                dfs(Level + i + 1, cur / tmp, N, number);
                dfs(Level + i + 1, cur * tmp, N, number);
            }
        }
    }

    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        if (N == number) answer = 1;
        else {
            dfs(0, 0, N, number);
        }
        return answer > 8 ? -1 : answer;
    }
}