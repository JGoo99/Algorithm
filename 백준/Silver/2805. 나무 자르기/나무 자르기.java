import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        int maxLength = trees[trees.length - 1];
        int minLength = 0;
        int result = 0;
        while (minLength <= maxLength) {
            int midLength = (maxLength + minLength) / 2;

            long totalLength = 0;
            for (int i = trees.length - 1; i >= 0; i--) {
                if (trees[i] <= midLength) {
                    break;
                }
                totalLength += (trees[i] - midLength);
            }

            if (totalLength >= m) {
                result = midLength;
                minLength = midLength + 1;
            } else {
                maxLength = midLength - 1;
            }
        }
        System.out.println(result);
    }
}
