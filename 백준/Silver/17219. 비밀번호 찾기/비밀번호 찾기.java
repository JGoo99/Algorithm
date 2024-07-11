import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, String> map = new HashMap<>();
    while (n > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      map.put(st.nextToken(), st.nextToken());
      n--;
    }
    while (m > 0) {
      bw.write(map.get(br.readLine()));
      bw.newLine();
      m--;
    }
    bw.flush();
    bw.close();
  }
}