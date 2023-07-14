import java.util.Arrays;
class Solution {
    public static int getMax(int[][] land, int i, int col) {
        int res = 0;
        if (col == 0) {
            res = Math.max(land[i - 1][1], land[i - 1][2]);
            res = Math.max(res, land[i - 1][3]);
        } else if (col == 1) {
            res = Math.max(land[i - 1][0], land[i - 1][2]);
            res = Math.max(res, land[i - 1][3]);
        } else if (col == 2) {
            res = Math.max(land[i - 1][0], land[i - 1][1]);
            res = Math.max(res, land[i - 1][3]);
        } else {
            res = Math.max(land[i - 1][0], land[i - 1][1]);
            res = Math.max(res, land[i - 1][2]);
        }

        return res;
    }

    public static int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            land[i][0] += getMax(land, i, 0);
            land[i][1] += getMax(land, i, 1);
            land[i][2] += getMax(land, i, 2);
            land[i][3] += getMax(land, i, 3);
        }

        int max = 0;
        for (int[] x : land) {
            max = Arrays.stream(x).max().getAsInt();
        }

        return max;
    }
}