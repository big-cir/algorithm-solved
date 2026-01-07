class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>());

        return answer;
    }

    public void helper(int[] candidates, int target, int sum, int idx, List<Integer> tmp, List<List<Integer>> answer) {
        if (sum == target) {
            answer.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int value = candidates[i];
            if (sum + value > target) continue;
            tmp.add(value);
            helper(candidates, target, sum + value, i, tmp, answer);
            tmp.remove(tmp.size() - 1);
        }
    }
}
