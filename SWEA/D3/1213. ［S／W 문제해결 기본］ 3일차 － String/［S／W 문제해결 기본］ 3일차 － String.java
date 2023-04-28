import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();
			String find = sc.next();
			String sentence = sc.next();
			
			int count = 0;
			
			for (int j = 0; j <= sentence.length() - find.length(); j++) {
				String sub = sentence.substring(j, j + find.length());
				if (find.equals(sub)) count++;
			}
			
			System.out.println("#" + T + " " + count);
		}
	}
}
