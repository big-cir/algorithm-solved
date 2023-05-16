import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[R + 1][C + 1];
		int K = Integer.parseInt(br.readLine());
		
		int val = 1;
		int x = 1;
		int y = 1;
		int dir = 0;
		while (val < R * C) {
			arr[x][y] = val;
			if (arr[x][y] == K) break;
			int nx = x + direction[dir][0];
			int ny = y + direction[dir][1];
			
			if (nx >= 1 && nx <= R && ny >= 1 && ny <= C && arr[nx][ny] == 0) {
				x = nx;
				y = ny;
				val++;
			} else {
				dir++;
			}
			
			if (dir == 4) {
				dir = 0;
			}
		}
		
		if (R * C < K) {
			System.out.println(0);
		} else {
			System.out.println(y + " " + x);
		}
	}
}