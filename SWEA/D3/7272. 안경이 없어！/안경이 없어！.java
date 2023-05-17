import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			String a = sc.next();
			String b = sc.next();
			int[] arr = new int[a.length()];
			int[] arr2 = new int[b.length()];
			
			for(int i=0;i<a.length();i++) {
				String a_result = a.substring(i,i+1);
				if(a_result.equals("B")) arr[i] = 2;
				else if(a_result.equals("A")||a_result.equals("D")||a_result.equals("O")||a_result.equals("P")||a_result.equals("Q")||a_result.equals("R")) arr[i] = 1;
				else arr[i] = 0;
			}
			
			for(int i=0;i<b.length();i++) {
				String b_result = b.substring(i,i+1);
				if(b_result.equals("B")) arr2[i] = 2;
				else if(b_result.equals("A")||b_result.equals("D")||b_result.equals("O")||b_result.equals("P")||b_result.equals("Q")||b_result.equals("R")) arr2[i] = 1;
				else arr2[i] = 0;
			}
			
			if(Arrays.equals(arr, arr2)) System.out.printf("#%d SAME\n",tc);
			else System.out.printf("#%d DIFF\n",tc);
		}
	}
}