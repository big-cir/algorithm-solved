import java.util.*;

// 내구도가 0이하면 파괴
// 파괴된 건물 복구 가능
// 그럼 이미 파괴된 건물은 계속 데미지를 받는가? O

// skill = [type, 행, 열, 행, 열, 수치]
// type = 1 (공격), 2 (회복)
// 완탐 25억 시초 각.
// 각 위치의 증가를 구해봄.
// 누적합 느낌인데?
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] arr = new int[N + 1][M + 1];

        for (int[] info : skill) {
            int x1 = info[1];
            int y1 = info[2];
            int x2 = info[3];
            int y2 = info[4];

            if (info[0] == 2) {
                arr[x1][y1] += info[5];
                arr[x2 + 1][y2 + 1] += info[5];
                arr[x1][y2 + 1] -= info[5];
                arr[x2 + 1][y1] -= info[5];
            } else {
                arr[x1][y1] -= info[5];
                arr[x2 + 1][y2 + 1] -= info[5];
                arr[x1][y2 + 1] += info[5];
                arr[x2 + 1][y1] += info[5];
            }
        }

        prefixSum(N, M, arr);
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + arr[i][j] > 0) answer++;
            }
        }

        return answer;
    }

    private void prefixSum(int N, int M, int[][] arr) {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] += arr[i - 1][j];
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[j][i] += arr[j][i - 1];
            }
        }
    }
}