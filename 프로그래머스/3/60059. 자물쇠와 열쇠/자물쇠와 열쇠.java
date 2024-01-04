import java.util.Arrays;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // key와 lock의 크기
        int M = key.length;
        int N = lock.length;
        int extendSize = N + 2 * (M - 1);
        int[][] extendMap = new int[extendSize][extendSize];
        
        // 확장된 map에 lock을 고정
        for (int i = M - 1; i < extendSize - (M - 1); i++) {
            for (int j = M - 1; j < extendSize - (M - 1); j++) {
                extendMap[i][j] = lock[i - (M - 1)][j - (M - 1)];
            }
        }
        
        // 90, 180, 270 회전하면서 확인한다.
        for (int i = 0; i < 4; i++) {
            // lock에 key가 맞으면 true를 반환
            if (isMatched(key, extendMap, M, N)) return true;
            else {
                rotation(key);
            }
        }
        return false;
    }
    
    private boolean isMatched(int[][] key, int[][] extendMap, int M, int N) {
        int[][] copyMap = new int[extendMap.length][extendMap.length];
        for (int i = 0; i < extendMap.length; i++) {
            System.arraycopy(extendMap[i], 0, copyMap[i], 0, extendMap[0].length);
        }
        
        // (0, 0)부터 확장된 Map에서 key의 크기만큼 탐색을 진행해야한다.
        for (int i = 0; i < extendMap.length - M + 1; i++) {
            for (int j = 0; j < extendMap.length - M + 1; j++) {
                
                // 확장된 Map의 lock 부분에 현재 key의 값을 더해준다.
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        copyMap[i + k][j + l] += key[k][l];
                    }
                }
                
                // lock이 전부 1인지 확인한다. 1이 아닌 숫자가 있으면 lock에 현재 key가 일치하지 않으므로 false 반환
                boolean flag = true;
                for (int k = M - 1; k < extendMap.length - M + 1; k++) {
                    for (int l = M - 1; l < extendMap.length - M + 1; l++) {
                        if (copyMap[k][l] != 1) {
                            flag = false;
                            break;
                        }
                    }
                }
                
                if (flag) return true;
                
                // 이전 결과로 되돌린다.
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        copyMap[i + k][j + l] -= key[k][l];
                    }
                }
            }
        }
        return false;
    }
    
    private void rotation(int[][] key) {
        int[][] copy = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            System.arraycopy(key[i], 0, copy[i], 0, key[0].length);
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                key[i][j] = copy[key.length - 1 - j][i];
            }
        }
    }
}