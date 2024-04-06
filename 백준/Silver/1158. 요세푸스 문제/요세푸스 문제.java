import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.addLast(i);

        int idx = K - 1;
        StringBuilder answer = new StringBuilder();
        answer.append("<");
        for (int i = 0; i < N - 1; i++) {
            idx %= list.size();
            answer.append(list.remove(idx)).append(", ");
            idx--;
            idx += K;
        }

        answer.append(list.get(0)).append(">");
        System.out.println(answer);
    }
}
