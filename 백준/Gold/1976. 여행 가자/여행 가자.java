import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] unf, plan;
    static String answer = "YES";

    private static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int Find(int vertex) {
        if (vertex == unf[vertex]) {
            return vertex;
        } else {
            return unf[vertex] = Find(unf[vertex]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    Union(i, j);
                }
            }
        }

        plan = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        int start_vex = Find(plan[1]);
        for (int i = 2; i < plan.length; i++) {
            if (start_vex != Find(plan[i])) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}