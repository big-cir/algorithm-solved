import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int distance = 0;
            int speed = 0;

            for (int j = 0; j < N; j++) {
                int command = sc.nextInt();
                if (command == 0) {
                    distance += speed;
                    continue;
                }
                int accel = sc.nextInt();

                if (command == 1) {
                    speed += accel;
                } else {
                    speed -= accel;
                }

                if (speed < 0) speed = 0;
                distance += speed;
            }

            System.out.println("#" + i + " " + distance);
        }
    }
}
