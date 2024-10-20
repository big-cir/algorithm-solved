import java.util.*;
import java.io.*;

public class Main {

    static int N, x, y;
    static int[] arr, depth, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        depth = new int[N + 1];
        int findVertex = lca(x - 1, y - 1);

        Stack<Integer> stack = new Stack<>();
        int vertext = 1;
        int resultX = 0;
        int resultY = 0;
        stack.push(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                stack.push(vertext++);

                if (stack.peek() == findVertex) resultX = i + 1;
            } else {
                if (stack.pop() == findVertex) resultY = i + 1;
            }
        }

        System.out.println(resultX + " " + resultY);
    }

    private static int lca(int x, int y) {
        Stack<Integer> stack = new Stack<>();
        int vertex = 0;
        int level = 0;
        stack.push(vertex);
        
        int app1 = 0;
        int app2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                vertex++;
                parent[vertex] = stack.peek();
                depth[vertex] = level++;
                stack.push(vertex);
            } else {
                level--;
                stack.pop();
            }

            if (i == x) app1 = vertex;
            if (i == y) app2 = vertex;
        }

        while (depth[app1] != depth[app2]) {
            int app1Depth = depth[app1];
            int app2Depth = depth[app2];

            if (app1Depth > app2Depth) {
                app1 = parent[app1];
            }

            if (app2Depth > app1Depth) {
                app2 = parent[app2];
            }
        }

        while (app1 != app2) {
            app1 = parent[app1];
            app2 = parent[app2];
        }

        return app1;
    }
}
