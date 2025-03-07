import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int row = n / w;
        if (n % w != 0) row += 1;
        
        boolean left = true;
        int[][] board = new int[row][w];
        int r = 0;
        int c = 0;
        
        int numIdx = 0;
        int numRow = 0;
        for (int val = 1; val <= n; val++) {
            if (val == num) {
                numIdx = c;
                numRow = r;
            }
            
            if (left) {
                board[r][c++] = val;
                if (c == w) {
                    left = false;
                    r++;
                    c--;
                }
            } else {
                board[r][c--] = val;
                if (c == -1) {
                    left = true;
                    r++;
                    c++;
                }
            }
        }
        
        int answer = (row - 1) - numRow;
        if (board[row - 1][numIdx] != 0) answer++;
        return answer;
    }
}