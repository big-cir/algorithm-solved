import java.util.*;

// 도넛 : [n, n] : 정점 개수와 나가는 간선 개수가 같음
// 막대 : [n, n - 1], 시작 정점 들어오는 간선 x, 끝 정점 나가는 간선 x
// 8자 : [2n + 1, 2n + 2] : 시작 정점은 나가는 간선이 2개
// 생성 정점 : 나가는 간선이 가장 많은 정점
class Solution {
    static List<List<Integer>> graph;
    static int N = 1000000;
    static int[] inEdge;
    
    public int[] solution(int[][] edges) {
        inEdge = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            // [a, b] a -> b
            int[] info = edges[i];
            graph.get(info[0]).add(info[1]);
            inEdge[info[1]]++;
        }

        int startVertex = findStartVertex();

        int[] answer = new int[4];
        answer[0] = startVertex;

        int[] ch = new int[N + 1];
        for (int start : graph.get(startVertex)) {
            int[] info = new int[2];

            if (ch[start] == 0) {
                ch[start] = 1;
                info[1] += graph.get(start).size();

                dfs(start, start, false, info, ch);
            }

            if (info[0] == info[1]) answer[1]++;
            else if (info[0] - info[1] == 1) answer[2]++;
            else if (info[0] - info[1] == -1) answer[3]++;
        }

        return answer;
    }

    private void dfs(int fix, int start, boolean flag, int[] info, int[] ch) {
        if (flag && fix == start) return;
        info[0]++;

        for (int next : graph.get(start)) {
            if (ch[next] == 0) {
                info[1] += graph.get(next).size();
                ch[next] = 1;
                dfs(fix, next, true, info, ch);
            }
        }
    }

    private int findStartVertex() {
        int startVertex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int size = graph.get(i).size();
            if (size > max && inEdge[i] == 0) {
                max = size;
                startVertex = i;
            }
        }

        return startVertex;
    }
}