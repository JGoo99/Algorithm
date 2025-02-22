import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int cutCnt = 0;
    static int blueCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        doSomething(0, 0, n - 1);
        int totalBox = cutCnt * 4 - cutCnt + 1;
        System.out.println(totalBox - blueCnt);
        System.out.println(blueCnt);
    }

    private static void doSomething(int row, int l, int r) {
        if (l > r) return;

        boolean flag = false;
        int firstData = map[row][l];
        for (int i = 0; i <= r - l; i++) {
            if (flag) break;
            for (int j = l; j <= r; j++) {
                if (firstData != map[row + i][j]) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            cutCnt++;
            doSomething(row, l, (l + r) / 2);
            doSomething(row, (l + r) / 2 + 1, r);
            doSomething(row + (r - l) / 2 + 1, l, (l + r) / 2);
            doSomething(row + (r - l) / 2 + 1, (l + r) / 2 + 1, r);
            return;
        }
        if (firstData == 1) {
            blueCnt++;
        }
    }
}
