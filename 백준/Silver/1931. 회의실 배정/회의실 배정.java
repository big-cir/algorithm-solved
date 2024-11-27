import java.util.*;
import java.io.*;

public class Main {

    static class Office implements Comparable<Office> {
        int start;
        int end;

        public Office(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Office o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Office[] offices = new Office[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            offices[i] = new Office(start, end);
        }
        Arrays.sort(offices);
        
        int answer = 0;
        int time = 0;
        for (int i = 0; i < offices.length; i++) {
            Office now = offices[i];
            if (time <= now.start) {
                answer++;
                time = now.end;
            }
        }

        System.out.println(answer);
    }
}