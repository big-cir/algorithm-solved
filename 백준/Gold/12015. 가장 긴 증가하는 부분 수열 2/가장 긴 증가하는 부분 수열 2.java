import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static List<Integer> list;

    public static void solution(int num) {
        int lt = 0;
        int rt = list.size() - 1;

        while (lt <= rt) {
            int mid = (lt +rt) / 2;
            if (num > list.get(mid)) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        list.set(lt, num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        list.add(0);
        int i = 0;
        for (int num : A) {
            if (num > list.get(i)) {
                i++;
                list.add(num);
            } else {
                solution(num);
            }
        }
        System.out.println(list.size() - 1);
    }
}
