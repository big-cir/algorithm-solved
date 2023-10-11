import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, M, answer;
    static List<Integer> crane, box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        
        M = Integer.parseInt(br.readLine());
        box = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        crane.sort(Comparator.reverseOrder());
        box.sort(Comparator.reverseOrder());

        answer = 0;
        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!box.isEmpty()) {
            answer++;
            for (Integer getCrane : crane) {
                for (int i = 0; i < box.size(); i++) {
                    if (getCrane >= box.get(i)) {
                        box.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
