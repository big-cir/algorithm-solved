import java.util.*;
class Solution {
    static List<int[]> list;

    public static void recursive(int n, int start, int mid, int arrive) {
        if (n == 1) {
            list.add(new int[] {start, arrive});
            return;
        }

        recursive(n - 1, start, arrive, mid);
        list.add(new int[] {start, arrive});
        recursive(n - 1, mid, start, arrive);
    }

    public int[][] solution(int n) {
        list = new ArrayList<>();
        int[][] answer = {};
        recursive(n, 1, 2, 3);
        answer = list.toArray(new int[0][]);
        return answer;
    }
}