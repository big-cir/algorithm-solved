import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, max;
    static int[] num;
    static char[] command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int length = str.length();
        command = new char[length / 2];
        num = new int[length - command.length];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num[i / 2] = str.charAt(i) - '0';
            } else {
                command[i / 2] = str.charAt(i);
            }
        }

        max = num[0];
        for (int i = 0; i < command.length; i++) {
            max = calculate(command[i], max, num[i + 1]);
        }
        
        dfs(0, command, num, num[0]);
        System.out.println(max);
    }

    private static void dfs(int level, char[] command, int[] nums, int result) {
        if (level >= command.length) {
            max = Math.max(max, result);
            return;
        }

        dfs(level + 1, command, nums, calculate(command[level], result, nums[level + 1]));

        if (level + 1 < command.length) {
            int tmp = calculate(command[level + 1], nums[level + 1], nums[level + 2]);
            dfs(level + 2, command, nums, calculate(command[level], result, tmp));
        }
    }

    private static int calculate(char operation, int num1, int num2) {
        if (operation == '+') {
            return num1 + num2;
        } else if (operation == '-') {
            return num1 - num2;
        }

        return num1 * num2;
    }
}
