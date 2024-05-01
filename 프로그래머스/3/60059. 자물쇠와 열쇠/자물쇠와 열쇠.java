class Solution {
    static int n, m, size;
    static int[][] map;
    
    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;

        // 1. 초기화
        size = m + 2 * (n - 1);
        map = new int[size][size];
        for (int i = n - 1; i < size - (n - 1); i++) {
            for (int j = n - 1; j < size - (n - 1); j++) {
                map[i][j] = lock[i - (n - 1)][j - (n - 1)];
            }
        }

        // 2. (0, 0)부터 key 맞추기
        // (n-1) -> (n + 1)까지
        for (int i = 0; i < size - (n - 1); i++) {
            for (int j = 0; j < size - (n - 1); j++) {
                // 2-1. key를 90도 돌리면서 lock에 match 되는지 확인
                for (int k = 0; k < 4; k++) {
                    key = rotation(key);
                    if (isMatches(i, j, key)) return true;
                }
            }
        }

        return false;
    }

    private boolean isMatches(int x, int y, int[][] key) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int row = x + i;
                int col = y + j;
                map[row][col] += key[i][j];
            }
        }

        for (int i = n - 1; i < map.length - (n - 1); i++) {
            for (int j = n - 1; j < map.length - (n - 1); j++) {
                if (map[i][j] != 1) {
                    // 원상태로
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            int row = x + k;
                            int col = y + l;
                            map[row][col] -= key[k][l];
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    // 90도 회전
    private int[][] rotation(int[][] key) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = key[j][n - i - 1];
            }
        }

        return copy;
    }
}