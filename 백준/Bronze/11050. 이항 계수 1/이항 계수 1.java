import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    System.out.println(getBC(N, K));
  }

  public static int getBC(int N, int K) {
    if (N == K || K == 0) {
      return 1;
    }
    return getBC(N - 1, K - 1) + getBC(N - 1, K);
  }
}