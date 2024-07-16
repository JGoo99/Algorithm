import java.io.*;

public class Main {

  public static int[] dp;

  public static void main(String[] args) throws IOException {
    // dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    makeAnswerArr();

    int t = Integer.parseInt(br.readLine());
    while (t > 0) {
      int x = Integer.parseInt(br.readLine());
      sb.append(getCnt(x) + "\n");
      t--;
    }
    System.out.println(sb);
  }

  public static void makeAnswerArr() {
    dp = new int[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
  }

  public static int getCnt(int x) {
    return dp[x];
  }
}