class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String x = skill_trees[i].replaceAll("[^" + skill + "]", "");
            if (x.equals(skill.substring(0, x.length()))) answer++;
        }
        return answer;
    }
}