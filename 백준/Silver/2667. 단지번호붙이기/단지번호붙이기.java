import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                initMap(i, j, Integer.parseInt(nums[j]));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    list.add(dfs(i, j));
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        for (int val : list) {
            sb.append(val + "\n");
        }
        System.out.print(sb);
    }

    private static void initMap(int i, int j, int value) {
        map[i][j] = value;
        if (value == 0) {
            visit[i][j] = true;
        }
    }

    private static int dfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        visit[i][j] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextY = y + dy[k];
                int nextX = x + dx[k];
                if (nextY > -1 && nextY < map.length && nextX > -1 && nextX < map[i].length && !visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    q.add(nextY);
                    q.add(nextX);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}