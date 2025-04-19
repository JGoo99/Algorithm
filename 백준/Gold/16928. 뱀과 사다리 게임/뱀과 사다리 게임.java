import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        int[] cnt = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1); // position
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(cnt[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                if (cur + i > 100 || map[cur + i] > 100) {
                    continue;
                }

                int next = map[cur + i];
                if (cnt[next] == 0) {
                    q.add(next);
                    cnt[next] = cnt[cur] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(map));
        System.out.println(Arrays.toString(cnt));
    }
}