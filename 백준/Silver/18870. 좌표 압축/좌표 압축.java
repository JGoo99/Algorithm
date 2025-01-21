import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Num[] nums = new Num[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Num(Integer.parseInt(st.nextToken()));
        }
        
        Num[] copied = nums.clone();
        Arrays.sort(copied);

        for (int i = 1; i < copied.length; i++) {
            Num prev = copied[i - 1];
            Num cur = copied[i];
            
            cur.order = prev.order;
            if (prev.value < cur.value) {
                cur.order++;
            }
        }

        for (Num num : nums) {
            sb.append(num.order + " ");
        }
        System.out.println(sb);
    }

    public static class Num implements Comparable<Num> {
        int value;
        int order;

        public Num(int value) {
            this.value = value;
            this.order = 0;
        }

        @Override
        public int compareTo(Num o) {
            return this.value - o.value;
        }
    }
}