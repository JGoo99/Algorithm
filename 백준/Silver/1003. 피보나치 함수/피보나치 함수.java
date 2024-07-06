import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());

    int[] arr = new int[41];
    arr[1] = 1;
    for (int i = 2; i < arr.length; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    for (int i = 0; i < t; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        sb.append("1 0\n");
        continue;
      }
      sb.append(arr[x - 1]).append(" ").append(arr[x]).append("\n");
    }
    System.out.println(sb);
  }
}