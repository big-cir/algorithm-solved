import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static boolean box(int[][] arr) {
        int x = 0;
        int y = 0;

        Set<Integer> set = new HashSet<>();
        while (x < 7) {
            set.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    set.add(arr[x + i][y + j]);
                }
            }
            if (set.size() != 9) return false;
            x += 3;
            y += 3;
        }
        return true;
    }

    public static boolean rowAndcol(int[][] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(arr[i][j]);
                set2.add(arr[j][i]);
            }
            if (set.size() != 9 || set2.size()!= 9) {
                return false;
            }
            set.clear();
            set2.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int answer = 1;
            int[][] arr = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            if (!box(arr) || !rowAndcol(arr)) answer = 0;
            System.out.printf("#%d %d\n", i, answer);
        }
    }
}
