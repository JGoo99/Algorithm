import java.io.*;
import java.util.*;

public class Main {
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if ("I".equals(order)) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else {
                    if  (map.isEmpty()) continue;
                    int key;
                    if (value == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }

            if  (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb);
    }
}
