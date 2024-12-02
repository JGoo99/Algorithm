import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            nodes.get(nodeA).add(nodeB);
            nodes.get(nodeB).add(nodeA);
        }

        printDfs(nodes, v);
        printBfs(nodes, v);
    }

    private static void printDfs(List<List<Integer>> nodes, int v) {
        StringBuffer sb = new StringBuffer();
        boolean[] visit = new boolean[nodes.size() + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visit[cur]) {
                continue;
            }
            visit[cur] = true;
            sb.append(cur + " ");

            int cnt = 0;
            int[] nextNodes = new int[nodes.get(cur).size()];
            for (int i = 0; i < nodes.get(cur).size(); i++) {
                int next = nodes.get(cur).get(i);
                nextNodes[cnt++] = next;
            }
            int[] sortedNextNodes = Arrays.stream(nextNodes).sorted().toArray();
            for (int i = sortedNextNodes.length - 1; i > -1; i--) {
                stack.add(sortedNextNodes[i]);
            }
        }
        System.out.println(sb);
    }

    private static void printBfs(List<List<Integer>> nodes, int v) {
        StringBuffer sb = new StringBuffer();
        boolean[] visit = new boolean[nodes.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visit[cur]) {
                continue;
            }
            visit[cur] = true;
            sb.append(cur + " ");

            int cnt = 0;
            int[] nextNodes = new int[nodes.get(cur).size()];
            for (int i = 0; i < nodes.get(cur).size(); i++) {
                int next = nodes.get(cur).get(i);
                nextNodes[cnt++] = next;
            }
            int[] sortedNextNodes = Arrays.stream(nextNodes).sorted().toArray();
            for (int sortedNextNode : sortedNextNodes) {
                queue.add(sortedNextNode);
            }
        }
        System.out.println(sb);
    }
}
