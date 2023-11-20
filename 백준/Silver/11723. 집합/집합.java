import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String CHECK = "check";
    private static final String TOGGLE = "toggle";
    private static final String ALL = "all";

    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operationCount = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < operationCount; i++) {
            operation(br.readLine());
        }
        System.out.println(sb);
    }

    private static void operation(String command) {
        String[] operation = command.split(" ");
        String oper = operation[0];

        int num = 0;
        if (!oper.equals(ALL) && !oper.equals("empty")) {
            num = Integer.parseInt(operation[1]);
        }

        if (oper.equals(ADD)) {
            if (!list.contains(num)) {
                list.add(num);
            }
        } else if (oper.equals(REMOVE)) {
            if (list.contains(num)) {
                list.remove(Integer.valueOf(num));
            }
        } else if (oper.equals(CHECK)) {
            if (list.contains(num)) {
                sb.append("1").append("\n");
                return;
            }
            sb.append("0").append("\n");
        } else if (oper.equals(TOGGLE)) {
            if (list.contains(num)) {
                list.remove(Integer.valueOf(num));
            } else {
                list.add(num);
            }
        } else if (oper.equals(ALL)) {
            list = new ArrayList<>();
            for (int i = 1; i <= 20; i++) list.add(i);
        } else {
            list = new ArrayList<>();
        }
    }
}
