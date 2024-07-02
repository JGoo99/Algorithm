import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = 3;
    int n = 0;
    while (cnt > 0) {
      String str = br.readLine();
      if (str.charAt(0) > 58) {
        cnt--;
        continue;
      }
      n = Integer.parseInt(str);
      break;
    }

    n += cnt;
    if (n % 3 == 0 && n % 5 == 0) {
      System.out.println("FizzBuzz");
    } else if (n % 3 == 0) {
      System.out.println("Fizz");
    } else if (n % 5 == 0) {
      System.out.println("Buzz");
    } else {
      System.out.println(n);
    }
  }
}