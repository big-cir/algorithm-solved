import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        if (N == 4 || N == 7) {
            count = -1;
        } else {
            while(N >= 3) {
                if (N % 5 != 0 && N % 3 != 0) {
                    count++;
                    N -= 5;
                } else if (N % 5 != 0 && N % 3 == 0) {
                    count++;
                    N -= 3;
                } else if (N % 5 == 0) {
                    count++;
                    N -= 5;
                }
            }
        }

        System.out.println(count);
    }
}
