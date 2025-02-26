import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visit = new boolean[k * 2 + 1];
        int maxTime = Math.abs(k - n);

        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int location = cur[0];
            int time = cur[1];

            if (location == k && time < maxTime) {
                maxTime = time;
            }

            if (time + 1 <= maxTime) {
                doSomething(location - 1, time + 1);
                doSomething(location + 1, time + 1);
                doSomething(location * 2, time + 1);
            }
        }
        System.out.println(maxTime);
    }

    private static void doSomething(int location, int time) {
        if (location < 0 || location > visit.length - 1 || visit[location]) {
            return;
        }
        visit[location] = true;
        q.add(new int[]{location, time});
    }
}