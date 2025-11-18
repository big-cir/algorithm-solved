class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int n = image.length, m = image[0].length;
        int startValue = image[sr][sc];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && image[nx][ny] == startValue) {
                    image[nx][ny] = color;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return image;
    }
}
