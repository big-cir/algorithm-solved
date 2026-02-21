class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue;

                bfs(i, j, n, m, grid);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int i, int j, int n, int m, char[][] grid) {
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int pos = 0; pos < 4; pos++) {
                int nx = x + dx[pos];
                int ny = y + dy[pos];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
