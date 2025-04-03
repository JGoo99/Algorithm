import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    private static int[] dj = {0, 0, -1, 1};
    private static int[] di = {-1, 1, 0, 0};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] colors = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                colors[i][j] = line.charAt(j);
            }
        }

        boolean[][] visit = new boolean[n][n];
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, colors, visit);
                    cnt1++;
                }
            }
        }

        visit = new boolean[n][n];
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, colors, visit);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    private static void dfs(int i, int j, char[][] colors, boolean[][] visit) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int curI = q.poll();
            int curJ = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextI = curI + di[k];
                int nextJ = curJ + dj[k];

                if (nextI > -1 && nextI < n && nextJ > -1 && nextJ < n && !visit[nextI][nextJ]) {
                    if (colors[curI][curJ] == colors[nextI][nextJ]) {
                        visit[nextI][nextJ] = true;
                        q.add(nextI);
                        q.add(nextJ);
                    }
                }
            }
            if (colors[curI][curJ] == 'R') {
                colors[curI][curJ] = 'G';
            }
        }
    }
}