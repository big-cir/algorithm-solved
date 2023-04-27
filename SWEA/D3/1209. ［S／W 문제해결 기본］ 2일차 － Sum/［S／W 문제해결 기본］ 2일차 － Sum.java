import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int[][] arr = new int[100][100];
	
	public static int rowMax() {
		int max = 0;
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += arr[i][j];
			}
			
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	public static int colMax() {
		int max = 0;
		
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += arr[j][i];
			}
			
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	public static int cross1Max() {
		int max = 0;
		for (int i = 0; i < 100; i++) {
			int sum = 0;
			for (int j = 0; j < 100; j++) {
				if (i == j) {
					sum += arr[i][j];
				} 
			}
			
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static int cross2Max() {
		int max = 0;
		for (int i = 99; i >= 0; i--) {
			int sum = 0;
			for (int j = 99; j >= 0; j--) {
				if (i == j) {
					sum += arr[i][j];
				} 
			}
			
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					arr[j][k]= sc.nextInt(); 
				}
			}
			
			int[] maxArr = new int[] {rowMax(), colMax(), cross1Max(), cross2Max()};
			int max = Arrays.stream(maxArr).max().getAsInt();
			System.out.println("#" + num + " " + max);	
		}			
	}
}
