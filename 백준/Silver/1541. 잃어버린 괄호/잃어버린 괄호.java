import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split("-");

        int result = 0;
        for (int i = 0; i < split.length; i++) {
            StringTokenizer st2 = new StringTokenizer(split[i], "+");
            int x = 0;
            while (st2.hasMoreTokens()) {
                x += Integer.parseInt(st2.nextToken());
            }
            if (i == 0) {
                result += x;
                continue;
            }
            result -= x;
        }
        System.out.println(result);
    }
}