import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashSet<String> set = new HashSet<>();
    String[] result = new String[Math.max(n, m)];

    int idx = 0;
    while (n > 0) {
      set.add(br.readLine());
      n--;
    }

    while (m > 0) {
      String name = br.readLine();
      if (!set.add(name)) {
        result[idx++] = name;
      }
      m--;
    }

    Arrays.sort(result, 0, idx);
    for (String s : result) {
      if (s == null) break;

      sb.append(s + "\n");
    }
    sb.insert(0, idx + "\n");
    System.out.println(sb);
  }
}