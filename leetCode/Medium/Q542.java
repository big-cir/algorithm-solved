class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && mat[nx][ny] == -1) {
                    queue.offer(new int[] {nx, ny});
                    mat[nx][ny] = mat[x][y] + 1;
                }
            }
        }

        return mat;
    }
}
