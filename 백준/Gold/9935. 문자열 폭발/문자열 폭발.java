import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String fire = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char x : str.toCharArray()) {
            sb.append(x);

            if (sb.length() >= fire.length()) {
                String substring = sb.substring(sb.length() - fire.length());

                if (substring.equals(fire)) sb.delete(sb.length() - fire.length(), sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
