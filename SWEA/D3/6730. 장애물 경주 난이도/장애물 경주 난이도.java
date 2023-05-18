import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int up, down;
    public static void solution(int[] blocks) {

        if (blocks[1] - blocks[0] > 0) {
            up = blocks[1] - blocks[0];
        } else {
            down = Math.abs(blocks[1] - blocks[0]);
        }

        for (int i = 2; i < blocks.length; i++) {
            if (blocks[i] - blocks[i - 1] > 0) {
                up = Math.max(up, blocks[i] - blocks[i - 1]);
            } else {
                down = Math.max(down, Math.abs(blocks[i] - blocks[i - 1]));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] blocks = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }

            up = 0;
            down = 0;

            solution(blocks);
            System.out.println("#" + tc + " " + up + " " + down);
        }
    }
}
