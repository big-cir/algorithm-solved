import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static int[][] farm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				String[] str = br.readLine().split("");
				for (int k = 0; k < N; k++) {
					farm[j][k] = Integer.parseInt(str[k]);
				}
			}

			int sum = 0;
			// 중앙 까지 상단부
			for (int j = 0; j <= (N / 2); j++) {
				for (int k = (N / 2) - j; k <= (N / 2) + j; k++) {
					sum += farm[j][k];
				}
			}
			
			// 중앙(미포함) 부터 하단부
			int a = 0;
			for (int j = N - 1; j > (N / 2); j--) {
				for (int k = (N / 2) - a; k <= (N / 2) + a; k++) {
					sum += farm[j][k];
				}
				a++;
			}
			System.out.println("#" + i + " " + sum);
		}
	}
}
