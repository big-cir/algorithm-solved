import java.util.*;
import java.io.*;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        
        for (int i = 0; i < N; i++) treeMap.put(i, new ArrayList<>());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == - 1) {
                root = i;
                continue;
            }

            treeMap.get(parent).add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());
        answer = 0;
        if (root == removeNode) {
            System.out.println(answer);
            return;
        }

        treeMap.remove(removeNode);
        dfs(root, treeMap);

        System.out.println(answer);
    }

    private static void dfs(int vertex, TreeMap<Integer, List<Integer>> treeMap) {
        if (!treeMap.containsKey(vertex)) return;

        List<Integer> childs = treeMap.get(vertex);
        int childSize = childs.size();

        for (int child : childs) {
            if (treeMap.containsKey(child)) {
                dfs(child, treeMap);
            } else {
                childSize--;
            }
        }

        if (childSize == 0) {
            answer++;
        }
    }
}