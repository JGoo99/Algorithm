import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] copied = nums.clone();
        Arrays.sort(copied);

        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int num : copied) {
            if (!map.containsKey(num)) {
                map.put(num, cnt++);
            }
        }

        for (int num : nums) {
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb);
    }
}