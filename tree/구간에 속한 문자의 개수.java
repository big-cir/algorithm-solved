import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 3차원 배열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 초기화
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tmp = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                String str = tmp[j];
                if ("a".equals(str)) {
                    arr[i][j] = 1;
                } else if ("b".equals(str)) {
                    arr[i][j] = 2;
                } else {
                    arr[i][j] = 3;
                }
            }
        }

        // 누적합 배열 생성 및 초기화
        int[][][] sum = new int[n + 1][m + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 0; l < 3; l++) {
                    int value = 0;

                    if (arr[i - 1][j - 1] == l + 1) value = 1;

                    sum[i][j][l] =
                            sum[i][j][l] + sum[i - 1][j][l] + sum[i][j - 1][l] - sum[i - 1][j - 1][l] + value;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] result = new int[3];

        // 범위 합 구하기
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                result[j] =
                        sum[x2][y2][j] - sum[x2][y1 - 1][j] - sum[x1 - 1][y2][j] + sum[x1 - 1][y1 - 1][j];

                sb.append(result[j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}

// 2. List
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tmp = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
            }
        }

        List<List<int[]>> sum = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                list.add(new int[3]);
            }
            sum.add(list);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum.get(i).set(j, caculate(i, j, arr, sum));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] result = calculateSum(x1, y1, x2, y2, sum);
            sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[] calculateSum(int x1, int y1, int x2, int y2, List<List<int[]>> sum) {
        int[] result = new int[3];
        int[] x2y2 = sum.get(x2).get(y2);
        int[] x1my2 = sum.get(x1 - 1).get(y2);
        int[] x2y1m = sum.get(x2).get(y1 - 1);
        int[] x1my1m = sum.get(x1 - 1).get(y1 - 1);

        result[0] += (x2y2[0] - x1my2[0] - x2y1m[0] + x1my1m[0]);
        result[1] += (x2y2[1] - x1my2[1] - x2y1m[1] + x1my1m[1]);
        result[2] += (x2y2[2] - x1my2[2] - x2y1m[2] + x1my1m[2]);

        return result;
    }

    private static int[] caculate(int i, int j, String[][] arr, List<List<int[]>> list) {
        int[] result = new int[3];
        int[] s1 = list.get(i - 1).get(j);
        int[] s2 = list.get(i).get(j - 1);
        int[] s3 = list.get(i - 1).get(j - 1);

        result[0] = s1[0] + s2[0] - s3[0];
        result[1] = s1[1] + s2[1] - s3[1];
        result[2] = s1[2] + s2[2] - s3[2];

        if (arr[i - 1][j - 1].equals("a")) {
            result[0]++;
        } else if (arr[i - 1][j - 1].equals("b")) {
            result[1]++;
        } else {
            result[2]++;
        }

        return result;
    }
}
