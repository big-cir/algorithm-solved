import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static int hit, max;

    public static int stringToInt(String s) {
        return Integer.valueOf(s);
    }

    public static void swap(String[] number, int coordi1, int coordi2) {
        String tmp = number[coordi1];
        number[coordi1] = number[coordi2];
        number[coordi2] = tmp;
    }

    public static void solution(int Level, String[] number, int start) {
        if (Level == hit) {
            max = Math.max(max, stringToInt(String.join("", number)));
            return;
        }

        for (int i = start; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                swap(number, i, j);
                solution(Level + 1, number, i);
                swap(number, i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            sb.setLength(0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] number = st.nextToken().split("");
            hit = Integer.parseInt(st.nextToken());
            if (hit > number.length) hit = number.length;
            
            max = Integer.MIN_VALUE;
            solution(0, number, 0);
            System.out.println(sb.append("#" + i + " ").append(max));
        }
    }
}
