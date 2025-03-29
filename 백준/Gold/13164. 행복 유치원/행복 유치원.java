import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] hGap = new int[N - 1];
        int start = arr[0];
        for (int i = 1; i < N; i++) {
            hGap[i - 1] = arr[i] - start;
            start = arr[i];
        }

        Arrays.sort(hGap);
        int cnt = 0;
        int answer = Arrays.stream(hGap).sum();
        for (int i = hGap.length - 1; i >= 0; i--) {
            if (cnt == M - 1) break;
            answer -= hGap[i];
            cnt++;
        }

        System.out.println(answer);
    }
}

