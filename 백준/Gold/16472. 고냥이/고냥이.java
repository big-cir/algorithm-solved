import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int answer = 0;
        int[] alpa = new int[26];
        int lt = 0;
        int rt = 0;

        alpa[str.charAt(rt) - 'a'] += 1;
        int cnt = 1;
        while (rt < str.length() - 1) {
            rt++;
            if (alpa[str.charAt(rt) - 'a'] == 0) {
                cnt++;
            }
            alpa[str.charAt(rt) - 'a'] += 1;

            while (cnt > N) {
                alpa[str.charAt(lt) - 'a'] -= 1;
                if (alpa[str.charAt(lt) - 'a'] == 0) {
                    cnt--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}
