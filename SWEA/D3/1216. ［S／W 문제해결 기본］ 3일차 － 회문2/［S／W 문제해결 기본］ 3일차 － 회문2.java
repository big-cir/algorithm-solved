import java.util.Scanner;

public class Solution {
	static int max, N = 100;
	static String[][] arr = new String[N][N];
	static StringBuilder sb;
	
	public static void solution(int x, int y) {
		String str = "";
		for (int i = y; i < N; i++) {
			str += arr[x][i];
			String sb = new StringBuilder(str).reverse().toString();
			
			if (str.equals(sb)) {
				max = Math.max(max, str.length());
			}
		}
		
		str = "";
		for (int i = x; i < N; i++) {
			str += arr[i][y];
			String sb = new StringBuilder(str).reverse().toString();
			
			if (str.equals(sb)) {
				max = Math.max(max, str.length());
			}
			
		}
	}
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();
			max = 0;
			
			for (int j = 0; j < N; j++) {
				String[] str = sc.next().split("");
				for (int k = 0; k < N; k++) {
					arr[j][k] = str[k];
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					solution(j, k);
				}
			}
			
			System.out.println("#" + i + " " + max);
		}
	}
}
