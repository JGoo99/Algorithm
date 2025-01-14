import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] count = new int[257];
        int minHeight = 257;
        int maxHeight = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                count[x]++;

                minHeight = Math.min(minHeight, x);
                maxHeight = Math.max(maxHeight, x);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int i = minHeight; i <= maxHeight ; i++) {
            int time = 0;
            int tempInventory = b;
            for (int j = 0; j < i; j++) {
                int x = count[j] * (i - j);
                tempInventory -= x;
                time += x;
            }
            for (int j = i + 1; j <= maxHeight; j++) {
                int x = count[j] * (j - i);
                tempInventory += x;
                time += (x * 2);
            }

            if (tempInventory < 0) {
                continue;
            }

            if (minTime >= time) {
                minTime = time;
                height = i;
            }
        }

        System.out.println(minTime + " " + height);
    }
}
