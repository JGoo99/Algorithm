import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.readLine(); // m

        String[] answer = new String[2 * n + 1];
        for (int i = 0; i < answer.length; i++) {
            if (i % 2 == 0) {
                answer[i] = "I";
            } else {
                answer[i] = "O";
            }
        }

        args = br.readLine().split("");
        int cnt = 0;
        for (int i = 0; i < args.length; i++) {
            if (args.length - i < answer.length) break;
            if (args[i].equals("O")) continue;

            cnt++;
            for (int j = 0; j < answer.length; j++) {
                if (i + j < args.length && answer[j].equals(args[i + j])) {
                    continue;
                }
                cnt--;
                break;
            }
        }
        System.out.println(cnt);
    }
}