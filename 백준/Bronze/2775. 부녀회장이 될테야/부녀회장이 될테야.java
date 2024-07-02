import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());

    int[][] arr = new int[15][15];
    for (int i = 0; i < arr[0].length; i++) {
      arr[i][0] = 1; // x 층 1 호 = 1 명
      arr[0][i] = i + 1; // 0 층 i 호 = i 명
    }

    for (int i = 1; i < arr[0].length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
      }
    }

    for (int i = 0 ; i < t; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());

      sb.append(arr[k][n - 1]).append("\n");
    }
    System.out.println(sb);
  }
}