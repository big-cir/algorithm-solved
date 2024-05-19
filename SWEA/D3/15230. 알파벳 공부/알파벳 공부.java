import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			char[] chars = br.readLine().toCharArray();
			char ch = chars[0];
			
			if (ch != 'a') {
				System.out.println("#" + i + " " + 0);
				continue;
			}
			
			int answer = 1;
			for (int j = 1; j < chars.length; j++) {
				if ((char) chars[j] - '1' != (char) ch - '0') {
					break;
				}
				answer++;
				ch = chars[j];
			}
			
			System.out.println("#" + i + " " + answer);
		}
	}
}
