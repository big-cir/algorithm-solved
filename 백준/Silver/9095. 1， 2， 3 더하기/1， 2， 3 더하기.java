import java.util.Scanner;

public class Main {
    static int[] nums;
    static int count;
    public static void DFS(int n, int num) {
        if (n == num) {
            count++;
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                int sum = n + nums[i];
                if (sum > num) {
                    continue;
                }
                DFS(sum, num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nums = new int[] {1, 2, 3};
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            count = 0;
            DFS(0, sc.nextInt());
            System.out.println(count);
        }
    }
}
