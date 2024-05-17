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
			int N = Integer.parseInt(br.readLine());
			long[] answer = new long[N];
			long[] info = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			
			List<Long> list = new ArrayList<>();
			for (int j = info.length - 1; j >= 0; j--) {
				list.add(info[j]);
			}
			
			int idx = N - 1;
			while (!list.isEmpty()) {
				long price = list.get(0);
				long discount = discountPrice(price);
				
				if (list.remove(discount)) {
					answer[idx--] = discount;
					list.remove(price);
				}
				
			}
			
			System.out.print("#" + i + " ");
			for (long x : answer) System.out.print(x + " ");
			System.out.println();
		}
	}
	
	private static long discountPrice(long price) {
		return price * 3 / 4;
	}
}
