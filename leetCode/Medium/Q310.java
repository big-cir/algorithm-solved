class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int end = bfs(0, null, graph);
        int[] parent = new int[n];
        int start = bfs(end, parent, graph);

        List<Integer> path = new ArrayList<>();
        int pos = start;
        while (pos != -1) {
            path.add(pos);
            pos = parent[pos];
        }

        List<Integer> answer = new ArrayList<>();
        int size = path.size();
        int mid = size / 2;
        answer.add(path.get(mid));

        if (size % 2 == 0) answer.add(path.get(mid - 1));

        return answer;
    }

    private int bfs(int start, int[] parent, List<List<Integer>> graph) {
        if (parent != null) Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        int result = -1;
        int[] visited = new int[graph.size()];
        visited[start] = 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            result = queue.poll();

            for (int next : graph.get(result)) {
                if (visited[next] == 0) {
                    if (parent != null) {
                        parent[next] = result;
                    }

                    visited[next] = 1;
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}
