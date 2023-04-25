import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int P = sc.nextInt(); 
			int Q = sc.nextInt(); 
			int R = sc.nextInt(); 
			int S = sc.nextInt(); 
			int W = sc.nextInt(); 
			
			int solutionA = P * W;
			int solutionB = Q;
			int result = 0;
			
			if (W > R) {
				solutionB += (W - R) * S;
			}
            
            if (solutionA < solutionB) {
                result = solutionA;
            } else {
                result = solutionB;
            }
			
			System.out.println("#" + i + " " + result);
		}
	}
}
