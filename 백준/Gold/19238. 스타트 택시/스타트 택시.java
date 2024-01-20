import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, L, answer;
    static int[] taxiPos;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static List<int[]> customs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());       // 초기 연료

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        taxiPos = new int[2];
        taxiPos[0] = Integer.parseInt(st.nextToken()) - 1;
        taxiPos[1] = Integer.parseInt(st.nextToken()) - 1;

        // 출발지 좌표 | 목적지 좌표 | 택시와의 거리
        customs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int destX = Integer.parseInt(st.nextToken()) - 1;
            int destY = Integer.parseInt(st.nextToken()) - 1;
            customs.add(new int[] {startX, startY, destX, destY, 0});
        }

        answer = -1;
//        for (int i = 0; i < customs.size(); i++) {
//            if (!solution(ch)) {
//                System.out.println(-1);
//                return;
//            }
//        }
        if (!solution()) {
            System.out.println(-1);
            return;
        }
        System.out.println(L);
    }

    // 1. 초기 택시 위치와 손님들의 거리를 계산해서 위 조건을 적용 시킴
    // 2. 가장 가까운 손님에게 이동 (이동할 떄 연료도 차감)
    // 3. 목적지로 이동 (연로차감, 도착하면 이동 연료 * 2 획득)
    // 4. 1~3번 반복
    private static boolean solution() {
        // findMinDistance();
        int size = customs.size();
        for (int i = 0; i < size; i++) {
            findMinDistance();
            // 택시 -> 손님 가는 거리를 L에서 - 해야함. 그리고 taxiPos 갱신
            if (!goCustomer(0)) return false;
            if (!goDest(0)) return false;
            customs.remove(0);
        }
        return true;
    }

    private static void findMinDistance() {
        int[][] copy = new int[N][N];
        int[][] ch = new int[N][N];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {taxiPos[0], taxiPos[1]});
        ch[taxiPos[0]][taxiPos[1]] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && map[nx][ny] == 0) {
                    copy[nx][ny] = copy[now[0]][now[1]] + 1;
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        int size = customs.size();
        for (int i = 0; i < size; i++) {
            int[] customer = customs.get(i);
            int dis = copy[customer[0]][customer[1]];
            customer[4] = dis;
        }

        Collections.sort(customs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[4] == o2[4] && o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else if (o1[4] == o2[4]) {
                    return o1[0] - o2[0];
                }
                return o1[4] - o2[4];
            }
        });
    }

    // 1) 15 - 6 = 9
    //  1.1 -> 9 - 6 + 12 = 15
    // 2) 15 - 7 = 8
    //  2.1 -> 8 - 4 + 8 = 12
    // 3) 12 - 4 = 8
    //  3.1 -> 12
    private static boolean goCustomer(int idx) {
        // 택시와 손님의 위치가 같음
        int[] customer = customs.get(idx);
        if (customer[0] == taxiPos[0] && customer[1] == taxiPos[1]) return true;

        int[][] copy = new int[N][N];
        int[][] ch = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {taxiPos[0], taxiPos[1]});
        ch[taxiPos[0]][taxiPos[1]] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && map[nx][ny] == 0) {
                    copy[nx][ny] = copy[now[0]][now[1]] + 1;
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny});

                    if (!(nx == customer[0] && ny == customer[1]) && L == 0) return false;

                    if (nx == customer[0] && ny == customer[1]) {
                        L -= copy[nx][ny];
                        if (L <= -1) {
                            return false;
                        } else {
                            //System.out.println(" L  :" + L);
                            taxiPos[0] = nx;
                            taxiPos[1] = ny;
                            return true;
                        }
                    }
                }
            }
        }

        // 벽에 막히면 false 반환
        return false;
    }

    private static boolean goDest(int idx) {
        // 도착점과 택시 위치가 같음
        int[] customer = customs.get(idx);
        if (customer[2] == taxiPos[0] && customer[3] == taxiPos[1]) return true;

        int[][] copy = new int[N][N];
        int[][] ch = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {taxiPos[0], taxiPos[1]});
        ch[taxiPos[0]][taxiPos[1]] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && map[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    copy[nx][ny] = copy[now[0]][now[1]] + 1;
                    queue.offer(new int[] {nx, ny});

                    if (nx == customer[2] && ny == customer[3]) {
                        L -= copy[nx][ny];

                        if (L <= -1) {
                            return false;
                        } else {
                            taxiPos[0] = nx;
                            taxiPos[1] = ny;
                            L += 2 * copy[nx][ny];
                            //System.out.println(" Dest L : " + L);
                            return true;
                        }
                    }
                }
            }
        }

        // 벽에 막히면 false 반환
        return false;
    }
}
