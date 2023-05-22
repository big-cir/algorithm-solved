import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long count;

    public static void solution(List<Integer> list, int sum, int T, int startIdx) {
        if (sum == T) {
            count++;
        } else {
            for (int i = startIdx; i < list.size(); i++) {
                sum += list.get(i);
                if (sum > T) continue;
                solution(list, sum + list.get(i), T, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> sumA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int sum = A[i];
            sumA.add(sum);
            for (int j = i; j < N; j++) {
                if (j == i) continue;
                sum += A[j];
                sumA.add(sum);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumB = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int sum = B[i];
            sumB.add(sum);
            for (int j = i; j < M; j++) {
                if (j == i) continue;
                sum += B[j];
                sumB.add(sum);
            }
        }
        sumA.sort(null);
        sumB.sort(null);

        count = 0;
        int pa = 0;
        int pb = sumB.size() - 1;

        while (pa < sumA.size() && pb >= 0) {
            long sum = sumA.get(pa) + sumB.get(pb);

            if (sum == T) {
                int equalA = sumA.get(pa);
                int equalB = sumB.get(pb);
                long aCount = 0;
                long bCount = 0;

                while (pa < sumA.size() && sumA.get(pa) == equalA) {
                    pa++;
                    aCount++;
                }

                while (pb >= 0 && sumB.get(pb) == equalB) {
                    pb--;
                    bCount++;
                }

                count += aCount * bCount;
            } else if (sum < T) {
                pa++;
            } else {
                pb--;
            }
        }

        System.out.println(count);
    }
}