import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static Map<Integer, Integer> cnts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Queue<Integer> q = new PriorityQueue<>();
            Queue<Integer> rq = new PriorityQueue<>(Comparator.reverseOrder());
            cnts = new HashMap<>();

            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if ("I".equals(order)) {
                    q.add(value);
                    rq.add(value);
                    cnts.put(value, cnts.getOrDefault(value, 0) + 1);
                } else {
                    if  (cnts.isEmpty()) continue;
                    if (value == 1) {
                        delete(rq);
                    } else {
                        delete(q);
                    }
                }
            }

            if  (cnts.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int max = delete(rq);
                sb.append(max + " ");
                if (!cnts.isEmpty()) {
                    sb.append(delete(q) + "\n");
                } else {
                    sb.append(max + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int delete(Queue<Integer> q) {
        int cur = -1;
        while (true) {
            cur = q.poll();
            int cnt = cnts.getOrDefault(cur, 0);
            if (cnt == 0) {
                continue;
            }

            if (cnt == 1) {
                cnts.remove(cur);
            } else {
                cnts.put(cur, cnt - 1);
            }
            break;
        }
        return cur;
    }
}
