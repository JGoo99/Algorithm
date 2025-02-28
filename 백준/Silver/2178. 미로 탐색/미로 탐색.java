import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        q.add(0); // y
        q.add(0); // x
        q.add(1); // distance
        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();
            int distance = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (nextX > -1 && nextX < m && nextY > -1 && nextY < n && map[nextY][nextX] != 0 && !visit[nextY][nextX]) {
                    if (nextY == n - 1 && nextX == m - 1) {
                        System.out.println(distance + 1);
                        return;
                    }
                    visit[nextY][nextX] = true;
                    q.add(nextY);
                    q.add(nextX);
                    q.add(distance + 1);
                }
            }
        }
    }
}