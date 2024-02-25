class Solution {
    // 1. Lock 확장
    // 2. 확장된 배열에서 key를 회전하면서 탐색
    // 3. key를 맞춘 부분 +1, 끝나면 다시 -1
    // 4. lock 범위가 전부 1이면 true
    public boolean solution(int[][] key, int[][] lock) {
        int nKey = key.length;
        int nLock = lock.length;
        
        // 1.
        int extendSize = 2 * (nKey - 1) + nLock;
        int[][] extendLock = new int[extendSize][extendSize];
        for (int i = nKey - 1; i < extendSize - (nKey - 1); i++) {
            for (int j = nKey - 1; j < extendSize - (nKey - 1); j++) {
                int row = i - (nKey - 1);
                int col = j - (nKey - 1);
                extendLock[i][j] = lock[row][col];
            }
        }
        
        // 2.
        for (int i = 0; i < extendSize - nKey + 1; i++) {
            for (int j = 0; j < extendSize - nKey + 1; j++) {
                int[][] copy = new int[nKey][nKey];
                for (int k = 0; k < nKey; k++) copy[k] = key[k].clone();
                if (isMatch(i, j, nKey, extendSize, extendLock, copy)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isMatch(int startX, int startY, int nKey, int extendSize, int[][] extendLock, int[][] copy) {
        for (int i = 0; i < 4; i++) {
            rotation(nKey, copy);
            
            for (int j = 0; j < nKey; j++) {
                for (int k = 0; k < nKey; k++) {
                    extendLock[startX + j][startY + k] += copy[j][k];
                }
            }
            
            // 키가 맞는지 확인하는 작업
            boolean check = true;
            for (int j = nKey - 1; j < extendSize - nKey + 1; j++) {
                for (int k = nKey - 1; k < extendSize - nKey + 1; k++) {
                    if (extendLock[j][k] != 1) {
                        check = false;
                        break;
                    }
                }
            }
            
            if (check) return true;
            
            // 3.
            recovery(startX, startY, nKey, extendLock, copy);
        }
        return false;
    }
    
    // extendLock 원상 복구
    private void recovery(int startX, int startY, int nKey, int[][] extendLock, int[][] copy) {
        for (int i = 0; i < nKey; i++) {
            for (int j = 0; j < nKey; j++) {
                extendLock[startX + i][startY + j] -= copy[i][j];
            }
        }
    }
    
    private void rotation(int nKey, int[][] copy) {
        int[][] tmp = new int[nKey][nKey];
        for (int i = 0; i < nKey; i++) {
            tmp[i] = copy[i].clone();
        }

        for (int i = 0; i < nKey; i++) {
            for (int j = 0; j < nKey; j++) {
                copy[i][j] = tmp[j][nKey - i - 1];
            }
        }
    }
}