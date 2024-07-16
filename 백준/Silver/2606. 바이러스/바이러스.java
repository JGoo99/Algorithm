import java.io.*;
import java.util.*;

public class Main {

  public static class Node {
    int x;
    boolean flag;
    List<Integer> friends;

    public Node(int x) {
      this.x = x;
      this.flag = false;
      this.friends = new ArrayList<>();
    }
  }

  public static Node[] nodes;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    nodes = new Node[n + 1];
    for (int i = 1; i < n + 1; i++) {
      nodes[i] = new Node(i);
    }

    while (m > 0) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      nodes[i].friends.add(j);
      nodes[j].friends.add(i);
      m--;
    }

    dfs(1);
    int cnt = 0;
    for (int i = 2; i < n + 1; i++) {
      if (nodes[i].flag) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }

  public static void dfs(int x) {
    nodes[x].flag = true;
    List<Integer> list = nodes[x].friends;
    for (int i = 0; i < list.size(); i++) {
      Node cur = nodes[list.get(i)];
      if (!cur.flag) {
        dfs(cur.x);
      }
    }
  }
}