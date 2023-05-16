import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Pillar implements Comparable<Pillar> {
        private int pos;
        private int h;

        public Pillar(int pos, int h) {
            this.pos = pos;
            this.h = h;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.pos - o.pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Pillar> list = new ArrayList<>();
        int maxY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Pillar(pos, h));
            maxY = Math.max(maxY, h);
        }
        Collections.sort(list);

        int middelIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).h == maxY) middelIdx = i;
        }

        int answer = list.get(middelIdx).h;
        Pillar start = list.get(0);
        for (int i = 1; i <= middelIdx; i++) {
            Pillar cur = list.get(i);

            if (cur.h >= start.h) {
                answer += (cur.pos - start.pos) * start.h;
                start = cur;
            }
        }

        start = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= middelIdx; i--) {
            Pillar cur = list.get(i);
            if (cur.h >= start.h) {
                answer += (start.pos - cur.pos) * start.h;
                start = cur;
            }
        }

        System.out.println(answer);
    }
}
