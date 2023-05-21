class Solution {
	public static void main(String[] args) {
		int N = (int)Math.pow(10, 6);
		long[] answer = new long[N + 1];
		
		for (int i = 2; i <= N; i++) {
			if (answer[i] == 0) {
				System.out.print(i + " ");
				for (int j = i; j <= N; j += i) {
					answer[j]= 1; 
				}
			}
		}
	}
}