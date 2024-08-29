import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> lca = new ArrayList<>();
        lca.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > lca.get(lca.size() - 1)) lca.add(arr[i]);
            else {
                int lt = 0;
                int rt = lca.size() - 1;

                while (lt < rt) {
                    int mid = (lt + rt) / 2;

                    if (arr[i] > lca.get(mid)) lt = mid + 1;
                    else rt = mid;
                }

                lca.set(rt, arr[i]);
            }
        }

        System.out.println(lca.size());
    }
}