import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 중간 값 N / 2
// 중간 위
// 중간 아래
public class Solution {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= caseCount; tc++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            
            int answer = middleOfUpper(N) + middle(N) + middleOfUnder(N);
            System.out.println("#" + tc + " " + answer);
        }
    }


    private static int middleOfUpper(int N) {
        int size = N / 2;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int start = size - i;
            int end = size + i;
            for (int j = start; j <= end; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static int middle(int N) {
        int[] middleSum = map[N / 2];
        return Arrays.stream(middleSum).sum();
    }

    private static int middleOfUnder(int N) {
        int size = N / 2;
        int sum = 0;
        int tmp = 0;
        for (int i = N - 1; i > size; i--) {
            int start = size - tmp;
            int end = size + tmp;
            for (int j = start; j <= end; j++) {
                sum += map[i][j];
            }
            tmp++;
        }
        return sum;
    }
}
