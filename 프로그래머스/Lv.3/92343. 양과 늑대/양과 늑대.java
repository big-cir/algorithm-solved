import java.util.ArrayList;
import java.util.List;
class Solution {
    static List<List<Integer>> graph;
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i <= info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph.get(v1).add(v2);
        }

        answer = 0;
        int[] ch = new int[edges.length + 1];
        dfs(0, info, ch, 0, 0);
        return answer;
    }
    
    private static void dfs(int vertex, int[] info, int[] ch, int sheep, int wolf) {
        ch[vertex] = 1;

        if (info[vertex] == 0) {
            sheep++;
            answer = Math.max(answer, sheep);
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 1) {
                for (int next : graph.get(i)) {
                    if (ch[next] == 0) {
                        dfs(next, info, ch, sheep, wolf);
                        ch[next] = 0;
                    }
                }
            }
        }
    }
}