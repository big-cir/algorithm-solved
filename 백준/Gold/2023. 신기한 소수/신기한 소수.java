import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Integer> answer;
    static int[] demical = {2, 3, 5, 7};

    public static void DFS(int Level, int value) {
        int prime;
        if (isPrime(value)) {
            if (Level == N) {
                answer.add(value);
            }

            for (int i = 1; i < 10; i++) {
                prime = value * 10 + i;
                DFS(Level + 1, prime);
            }
        }
    }

    
    public static boolean isPrime(int value) {
        if (value == 2) return true;
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        for (int i = 0; i < demical.length; i++) {
            DFS(1, demical[i]);
        }

        for (int x : answer) {
            System.out.println(x);
        }
    }
}
