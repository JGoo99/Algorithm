import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    int[] stack = new int[100_001];

    int top = 1;
    for (int i = 0; i < k; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        top--;
        continue;
      }
      stack[top++] = input;
    }

    int sum = 0;
    for (int i = 0; i < top; i++) {
      sum += stack[i];
    }
    System.out.println(sum);
  }
}