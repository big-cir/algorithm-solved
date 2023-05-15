import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] box;

    public static void girl(int swIdx) {
        int lt = swIdx - 1;
        int rt = swIdx + 1;

        if (lt > 0 && rt <= N) {
            while (lt > 0 && rt <= N) {
                if (box[lt] == box[rt]) {
                    if (box[lt] == 0) {
                        box[lt] = 1;
                        box[rt] = 1;
                    } else {
                        box[lt] = 0;
                        box[rt] = 0;
                    }
                } else {
                    break;
                }
                lt--;
                rt++;
            }
        }
        if (box[swIdx] == 1) {
            box[swIdx] = 0;
        } else {
            box[swIdx] = 1;
        }
    }

    public static void boy(int swIdx) {
        for (int i = swIdx; i <= N; i += swIdx) {
            if (box[i] == 1) {
                box[i] = 0;
            } else {
                box[i] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());

        // 1 = 남자, 2 = 여자
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int swIdx = Integer.parseInt(st.nextToken());

            if (sex == 2) {
                girl(swIdx);
            } else {
                boy(swIdx);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(box[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}