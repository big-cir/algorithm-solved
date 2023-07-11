import java.util.*;

// 승리한 줄 개수가 다음과 같은 경우 정상 플레이입니다.
// XO.
// OXO
// XOX

// OOO
// XOX
// XXO

class Solution {
    // 1 : O, 2 : X, . : 0
    static int[][] map;
    
    public boolean winGame(int target) {
    
        for (int i = 0; i < 3; i++) {
            if ((map[i][0] == target) && (map[i][1] == target) && (map[i][2] == target)) {
                    return true;
            }
        }
            
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == target && map[1][i] == target && map[2][i] == target) {
                return true;
            }
        }

        if ((map[0][0] == target) && (map[1][1] == target && map[2][2] == target)) {
            return true;
        }
        
        if ((map[0][2] == target) && (map[1][1] == target) && (map[2][0] == target)) {
            return true;
        } 

        return false;
    }
    
    public int solution(String[] board) {
        int answer = 1;
        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            char[] tmp = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (tmp[j] == 'O') {
                    map[i][j] = 1;
                } else if (tmp[j] == 'X') {
                    map[i][j] = 2;
                }
            }
        }
        
        int zero = 0;   
        int one = 0;
        int two = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) zero++;
                else if (map[i][j] == 1) one++;
                else two++;
            }
        }
        
        if ( one < two || one - two > 1) {
            return 0;
        }
        
        boolean och = winGame(1);
        boolean xch = winGame(2);
        
        if (och && two + 1 != one) {
            return 0;
        }
        
        if (xch && one != two) {
            return 0;
        }
    
        return answer;
    }
}