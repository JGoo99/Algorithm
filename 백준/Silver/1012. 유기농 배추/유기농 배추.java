import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static class Node {
    int i;
    int j;
    public Node(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
  static int[][] bat;
  static boolean[][] visit;

  static int[] dj = {0, 0, -1, 1};
  static int[] di = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());

    for (int k = 0; k < t; k++) {
      st = new StringTokenizer(br.readLine(), " ");
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int baeCnt = Integer.parseInt(st.nextToken());

      bat = new int[n][m];
      visit = new boolean[n][m];
      while (baeCnt > 0) {
        st = new StringTokenizer(br.readLine(), " ");
        int j = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        bat[i][j] = 1;
        baeCnt--;
      }
      sb.append(getCnt()).append("\n");
    }
    System.out.print(sb);
  }

  private static int getCnt() {
    int cnt = 0;
    for (int i = 0; i < bat.length; i++) {
      for (int j = 0; j < bat[0].length; j++) {
        if (bat[i][j] == 1 && !visit[i][j]) {
          cnt++;
          dfs(new Node(i, j));
        }
      }
    }
    return cnt;
  }

  private static void dfs(Node node) {
    visit[node.i][node.j] = true;

    for (int k = 0; k < 4; k++) {
      Node next = new Node(node.i + di[k], node.j + dj[k]);
      if (next.i > -1 && next.i < bat.length && next.j > -1 && next.j < bat[0].length) {
        if (bat[next.i][next.j] == 1 && !visit[next.i][next.j]) {
          dfs(next);
        }
      }
    }
  }
}