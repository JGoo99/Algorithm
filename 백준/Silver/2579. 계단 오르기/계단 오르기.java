import java.io.*;

public class Main {

  public static Integer[] dp;
  public static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 한 번에 한 계단씩 또는 두 계단
    // 연속된 세 개의 계단 x (시작점은 계단에 포함되지 않는다.)
    // 도착 계단 필수

    int n = Integer.parseInt(br.readLine());
    arr = new int[n + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp = new Integer[n + 1];
    dp[0] = arr[0];
    dp[1] = arr[1];

    if (n > 1) {
      dp[2] = arr[1] + arr[2];
    }

    System.out.println(recur(n));
  }

  public static int recur(int idx) {
    if(dp[idx] == null) {
      dp[idx] = Math.max(recur(idx - 2), recur(idx - 3) + arr[idx - 1]) + arr[idx];
    }
    return dp[idx];
  }
}