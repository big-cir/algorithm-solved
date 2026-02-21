class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int capacity = 0;
        int answer = 0; // Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) capacity++;
                else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], time = current[2];

            if (capacity == 0) {
                answer = time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nt = time + 1;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny, nt});
                    capacity--;
                }
            }
        }

        if (capacity != 0) return -1;
        return answer;
    }
}
