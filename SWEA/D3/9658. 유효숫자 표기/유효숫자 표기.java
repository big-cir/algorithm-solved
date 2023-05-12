import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");

			String str = br.readLine();
			int n = str.length() - 1;
			
			// 앞 두 자리가 99이고, 셋째자리가 5 이상이면 반올림하는데 10.0이 되니까
			if (str.substring(0, 2).equals("99") && str.charAt(2)-'0' >= 5) {
				sb.append("1.0");
				n = str.length();
			} else {
				int f = str.charAt(2) - '0';
				if (f >= 5) {
					int a = Integer.parseInt(str.substring(0, 2)) + 1;
					sb.append(a / 10).append(".").append(a % 10);
				} else {
					sb.append(str.charAt(0)).append(".").append(str.charAt(1));
				}
			}
			sb.append("*10^").append(n).append("\n");

		}

		System.out.println(sb);
		br.close();
	}

}