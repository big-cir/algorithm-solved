import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int[] vertexs = wires[i];
            int v1 = vertexs[0];
            int v2 = vertexs[1];
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        for (int i = 0; i < n - 1; i++) {
            int[] vertexs = wires[i];
            int v1 = vertexs[0];
            int v2 = vertexs[1];
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));
            
            answer = Math.min(answer, search(v1, v2, list));
            
            list.get(v1).add(Integer.valueOf(v2));
            list.get(v2).add(Integer.valueOf(v1));
        }
        
        return answer;
    }
    
    private int search(int v1, int v2, List<List<Integer>> list) {
        int[] ch = new int[list.size() + 1];
        return Math.abs(dfs(list, ch, v1, 1) - dfs(list, ch, v2, 1));
    }
    
    private int dfs(List<List<Integer>> list, int[] ch, int vertex, int cnt) {    
        ch[vertex] = 1;
        List<Integer> con = list.get(vertex);
        for (int next : con) {
            if (ch[next] == 1) continue;
            cnt = dfs(list, ch, next, cnt + 1);
        }
        
        return cnt;
    }
}