import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] secret = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			 
			int cc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cc; j++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int[] commandArr = new int[y];
				for (int k = 0; k < y; k++) {
					commandArr[k]= Integer.parseInt(st.nextToken());
				}
				
				for (int k = 0; k < y; k++) {
					list.add(x + k, commandArr[k]);
				}
			}
			
			System.out.print("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
}