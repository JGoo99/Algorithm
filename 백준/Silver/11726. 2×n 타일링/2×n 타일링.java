import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(getAns(n));
  }

  public static long getAns(int n) {
    if (n == 1) return 1;
    long[] arr = new long[n];
    arr[0] = 1;
    arr[1] = 2;

    for (int i = 2; i < n; i++) {
      arr[i] = (arr[i - 1] + arr[i - 2]) % 10_007;
    }
    return arr[n - 1];
  }
}
/*
f(n) = f(n - 1) + f(n - 2)
*/