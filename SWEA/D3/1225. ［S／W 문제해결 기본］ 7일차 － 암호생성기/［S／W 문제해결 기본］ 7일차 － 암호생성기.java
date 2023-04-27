import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 8; j++) {
				list.add(sc.nextInt());
			}
			
			int count = 1;

			while (list.get(7) > 0) {
				int tmp = list.get(0) - count;
				list.remove(list.get(0));
				
				if (tmp <= 0) tmp = 0;
				list.add(tmp);
				count++;
				
				if (count == 6) count = 1;
			}
			
			System.out.print("#" + T + " ");
			for (int x : list) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}