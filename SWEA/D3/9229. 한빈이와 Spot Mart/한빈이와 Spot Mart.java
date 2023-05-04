import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, M, max;
	
	public static void solution(int[] snack) {
		int lt = 0;
		int rt = snack.length - 1;
		
		while (lt < rt) {
			int sum = 0;
			sum = snack[lt] + snack[rt];
			if (sum > M) {
				rt--;
				continue;
			} else {
				lt++;
			}
			
			max = Math.max(sum, max);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] snack = new int[N];
			max = 0;
			
			for (int j = 0; j < N; j++) {
				snack[j] = sc.nextInt();
			}
			Arrays.sort(snack);
			solution(snack);
			
			if (max == 0) max = -1;
			System.out.println("#" + i + " " + max);
		}
	}
}
