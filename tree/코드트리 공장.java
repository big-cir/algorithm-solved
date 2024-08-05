import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<LinkedList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int j = 0;j < N / M; j++) {
                tmp.add(Integer.parseInt(br.readLine()));
            }

            list.add(tmp);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            // 1. 벨트의 제일 앞에 있는 물건을 하나 뽑아서 해당 벨트의 맨 뒤로 이동
            // 2. 벨트의 제일 뒤에 있는 물건을 제일 앞으로 이동
            // 3. A, B 벨트를 선택해서 B의 앞으로 이동
            int commandNum = Integer.parseInt(st.nextToken());
            int beltNum = Integer.parseInt(st.nextToken());
            LinkedList<Integer> belt = list.get(beltNum);

            if (commandNum == 1) {
                if (!belt.isEmpty()) belt.addLast(belt.removeFirst());
            } else if (commandNum == 2) {
                if (!belt.isEmpty()) belt.addFirst(belt.removeLast());
            } else {
                int beltNum2 = Integer.parseInt(st.nextToken());
                LinkedList<Integer> belt2 = list.get(beltNum2);
                belt2.addAll(0, belt);
                belt.clear();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i).stream().mapToInt(Integer::intValue).sum();
            if (sum >= T) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
