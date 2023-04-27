import java.util.Scanner;

public class Solution {
	public static String[][] str = new String[8][8];
	public static int count;
	
	public static void findPalindrome(int x, int y, String s, int length) {
		StringBuilder sb = new StringBuilder();
		String find = s;
		
		if (8 >= length + y) {
			for (int i = y + 1; i < y + length; i++) {
				find += str[x][i];
			}
			sb = new StringBuilder(find).reverse();
			if (find.equals(sb.toString())) count++;
		}
		
	
		find = s;
		if (8 >= length + x) {
			for (int i = x + 1; i < x + length; i++) {
				find += str[i][y];
			}
			sb = new StringBuilder(find).reverse();
			if (find.equals(sb.toString())) count++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int length = sc.nextInt();
			count = 0;
			
			for (int j = 0; j < 8; j++) {
				String input = sc.next();
				for (int k = 0; k < 8; k++) {
					str[j][k]= String.valueOf(input.charAt(k)); 
				}
			}
			
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					findPalindrome(j, k, str[j][k], length);
				}
			}
			
			System.out.println("#" + i + " " + count);
		}
	}
}