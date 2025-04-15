import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < computers.length; i++) {
            int[] connection = computers[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (connection[j] == 1) graph.get(i).add(j);
            }
        }
        
        int answer = 0;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                answer++;
                dfs(i, ch, graph);
            }
        }
        
        return answer;
    }
    
    private void dfs(int vertex, int[] ch, List<List<Integer>> graph) {
        ch[vertex] = 1;
        
        for (int next : graph.get(vertex)) {
            if (ch[next] == 0) dfs(next, ch, graph);
        }
    }
}