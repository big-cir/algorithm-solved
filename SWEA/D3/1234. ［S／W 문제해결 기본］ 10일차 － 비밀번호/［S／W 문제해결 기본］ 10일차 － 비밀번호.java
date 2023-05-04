import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static String charToString(char ch) {
        return String.valueOf(ch);
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			String number = sc.next();
			for (char c : number.toCharArray()) {
				String str = charToString(c) + charToString(c);
				number = number.replaceAll(str, "");
			}
			System.out.println("#" + i + " " + number);
		}
	}
}
