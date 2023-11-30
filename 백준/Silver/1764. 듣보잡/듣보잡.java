import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static String[] heard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        binarySearch(br);
    }

    private static void binarySearch(BufferedReader br) throws IOException {
        List<String> answer = new ArrayList<>();
        heard = new String[N];
        for (int i = 0; i < N; i++) {
            heard[i] = br.readLine();
        }
        Arrays.sort(heard);

        int count = 0;
        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            int lt = 0;
            int rt = N - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (heard[mid].equals(target)) {
                    count++;
                    answer.add(target);
                    break;
                }

                if (heard[mid].compareTo(target) < 0) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(count);
        for (String x : answer) {
            System.out.println(x);
        }
    }
}