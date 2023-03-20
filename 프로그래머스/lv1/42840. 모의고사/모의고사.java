class Solution {
    static int[] pattern_1 = {1, 2, 3, 4, 5};
    static int[] pattern_2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] pattern_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int answer_pattern1(int[] answers) {
        int count = 0;
        int idx = 0;
        for (int x : answers) {
            if (idx == pattern_1.length) idx = 0;
            if (x == pattern_1[idx++]) count++;
        }
        return count;
    }

    public static int answer_pattern2(int[] answers) {
        int count = 0;
        int idx = 0;
        for (int x : answers) {
            if (idx == pattern_2.length) idx = 0;
            if (x == pattern_2[idx++]) count++;
        }
        return count;

    }

    public static int answer_pattern3(int[] answers) {
        int count = 0;
        int idx = 0;
        for (int x : answers) {
            if (idx == pattern_3.length) idx = 0;
            if (x == pattern_3[idx++]) count++;
        }
        return count;
    }

    public int[] solution(int[] answers) {
        int max = Integer.MIN_VALUE;
        int count1 = answer_pattern1(answers);
        int count2 = answer_pattern2(answers);
        int count3 = answer_pattern3(answers);

        if (count1 == count2 && count2 == count3) {
            return new int[] {1, 2, 3};
        } else if (count1 == count2 && count1 > count3) {
            return new int[] {1, 2};
        } else if (count2 == count3 && count2 > count1) {
            return new int[] {2, 3};
        } else if (count1 == count3 && count1 > count2) {
            return new int[] {1, 3};
        } else {
            max = Math.max(count1, Math.max(count2, count3));
            if (max == count1) return new int[] {1};
            if (max == count2) return new int[] {2};
            if (max == count3) return new int[] {3};
        }
        return new int[]{};
    }
}