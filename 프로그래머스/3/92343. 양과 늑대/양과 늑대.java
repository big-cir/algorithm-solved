import java.util.ArrayList;
import java.util.List;
class Solution {
    static int answer;
    static List<List<Integer>> graph;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] pos = edges[i];
            graph.get(pos[0]).add(pos[1]);
        }

        int[] ch = new int[info.length];
        dfs(0, info, ch, 0, 0);
        return answer;
    }

    public void dfs(int pos, int[] info, int[] ch, int sheepCnt, int wolfCnt) {
        ch[pos] = 1;

        if (info[pos] == 0) {
            sheepCnt++;
            answer = Math.max(sheepCnt, answer);
        }
        else wolfCnt++;

        if (sheepCnt <= wolfCnt) return;

        for (int i = 0; i < info.length; i++) {
            if (ch[i] == 1) {
                for (int next : graph.get(i)) {
                    if (ch[next] == 0) {
                        dfs(next, info, ch, sheepCnt, wolfCnt);
                        ch[next] = 0;
                    }
                }
            }
        }
    }
}