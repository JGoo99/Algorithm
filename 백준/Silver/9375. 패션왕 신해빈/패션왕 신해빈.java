import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    while (t > 0) {
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        String cur = st.nextToken();
        map.put(cur, map.getOrDefault(cur, 0) + 1);
      }
      int sum = 1;
      for (int v : map.values()) {
        sum *= (v + 1);
      }
      sb.append(sum - 1).append("\n");
      t--;
    }
    System.out.println(sb);
  }
}