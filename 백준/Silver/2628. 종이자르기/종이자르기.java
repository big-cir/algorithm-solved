import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static int cut(int size, List<Integer> list) {
        if (list.size() == 0) {
            return size;
        }
        Collections.sort(list);
        int max = list.get(0);

        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, Math.abs(list.get(i) - list.get(i + 1)));
        }
        max = Math.max(max, size - list.get(list.size() - 1));
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int way = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < way; i++) {
            st = new StringTokenizer(br.readLine());

            // 0 = row, 1 = col
            int type = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (type == 0) {
                list1.add(pos);
            } else {
                list2.add(pos);
            }
        }

        int x = cut(M, list1);
        int y = cut(N, list2);

        System.out.println(x * y);
    }
}