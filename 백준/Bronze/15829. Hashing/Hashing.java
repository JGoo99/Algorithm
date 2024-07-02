import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int len = Integer.parseInt(br.readLine());
    String str = br.readLine();

    long b = 1;
    long sum = 0;
    for (int i = 0; i < len; i++) {
      sum += (str.charAt(i) - 96) * b;
      b = (b * 31) % 1234567891;
    }
    System.out.println(sum % 1234567891);
  }
}