import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    long[] arr = new long[n + 1];
    int idx = 1;
    while (n > 0) {
      int x = Integer.parseInt(st.nextToken());
      arr[idx] = arr[idx - 1] + x;
      idx++;
      n--;
    }

    while (m > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      sb.append(arr[j] - arr[i - 1]).append("\n");
      m--;
    }
    System.out.println(sb);
  }
}