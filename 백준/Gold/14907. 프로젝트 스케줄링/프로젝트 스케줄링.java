import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = toNum('Z');
        int[] indegree = new int[size + 1];
        int[] times = new int[size + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            list.add(new ArrayList<>());
        }

        int last = 0;
        String str;
        while ((str = br.readLine()) != null) {
            if (str.isEmpty()) break;

            String[] strArr = str.split(" ");
            int workNum = toNum(strArr[0].charAt(0));
            int time = Integer.parseInt(strArr[1]);
            times[workNum] = time;
            last = Math.max(last, workNum);

            if (strArr.length > 2) {
                char[] prevWork = strArr[2].toCharArray();
                for (int i = 0; i < prevWork.length; i++) {
                    indegree[workNum]++;
                    list.get(toNum(prevWork[i])).add(workNum);
                }
            }
        }

        int[] result = new int[size + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= last; i++) {
            result[i] = times[i];
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + times[next]);

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }

    private static int toNum(char ch) {
        return ch - '0' - 16;
    }
}