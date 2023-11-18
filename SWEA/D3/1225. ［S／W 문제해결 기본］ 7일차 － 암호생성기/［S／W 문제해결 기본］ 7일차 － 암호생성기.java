import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int tc = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int dec = 1;
            while (!queue.contains(Integer.valueOf(0))) {
                int poll = queue.poll();
                poll -= dec;

                if (poll < 0) poll = 0;

                queue.add(poll);
                dec++;
                if (dec == 6) dec = 1;
            }

            String answer = "";
            while (!queue.isEmpty()) {
                answer += String.valueOf(queue.poll() + " ");
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}