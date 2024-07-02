import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    char[] chars = br.readLine().toCharArray();

    int M = 31;
    int sum = 0;
    for (int i = 0; i < chars.length; i++) {
      int a = chars[i] - 96;
      double b = Math.pow(M, i);
      sum += (a * b) % 1234567891;
    }
    System.out.println(sum);
  }
}