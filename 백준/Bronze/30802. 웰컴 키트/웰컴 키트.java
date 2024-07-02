import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int[] size = new int[6];

    int N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < size.length; i++) {
      size[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    int cnt = 0;
    for (int i = 0; i < size.length; i++) {
      cnt += size[i] / T;
      if (size[i] % T > 0) {
        cnt++;
      }
    }
    sb.append(cnt).append("\n");
    sb.append(N / P).append(" ");
    sb.append(N % P);
    System.out.println(sb);
  }
}