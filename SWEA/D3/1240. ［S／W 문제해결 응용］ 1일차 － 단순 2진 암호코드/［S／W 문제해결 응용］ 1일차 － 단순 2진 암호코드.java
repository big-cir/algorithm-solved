
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static String[] pattern = {
            "0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"
    };

    private static Map<String, Integer> map = new HashMap<>();

    private static int hashLength = 7;

    static int N, M;
    static List<String> list;
    public static void main(String[] args) throws IOException {

        for (int i = 0; i <= 9; i++) {
            map.put(pattern[i], i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int c = 1; c <= tc; c++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                list.add(str);
            }

            String findHashLine = checkContainNumber();

            if (!findHashLine.equals("")) {
                answer = checkWrongHash(findHashLine);
            }

            System.out.println("#" + c + " " + answer);
        }
    }

    private static int findDecodeNumber(String decode) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < decode.length(); i++) {
            int num = Integer.parseInt(String.valueOf(decode.charAt(i)));
            if (i % 2 == 0) {
                odd += num;
            }

            if (i % 2 == 1) {
                even += num;
            }
        }

        if (((odd * 3) + even) % 10 == 0) {
            int sum = 0;
            for (int i = 0; i < decode.length(); i++) {
                sum += Integer.parseInt(String.valueOf(decode.charAt(i)));
            }
            return sum;
        }
        return 0;
    }

    private static int checkWrongHash(String hashLine) {
        String decode = "";
        for (int i = 0; i < 56; i += hashLength) {
            decode += map.get(hashLine.substring(i, i + hashLength));
        }

        return findDecodeNumber(decode);
    }

    private static String checkContainNumber() {
        String findHashLine = "";
        for (int i = 0; i < N; i++) {
            String line = list.get(i);
            if (!line.contains("1")) continue;
            for (int j = 0; j < M - hashLength; j++) {
                String hashingNumber = line.substring(j, j + hashLength);

                if (map.containsKey(hashingNumber)) {
                    findHashLine = line.substring(j, j + 56);

                    boolean flag = true;
                    for (int k = hashLength; k < 56; k += hashLength) {
                        String findLeave = findHashLine.substring(k, k + hashLength);
                        if (!map.containsKey(findLeave)) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) continue;

                    for (int k = i + 1; k < i + 5; k++) {
                        String checkNextLine = list.get(k);
                        if (checkNextLine.substring(j, j + 56).equals(findHashLine)) {
                            return findHashLine;
                        }
                    }
                }
            }
        }
        return findHashLine;
    }
}
