import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr, ch;
    static int num = 100;
    static Set<Integer> set;

    public static void solution_1_combi(int Level, int sum) {
        if (Level == 6) {
            if (sum == num) {
                for (int i = 0; i < arr.length; i++) {
                    if (ch[i] == 1) {
                        set.add(arr[i]);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                solution_1_combi(Level + 1, sum + arr[i]);
                if (sum == num) return;
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        ch = new int[9];
        set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                solution_1_combi(0, arr[i]);
                ch[i] = 0;
            }
        }

        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        for (int x : answer) {
            System.out.println(x);
        }
    }
}
