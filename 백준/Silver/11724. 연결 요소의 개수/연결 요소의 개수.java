import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] nodes = new int[n + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeX = Integer.parseInt(st.nextToken());
            int nodeY = Integer.parseInt(st.nextToken());

            int min = Math.min(nodes[nodeX], nodes[nodeY]);
            int max = Math.max(nodes[nodeX], nodes[nodeY]);
            for (int j = 0; j < nodes.length; j++) {
                if (nodes[j] == max) {
                    nodes[j] = min;
                }
            }
            nodes[nodeX] = min;
            nodes[nodeY] = min;
        }
        System.out.println(Arrays.stream(nodes).distinct().count() - 1);
    }
}
