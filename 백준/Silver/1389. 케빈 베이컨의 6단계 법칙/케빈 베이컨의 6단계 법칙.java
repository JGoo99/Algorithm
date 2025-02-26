import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = 1;
            map[b - 1][a - 1] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            boolean[] visit = new boolean[map[i].length];
            visit[i] = true;
            q.add(i);
            q.add(0);

            while (!q.isEmpty()) {
                int idx = q.poll();
                int len = q.poll();

                for (int j = 0; j < map[idx].length; j++) {
                    int x = map[idx][j];
                    if (x == 1 && !visit[j]) {
                        q.add(j);
                        q.add(len + 1);
                        map[i][j] = len + 1;
                        map[j][i] = len + 1;
                        visit[j] = true;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            int sum = 0;
            for (int j = 0; j < map[i].length; j++) {
                sum += map[i][j];
            }
            if (min < sum) {
                continue;
            }

            if (min == sum) {
                answer = Math.min(answer, i + 1);
            } else {
                answer = i + 1;
            }
            min = sum;
        }
        System.out.println(answer);
    }
}