import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String tmp = "";
        int answer = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                int value = Integer.parseInt(tmp);
                if (flag) {
                    flag = false;
                    answer += value;
                } else {
                    answer -= value;
                }
                tmp = "";
            } else if (str.charAt(i) == '+') {
                int value = Integer.parseInt(tmp);
                if (flag) {
                    answer += value;
                } else {
                    answer -= value;
                }
                tmp = "";
            } else {
                tmp += str.charAt(i);
            }
        }

        int last = Integer.parseInt(tmp);
        if (flag) {
            answer += last;
        } else {
            answer -= last;
        }

        System.out.println(answer);
    }
}