import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 시작 (0, 0)
    // 첫날 크기 = 1, N 일동안 반복
    // 커지는 크기는 0, 1, 2 중 하나

    // 제일 왼쪽 열, 제일 위쪽 행 은 자라는 크기를 스스로 정함
    //  -> map[i][0], map[0][i]

    // 자라는 정도는 제일 왼쪽 아래 (M - 1, 0)에서 시작해서 위쪽으로 이동, 위끝에 도착하면 오른쪽으로 이동
    //  -> 즉, (M - 1, 0) 시작 -> (0, 0) -> (0, M - 1)

    // 남은 애들은 자신의 왼, 왼 대각선, 위 벌레들이 다 자라고, 가장 많이 자란 애벌레 만큼 자람

    // 격자 크기 M, 일수 N
    static int M, N;
    static int[] day;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][M];
        for (int[] arr : map) {
            Arrays.fill(arr, 1);
        }

        int[][] copy = new int[M][M];
        for (int j = 0; j < M; j++) {
            copy[j] = Arrays.copyOf(map[j], M);
        }

        for (int i = 0; i < N; i++) {
            day = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            flowDays(copy);

            for (int j = 1; j < M; j++) {
                for (int k = 1; k < M; k++) {
                    copy[j][k] += Math.max(left(j, k, copy), Math.max(right(j, k, copy), leftUp(j, k, copy)));
                }
            }

            for (int j = 0; j < M; j++) {
                map[j] = copy[j].clone();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : copy) {
            for (int answer : arr) {
                sb.append(answer).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 1 1 1 1       2 2 3 3    3 3 4 5
    // 1 1 1 1       2          3
    // 1 1 1 1  -->  1          2
    // 1 1 1 1       1          2

    private static void flowDays(int[][] copy) {
        int[] start = new int[]{M - 1, 0};

        for (int i = 0; i < 3; i++) {
            int value = day[i];

            for (int j = 0; j < value; j++) {
                copy[start[0]][start[1]] += i;
                if (checkLeft(start)) {
                    start[0]--;
                } else if (checkRight(start)) {
                    start[1]++;
                }
            }
        }
    }

    private static int leftUp(int x, int y, int[][] copy) {
        int nx = x - 1;
        int ny = y - 1;

        return Math.abs(map[nx][ny] - copy[nx][ny]);
    }

    private static int right(int x, int y, int[][] copy) {
        int nx = x - 1;
        int ny = y;
        return Math.abs(map[nx][ny] - copy[nx][ny]);
    }

    private static int left(int x, int y, int[][] copy) {
        int nx = x;
        int ny = y - 1;
        return Math.abs(map[nx][ny] - copy[nx][ny]);
    }

    private static boolean checkRight(int[] start) {
        return start[0] == 0 && start[1] < M - 1;
    }

    private static boolean checkLeft(int[] start) {
        return start[0] > 0 && start[1] == 0;
    }
}
