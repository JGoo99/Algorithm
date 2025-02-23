import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < map.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                char cur = line.charAt(j);
                map[i][j] = cur;
                if (cur == 'I') {
                    x = j;
                    y = i;
                }
            }
        }

        int cnt = 0;
        boolean[][] visit = new boolean[n][m];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visit[y][x] = true;
        while (!q.isEmpty()) {
            int curX = q.poll();
            int curY = q.poll();
            if (map[curY][curX] == 'P') {
                cnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX > -1 && nextX < m && nextY > -1 && nextY < n
                    && !visit[nextY][nextX] && map[nextY][nextX] != 'X') {
                    visit[nextY][nextX] = true;
                    q.add(nextX);
                    q.add(nextY);
                }
            }
        }
        if (cnt == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(cnt);
    }
}