import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();
        int[] dp = new int[input.length];

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (i - 2 * n >= 0 && dp[i] - dp[i - 2 * n] == n) {
                answer++;
            }
            if (i + 2 < m && input[i] == 'I' && input[i + 1] == 'O' && input[i + 2] == 'I') {
                dp[i + 2] = dp[i] + 1;
                i++;
            }
        }
        System.out.println(answer);
    }
}