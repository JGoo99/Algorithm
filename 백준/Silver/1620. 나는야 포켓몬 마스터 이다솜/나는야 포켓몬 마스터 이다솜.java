import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> nameKey = new HashMap<>();
    HashMap<Integer, String> numKey = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      String name = br.readLine();
      nameKey.put(name, i);
      numKey.put(i, name);
    }

    while (m > 0) {
      String input = br.readLine();
      if (input.charAt(0) < 58) {
        sb.append(numKey.get(Integer.parseInt(input))).append("\n");
      } else {
        sb.append(nameKey.get(input)).append("\n");
      }
      m--;
    }
    System.out.println(sb);
  }
}