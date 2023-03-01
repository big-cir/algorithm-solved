import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static Map<Character, Integer> pwcheck;

    public static int solution(int S, int P, String dna) {
        int answer = 0;

        // 초기 문자열 처리
        for (int i = 0; i < P; i++) {
            Character tmp = dna.charAt(i);
            pwcheck.put(tmp, pwcheck.getOrDefault(tmp, pwcheck.get(tmp)) + 1);
        }

        if (checkPw()) {
            answer++;
        }

        // sliding window 처리부분
        for (int i = P; i < S; i++) {
            int rm_idx = i - P;
            Character add_ch = dna.charAt(i);
            Character rm_ch = dna.charAt(rm_idx);
            pwcheck.put(rm_ch, pwcheck.getOrDefault(rm_ch, pwcheck.get(rm_ch)) - 1);
            pwcheck.put(add_ch, pwcheck.getOrDefault(add_ch, pwcheck.get(add_ch)) + 1);
            if (checkPw()) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean checkPw() {
        if (pwcheck.get('A') >= 0 && pwcheck.get('C') >= 0 && pwcheck.get('G') >= 0 && pwcheck.get('T') >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        pwcheck = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        pwcheck.put('A', -Integer.parseInt(st.nextToken()));
        pwcheck.put('C', -Integer.parseInt(st.nextToken()));
        pwcheck.put('G', -Integer.parseInt(st.nextToken()));
        pwcheck.put('T', -Integer.parseInt(st.nextToken()));

        System.out.println(solution(S, P, dna));
    }
}
