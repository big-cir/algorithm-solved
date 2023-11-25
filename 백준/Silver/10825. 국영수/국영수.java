import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Subject[] sub = new Subject[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sub[i] = new Subject(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(sub);

        for (Subject s : sub) {
            System.out.println(s.name);
        }
    }
    static class Subject implements Comparable<Subject> {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Subject(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Subject o) {
            if (korean == o.korean && english == o.english && math == o.math) {
                return name.compareTo(o.name);
            }

            if (korean == o.korean && english == o.english) {
                return o.math - math;
            }

            if (korean == o.korean) {
                return english - o.english;
            }

            return o.korean - korean;
        }
    }
}