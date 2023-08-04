import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ch;
    static String[][] map;
    static List<Integer> list = new ArrayList<>();

    public static int find(int x, int y, int sum) {
        ch[x][y] = 1;
        int tmp = sum;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && ch[nx][ny] == 0) {
                tmp += find(nx, ny, Integer.parseInt(map[nx][ny]));
            }
        }
        return tmp;
    }

    public int[] solution(String[] maps) {
        ch = new int[maps.length][maps[0].length()];
        map = new String[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            String sub = maps[i];
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = String.valueOf(sub.charAt(j));
                if (map[i][j].equals("X")) ch[i][j] = 1;
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (ch[i][j] == 0) {
                    list.add(find(i, j, Integer.valueOf(map[i][j])));
                }
            }
        }
        Collections.sort(list);

        return list.size() == 0 ? new int[] {-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
}