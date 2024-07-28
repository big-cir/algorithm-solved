import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(br.readLine().trim());

        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];
        for (int i = 0; i < M; i++) b[i] = Integer.parseInt(br.readLine().trim());

        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        for (int start = 0; start < N - M + 1; start++) {
            int[] tmp = new int[M];
            for (int i = 0; i < tmp.length; i++) tmp[i] = a[start + i];

            if (check(b.clone(), tmp)) {
                answer.add(start + 1);
                cnt++;
            }
        }

        Collections.sort(answer);
        System.out.println(cnt);
        for (int x : answer) System.out.println(x);
    }

    public static boolean check(int[] compB, int[] tmp) {
        Arrays.sort(compB);
        Arrays.sort(tmp);
        boolean flag = true;

        if (compB[0] == tmp[0]) {
            for (int i = 1; i < tmp.length; i++) {
                if (compB[i] != tmp[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        flag = true;
        int gap = compB[0] - tmp[0];
        for (int i = 1; i < tmp.length; i++) {
            if (compB[i] - tmp[i] != gap) {
                flag = false;
                break;
            }
        }

        if (flag) return true;

        return false;
    }
}
