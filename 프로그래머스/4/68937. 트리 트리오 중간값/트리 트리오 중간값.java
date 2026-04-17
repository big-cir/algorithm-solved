import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!graph.containsKey(v1)) {
                List<Integer> list = new ArrayList<>();
                list.add(v2);
                graph.put(v1, list);
            } else {
                graph.get(v1).add(v2);
            }
            
            if (!graph.containsKey(v2)) {
                List<Integer> list = new ArrayList<>();
                list.add(v1);
                graph.put(v2, list);
            } else {
                graph.get(v2).add(v1);
            }
        }
        
        Map<Integer, Integer> v1Info = bfs(edges[0][0], graph);
        int v2 = 0;
        int max = 0;
        for (int vertex : v1Info.keySet()) {
            if (max < v1Info.get(vertex)) {
                max = v1Info.get(vertex);
                v2 = vertex;
            }
        }
        
        Map<Integer, Integer> v2Info = bfs(v2, graph);
        int v3 = 0;
        max = 0;
        for (int vertex : v2Info.keySet()) {
            if (max < v2Info.get(vertex)) {
                max = v2Info.get(vertex);
                v3 = vertex;
            }
        }
        
        Map<Integer, Integer> v3Info = bfs(v3, graph);
        int diameter = 0;
        for (int vertex : v3Info.keySet()) {
            if (diameter < v3Info.get(vertex)) {
                diameter = v3Info.get(vertex);
            }
        }
        
        int answer = 0;
        int edgeVertex = 0;
        for (int key : v2Info.keySet()) {
            int maxDis = Math.max(v2Info.get(key), v3Info.get(key));
            if (maxDis == diameter) edgeVertex++;
        }
        
        if (edgeVertex > 2) answer = diameter;
        else answer = diameter - 1;
        
        return answer;
    }
    
    private Map<Integer, Integer> bfs(int start, Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> result = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        visit.add(start);
        queue.offer(new int[] {start, 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int v = info[0];
            int dis = info[1];
            result.put(v, dis);
            
            for (int next : graph.get(v)) {
                if (!visit.contains(next)) {
                    queue.offer(new int[] {next, dis + 1});
                    visit.add(next);
                }
            }
        }
        
        return result;
    }
}
