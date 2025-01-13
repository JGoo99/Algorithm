import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                dp[i] = 1;
                continue;
            }

            int minValue = Integer.MAX_VALUE;
            for (int j = 1; j * j < i; j++) {
                int leftIdx = j * j;
                int rightIdx = i - leftIdx;
                if (leftIdx > rightIdx) {
                    break;
                }
                minValue = Math.min(minValue, dp[leftIdx] + dp[rightIdx]);
            }
            dp[i] = minValue;
        }
        System.out.println(dp[x]);
    }
}