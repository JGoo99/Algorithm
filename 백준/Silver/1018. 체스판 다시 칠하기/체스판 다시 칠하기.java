import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int fix = 8;
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[][] arr = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == 'W') {
          arr[i][j] = true;
        }
      }
    }

    int y = n - fix + 1;
    int x = m - fix + 1;
    int min = 8 * 8;
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        min = Math.min(getCnt(i, j, arr), min);
      }
    }
    System.out.println(min);
  }

  public static int getCnt(int a, int b, boolean[][] arr) {
    boolean flag = arr[a][b];
    int cnt = 0;
    for (int i = a; i < a + 8; i++) {
      for (int j = b; j < b + 8; j++) {
        if (arr[i][j] != flag) {
          cnt++;
        }
        flag = !flag;
      }
      flag = !flag;
    }
    return Math.min(cnt, 64 - cnt);
  }
}