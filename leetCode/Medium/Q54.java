class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0, y = 0;
        int dir = 1;
        int cnt = 0;
        while (cnt < n * m) {
            if (matrix[x][y] != -101) {
                answer.add(matrix[x][y]);
                matrix[x][y] = -101;
                cnt++;
            }

            if (dir == 1) {
                if (y + 1 < m && matrix[x][y + 1] != -101) {
                    y += 1;
                } else {
                    dir = 2;
                }
            } else if (dir == 2) {
                if (x + 1 < n && matrix[x + 1][y] != -101) {
                    x += 1;
                } else {
                    dir = 3;
                }
            } else if (dir == 3) {
                if (y - 1 >= 0 && matrix[x][y - 1] != -101) {
                    y -= 1;
                } else {
                    dir = 0;
                }
            } else {
                if (x - 1 >= 0 && matrix[x - 1][y] != -101) {
                    x -= 1;
                } else {
                    dir = 1;
                }
            }
            
        }

        return answer;
    }
}
