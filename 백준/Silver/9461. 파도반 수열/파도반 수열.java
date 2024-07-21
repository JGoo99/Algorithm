import java.io.*;

public class Main {

  public static long[] ans = new long[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    int[] arr = new int[t];
    int max = 0;
    int idx = 0;
    while (t > 0) {
      int x = Integer.parseInt(br.readLine());
      max = Math.max(x, max);
      arr[idx++] = x;
      t--;
    }

    makeAns(max);
    for (int a : arr) {
      sb.append(getCnt(a)).append("\n");
    }
    System.out.println(sb);
  }

  public static void makeAns(int max) {
    ans[1] = ans[2] = ans[3] = 1;
    ans[4] = ans[5] = 2;
    for (int i = 6; i <= max; i++) {
      ans[i] = ans[i - 1] + ans[i - 5];
    }
  }

  public static long getCnt(int a) {
    return ans[a];
  }
}