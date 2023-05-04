import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String[] str = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String tCase = sc.next();
			int count = sc.nextInt();
			answer = new int[count];
			
			for (int j = 0; j < count; j++) {
				String strNum = sc.next();
				if (strNum.equals(str[0])) {
					answer[j] = 0; 
				} else if(strNum.equals(str[1])) {
					answer[j] = 1; 
				} else if (strNum.equals(str[2])) {
					answer[j] = 2; 
				} else if (strNum.equals(str[3])) {
					answer[j] = 3; 
				} else if (strNum.equals(str[4])) {
					answer[j] = 4; 
				} else if (strNum.equals(str[5])) {
					answer[j] = 5; 
				} else if (strNum.equals(str[6])) {
					answer[j] = 6; 
				} else if (strNum.equals(str[7])) {
					answer[j] = 7; 
				} else if (strNum.equals(str[8])) {
					answer[j] = 8; 
				} else if (strNum.equals(str[9])){
					answer[j] = 9; 
				}
			}
			
			Arrays.sort(answer);
			System.out.print(tCase + " ");
			for (int j = 0; j < count; j++) {
				System.out.print(str[answer[j]] + " ");
			}
			System.out.println();
		}
	}
}