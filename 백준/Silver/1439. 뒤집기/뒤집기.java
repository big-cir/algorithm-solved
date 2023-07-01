import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int count = 0;
        int count2 = 0;
        
        if (chars[0] == '0') count++;
        else {
            count2++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (chars[i - 1] != chars[i]) {
                if (chars[i] == '0') count++;
                else {
                    count2++;
                }
            }
        }
        System.out.println(Math.min(count, count2));
    }
}