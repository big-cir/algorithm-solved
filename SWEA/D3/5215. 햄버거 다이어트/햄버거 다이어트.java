import java.util.Scanner;

public class Solution {
	static int calorie, max;
	
	public static void combi(int Level, int N, int[] scoreArr, int[] calArr, int score, int cal, int[] ch) {
		if (cal < calorie) {
			max = Math.max(max, score);
		}
		
		if (Level == N) {
			return;
		} else {
			combi(Level + 1, N, scoreArr, calArr, score + scoreArr[Level], cal + calArr[Level], ch);
			combi(Level + 1, N, scoreArr, calArr, score, cal, ch);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			calorie = sc.nextInt();
			
			int[] scoreArr = new int[N];
			int[] calArr = new int[N];
			int[] ch = new int[N];
			for (int j = 0; j < N; j++) {
				scoreArr[j] = sc.nextInt();
				calArr[j] = sc.nextInt();
			}
			
			max = 0;
			combi(0, N, scoreArr, calArr, 0, 0, ch);
			System.out.println("#" + i + " " + max);			
		}
	}
}
