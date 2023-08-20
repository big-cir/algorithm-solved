import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var q = br.readLine().toCharArray();

        // S : -
        // M : *
        // U : /
        // P : +
        // C : 결과값 반환
        int isC = 0;
        var answer = new StringBuilder();
        Queue<Integer> num = new LinkedList<>();
        Queue<Character> op = new LinkedList<>();

        var tmp = new StringBuilder();
        for (int i = 0; i < q.length; i++) {
            if (q[i] >= 'A' && q[i] <= 'Z') {
                op.offer(q[i]);
                if (q[i] == 'C') isC = 1;
            } else {
                tmp.append(q[i]);

                if (q[i + 1] >= 'A' && q[i + 1] <= 'Z') {
                    num.offer(Integer.parseInt(tmp.toString()));
                    tmp.setLength(0);
                }
            }
        }

        if (isC == 1) {
            int val = num.poll();
            while (true) {
                if (op.size() == 1) {
                    char last = op.poll();
                    if (last == 'C') {
                        answer.append(val).append(" ");
                    }
                    break;
                }

                char cal = op.poll();
                if (cal == 'S') {
                    val -= num.poll();
                } else if (cal == 'M') {
                    val *= num.poll();
                } else if (cal == 'U') {
                    val /= num.poll();
                } else if (cal == 'P'){
                    val += num.poll();
                } else {
                    answer.append(val).append(" ");
                }
            }
        }

        if (isC == 0) answer.append("NO OUTPUT");
        else {
            answer.deleteCharAt(answer.length() - 1);
        }

        System.out.print(answer);
    }
}
