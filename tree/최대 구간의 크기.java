
public class Main {

  static class Point implements Comparable<Point> {
      private int p;
      private int value;
      private int index;

      public Point(int p, int value, int index) {
          this.p = p;
          this.value = value;
          this.index = index;
      }

      @Override
      public int compareTo(Point o) {
          return p - o.p;
      }
  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      List<Point> points = new ArrayList<>();
      StringTokenizer st;
      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());

          points.add(new Point(start, 1, i));
          points.add(new Point(end, -1, i));
      }

      Collections.sort(points);

      int answer = 0;
      Set<Integer> set = new HashSet<>();
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < points.size(); i++) {
          Point now = points.get(i);
          min = Math.min(min, now.p);

          if (now.value == 1) {
              set.add(now.index);
          } else {
              set.remove(now.index);

              // set 이 비어있으면 하나의 구간이라고 판단.
              if (set.isEmpty()) {
                  int tmp = now.p - min;
                  min = Integer.MAX_VALUE;
                  answer = Math.max(answer, tmp);
              }
          }
      }

      System.out.println(answer);
  }
}
