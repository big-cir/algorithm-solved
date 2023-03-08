class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for (char x : s.toCharArray()) {
            char alpa = Character.toLowerCase(x);
            if (alpa == 'p') pCount++;
            if (alpa == 'y') yCount++;
        }

        boolean answer = true;
        if (pCount != yCount) answer = false;

        return answer;
    }
}