import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int width = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int dump = sc.nextInt();
			int[] arr = new int[width];
			int max = 0, min = 0;
			int answer = 0;
			
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt(); 
			}
						
			for (int j = 0; j < dump; j++) {
				int findMax = Arrays.stream(arr).max().getAsInt();
				int findMin = Arrays.stream(arr).min().getAsInt();
				
				for (int k = 0; k < width; k++) {
					if (findMax == arr[k]) {
						arr[k] -= 1;
						break;
					}
				}
				
				for (int k = 0; k < width; k++) {
					if (findMin == arr[k]) {
						arr[k] += 1;
						break;
					}
				}
		
				answer = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
			}		
			
			System.out.println("#" + i + " " + answer);
		}
	}
}