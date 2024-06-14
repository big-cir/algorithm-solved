import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Element {
        private int idx;
        private int hegiht;

        public Element(int idx, int hegiht) {
            this.idx = idx;
            this.hegiht = hegiht;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Element> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < info.length; i++) {
            if (!stack.isEmpty()) {
                while (info[i] > stack.peek().hegiht) {
                    Element e = stack.pop();
                    if (stack.isEmpty()) break;

                    int wWidth = i - stack.peek().idx - 1;
                    int wHeight = Math.min(info[i], stack.peek().hegiht) - info[e.idx];
                    answer += wWidth * wHeight;
                }
            }

            stack.push(new Element(i, info[i]));
        }

        System.out.println(answer);
    }
}