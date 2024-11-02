import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            int result = solution(0, str.length() - 1, str, 0);
            System.out.println(result);
        }
    }
    
    private static int solution(int lt, int rt, String str, int cnt) {
        if (cnt >= 2) return 2;

        char[] chars = str.toCharArray();
        while (lt < rt) {
            if (chars[lt] == chars[rt]) {
                lt++;
                rt--;
            } else {
                return Math.min(solution(lt + 1, rt, str, cnt + 1), solution(lt, rt - 1, str, cnt + 1));
            }
        }

        return cnt;
    }
}