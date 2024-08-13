import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int len, start, end;

        public Info(int len, int start, int end) {
            this.len = len;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if (len != o.len) {
                return o.len - len;
            } else if (start != o.start) {
                return start - o.start;
            }

            return end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(N + 1);

        TreeSet<Info> iSet = new TreeSet<>();
        iSet.add(new Info(N + 1, -1, N + 1));

        int[] rmNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int remove : rmNum) {
            set.add(remove);

            int prev = set.lower(remove);
            int next = set.higher(remove);

            iSet.remove(new Info(next - prev - 1, prev, next));
            iSet.add(new Info(remove - prev - 1, prev, remove));
            iSet.add(new Info(next - remove - 1, remove, next));

            System.out.println(iSet.first().len);
        }
    }
}
