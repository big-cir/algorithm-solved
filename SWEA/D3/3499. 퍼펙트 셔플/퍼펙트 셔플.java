import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            List<String> list = new ArrayList<>();
            for (int i = 1; i <= N; i++) list.add(sc.next());

            String str = "";
            if (N % 2 ==0) {
                int size = N / 2;
                for (int i = 0; i < size; i++) {
                    str += list.get(i) + " ";
                    if (i + size > list.size()) break;
                    else {
                        str += list.get(i + size) + " ";
                    }
                }
            } else {
                int size = N / 2;
                for (int i = 0; i <= size; i++) {
                    str += list.get(i) + " ";
                    if (i + size + 1 >= list.size()) break;
                    else {
                        str += list.get(i + size + 1) + " ";
                    }
                }
            }

            StringBuilder sb = new StringBuilder("#" + tc + " ").append(str);
            System.out.println(sb);
        }
    }
}
