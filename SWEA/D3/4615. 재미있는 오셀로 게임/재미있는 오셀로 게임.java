import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] direction = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int[][] board;
	
	private static void init() {
		board = new int[N][N];
		board[N / 2][N / 2] = 2;
		board[N / 2 - 1][N / 2 - 1] = 2;
		board[N / 2 - 1][N / 2] = 1;
		board[N / 2][N / 2 - 1] = 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			init();
			
			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int stone = sc.nextInt();
				board[x][y]= stone;
				
				for (int j = 0; j < 8; j++) {
					int nx = x + direction[j][0];
					int ny = y + direction[j][1];
					
					while (true) {
						if (!(nx >= 0 && nx < N && ny >= 0 && ny < N) || board[nx][ny] == 0) break;
						
						if (board[nx][ny] != board[x][y]) {
							nx += direction[j][0];
							ny += direction[j][1];
						} else {
							break;
						}
						
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == board[x][y]) {
							while (x != nx || y != ny) {
								board[nx][ny] = board[x][y];
								nx -= direction[j][0];
								ny -= direction[j][1];
							}
						}			
					}
				}
			}
			
			int black = 0, white = 0;
			for (int[] sub : board) {
				for (int num : sub) {
					if (num == 1) {
						black++;
					} else if (num == 2){
						white++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + black + " " + white);
		}
	}
}