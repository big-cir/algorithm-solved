import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringTokenizer st;
    static List<Info> list;

    static class Info {
        private int kg;
        private int cm;

        public Info(int kg, int cm) {
            this.kg = kg;
            this.cm = cm;
        }
    }

    public static int match(Info info) {
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (info.equals(list.get(i))) continue;
            if (info.cm < list.get(i).cm && info.kg < list.get(i).kg) {
                rank++;
            }
        }
        return rank;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < N; i++) {
            System.out.println(match(list.get(i)));
        }
    }
}
