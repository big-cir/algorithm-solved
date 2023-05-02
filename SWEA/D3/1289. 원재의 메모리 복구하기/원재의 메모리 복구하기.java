import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
	static int count;
	public static void solution(int[] origin, int[] init) {
		for (int i = 0; i < origin.length; i++) {
			if (origin[i] != init[i]) {
				count++;
				for (int j = i; j < origin.length; j++) {
					init[j] = origin[i]; 
				}
			} 
			
			if (Arrays.equals(origin, init)) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String N = sc.next();
			int[] origin = Stream.of(N.split("")).mapToInt(Integer::parseInt).toArray();
			int[] init = new int[N.length()];
			count = 0;
			solution(origin, init);
			System.out.println("#" + i + " " + count);
		
		}
	}
}
