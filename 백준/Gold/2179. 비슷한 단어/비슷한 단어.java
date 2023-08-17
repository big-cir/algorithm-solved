import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        int idx = 0;
        int idx2 = 0;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            String word = str[i];
            for (int j = i + 1; j < N; j++) {
                String word2 = str[j];
                int headLength = 0;
                int size;
                if (word.length() < word2.length()) size = word.length();
                else size = word2.length();

                for (int k = 0; k < size; k++) {
                    if (word.charAt(k) != word2.charAt(k))break;
                    else headLength++;
                }

                if (max < headLength) {
                    max = headLength;
                    idx = i;
                    idx2 = j;
                }
            }
        }

        System.out.println(str[idx]);
        System.out.println(str[idx2]);
    }
}
