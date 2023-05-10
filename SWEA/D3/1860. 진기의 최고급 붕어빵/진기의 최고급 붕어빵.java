import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			ArrayList <Integer> a = new ArrayList<>();
			int flag = 0;
			
			for(int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				a.add(tmp);
			}
			
			Collections.sort(a);
			for(int i = 0; i < n; i++) {
				int tmp = a.get(i);
				int sum = k * (tmp / m);
				if(sum < (i + 1))
					flag = 1;
			}
			if(flag == 0)
				System.out.println("#" + t + " " + "Possible");
			else
				System.out.println("#" + t + " " + "Impossible");
		}
	}
}