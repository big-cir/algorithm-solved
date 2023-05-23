import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;       // 회의 개수

    public static class Meet implements Comparable<Meet> {
        private int startTime;
        private int endTime;

        public Meet(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meet o) {
            if (endTime == o.endTime) return startTime - o.startTime;
            return endTime - o.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meet> meets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meets.add(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(meets);

        int max = 0;
        int time = 0;
        for (int i = 0; i < meets.size(); i++) {
            Meet curMeet = meets.get(i);
            if (time <= curMeet.startTime) {
                max++;
                time = curMeet.endTime;
            }
        }
        System.out.println(max);
    }
}
