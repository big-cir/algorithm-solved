import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] humans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        humans = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            humans[i] = Integer.parseInt(st.nextToken());
        }

        // 둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다. 
        // 2 1 1 0
        // idx : val (0, 4) (1, 3) (1, 2) (2, 1)  --> 4 -> 4 3 -> 4 2 3 --> 4 2 1 3
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = N; i >= 1; i--) {
            list.add(humans[i], i);
        }


        for (int x : list) System.out.print(x + " ");
    }
}
