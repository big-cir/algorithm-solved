import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static Set<Character> consonant = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    static char[] alpa;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new int[C];
        alpa = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpa[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpa);
        sol(0, new StringBuilder(), 0);
    }

    private static void sol(int Level, StringBuilder sb, int idx) {
        if (Level == L) {
            int conso = 0;
            int vowel = 0;
            char[] chars = sb.toString().toCharArray();
            for (char x : chars) {
                if (consonant.contains(x)) {
                    conso++;
                    continue;
                }
                vowel++;
            }

            if (conso >= 1 && vowel >= 2) {
                if (isSorted(chars)) {
                    System.out.println(sb);
                }
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                sb.append(alpa[i]);
                sol(Level + 1, sb, idx + 1);
                sb.setLength(sb.length() - 1);
                ch[i] = 0;
            }
        }
    }

    private static boolean isSorted(char[] chars) {
        String tmp = new String(chars);
        Arrays.sort(chars);

        String comp = new String(chars);
        if (tmp.equals(comp)) return true;
        return false;
    }
}
