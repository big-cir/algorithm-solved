import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String start = st.nextToken();
        String end = st.nextToken();
        String lastEnd = st.nextToken();

        int startTime = toTIme(start);
        int endTIme = toTIme(end);
        int lastEndTime = toTIme(lastEnd);
        Set<String> set = new HashSet<>();
        int answer = 0;
        String str = "";
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            String time = st.nextToken();
            String name = st.nextToken();

            int numTime = toTIme(time);
            if (numTime <= startTime) set.add(name);
            else if (numTime >= endTIme && numTime <= lastEndTime) {
                if (set.contains(name)) {
                    set.remove(name);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static int toTIme(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}