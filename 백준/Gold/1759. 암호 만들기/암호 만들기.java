import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static Set<Character> consonant = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    static char[] alpa, result;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new int[C];
        result = new char[L];
        alpa = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpa[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpa);
        sol(0, 0);
    }

    private static void sol(int Level, int idx) {
        if (Level == L) {
            int conso = 0;
            int vowel = 0;
            for (char x : result) {
                if (consonant.contains(x)) {
                    conso++;
                    continue;
                }
                vowel++;
            }

            if (conso >= 1 && vowel >= 2) {
                if (isSorted(result)) {
                    System.out.println(new String(result));
                }
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                result[Level] = alpa[i];
                sol(Level + 1, idx + 1);
                ch[i] = 0;
            }
        }
    }

    private static boolean isSorted(char[] chars) {
        char[] sortedChars = Arrays.copyOf(chars, chars.length);
        Arrays.sort(sortedChars);
        return Arrays.equals(chars, sortedChars);
    }
}
