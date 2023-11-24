import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Element implements Comparable<Element> {
        private int num, idx;

        @Override
        public int compareTo(Element o) {
            return num - o.num;
        }
    }

    static int N;
    static Element[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new Element[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = new Element();
            A[i].num =Integer.parseInt(st.nextToken());
            A[i].idx = i;
        }

        Arrays.sort(A);
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[A[i].idx] = i;
        }

        for (int i = 0 ; i < N; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
