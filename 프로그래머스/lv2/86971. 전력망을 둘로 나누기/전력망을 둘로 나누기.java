import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    static int[] ch;
    static List<List<Integer>> graph = new ArrayList<>();

    public static int dfs(int vertex) {
        ch[vertex] = 1;
        int count = 1;

        for (int nextV : graph.get(vertex)) {
            if (ch[nextV] == 0) {
                count += dfs(nextV);
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            Arrays.fill(ch, 0);
            int val = dfs(v1);

            Arrays.fill(ch, 0);
            int val2 = dfs(v2);

            answer = Math.min(answer, Math.abs(val - val2));

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return answer;
    }
}