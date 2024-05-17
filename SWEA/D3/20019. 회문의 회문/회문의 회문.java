import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			String str = br.readLine();
			sb.append(str);
			int size = (str.length() - 1) / 2;
		
			boolean flag = true;
			if (!pallin(sb)) flag = false;
			if (!first(new StringBuilder(sb.substring(0, size)))) flag = false;
			if (!last(new StringBuilder(sb.substring(str.length() - size, str.length())))) flag = false;
			
			if (!flag) {
				System.out.println("#" + i + " " + "NO");
			} else {
				System.out.println("#" + i + " " + "YES");
			}
			sb.setLength(0);
		}
	}
	
	private static boolean pallin(StringBuilder sb) {
		return sb.toString().equals(sb.reverse().toString());
	}
	
	private static boolean first(StringBuilder sb) {
		return sb.toString().equals(sb.reverse().toString());
	}
	
	private static boolean last(StringBuilder sb) {
		return sb.toString().equals(sb.reverse().toString());
	}
}
