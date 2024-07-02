import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int gcd = getGCD(a, b);
    sb.append(gcd).append("\n").append(a * b / gcd);
    System.out.println(sb);
  }
    
  public static int getGCD(int a, int b) {
    if (a % b == 0) {
      return b;
    }
    return getGCD(b, a % b);
  }
}