import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruits = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int left = 0;
        int right = left + 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[left], left);
        while (left < n && right < n) {
            map.put(fruits[right], right);

            if (map.size() > 2) {
                if (map.get(fruits[left]) == left) {
                    map.remove(fruits[left]);
                }
                left++;
            } else {
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        System.out.println(max);
    }
}