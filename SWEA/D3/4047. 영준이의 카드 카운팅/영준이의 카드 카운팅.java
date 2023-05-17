import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<List<String>> list;

    static boolean validation(List<List<String>> list, String number, int idx) {
        if (!list.get(idx).contains(number)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(new ArrayList<>());
                for (int j = 1; j <= 13; j++) {
                    if (j < 10) {
                        list.get(i).add("0" + j);
                    } else {
                        list.get(i).add("" + j);
                    }
                }
            }

            // S, D, H, C
            String str = br.readLine();
            boolean answer = true;

            //int size = str.length() / 3;
            for (int i = 0; i < str.length(); i += 3) {
                String card = str.substring(i, i + 3);
                String type = card.substring(0, 1);
                String number = card.substring(1, 3);

                if (type.equals("S")) {
                    if (validation(list, number, 0)) {
                        list.get(0).remove(number);
                    } else {
                        answer = false;
                        break;
                    }
                } else if (type.equals("D")) {
                    if (validation(list, number, 1)) {
                        list.get(1).remove(number);
                    } else {
                        answer = false;
                        break;
                    }
                } else if (type.equals("H")) {
                    if (validation(list, number, 2)) {
                        list.get(2).remove(number);
                    } else {
                        answer = false;
                        break;
                    }
                } else {
                    if (validation(list, number, 3)) {
                        list.get(3).remove(number);
                    } else {
                        answer = false;
                        break;
                    }
                }
            }

            if (answer) {
                System.out.println("#" + tc + " " +
                        list.get(0).size() + " " + list.get(1).size() + " " + list.get(2).size() + " " + list.get(3).size());
            } else {
                System.out.println("#" + tc + " ERROR");
            }
        }
    }
}
