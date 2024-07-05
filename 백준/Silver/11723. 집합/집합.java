import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int m = Integer.parseInt(br.readLine());
    
    boolean[] result = new boolean[20];
    while (m > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      String str = st.nextToken();
      int x = 0;
      if (st.hasMoreTokens()) {
        x = Integer.parseInt(st.nextToken()) - 1;
      }

      switch (str) {
        case "add":
          result[x] = true;
          break;
        case "check":
          if (result[x]) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;
        case "remove":
          result[x] = false;
          break;
        case "toggle":
          result[x] = !result[x];
          break;
        case "all":
          Arrays.fill(result, true);
          break;
        case "empty":
          Arrays.fill(result, false);
          break;
      }
      m--;
    }
    System.out.println(sb);
  }
}