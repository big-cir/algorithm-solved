class Solution {
    static int size, answer;

    public static void dfs(int Level, int sum, int target, int[] numbers) {
        if (Level == size) {
            if (target == sum) answer++;
            return;
        } else {
            dfs(Level + 1, sum + numbers[Level], target, numbers);
            dfs(Level + 1, sum - numbers[Level], target, numbers);
        }
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        dfs(0, 0, target, numbers);
        return answer;
    }
}