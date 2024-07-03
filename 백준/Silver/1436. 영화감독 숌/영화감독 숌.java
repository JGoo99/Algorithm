import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    
    if (n == 1) {
      System.out.println("666");
      return;
    }
    
    int preNum = 0; // 0_666, 1_666, ...
    int cnt = 1;
    while (cnt < n) {
      preNum++;
      // 앞의 숫자에 6이 연속되면 ex) 6_66x, 66_6xx
      if (preNum % 10 == 6) {
        int tmp = preNum / 10;
        int t = 1;
        // 앞에서 6이 몇번 연속되는지 구하기
        while (tmp % 10 == 6) {
          tmp /= 10;
          t++; 
        }
        // 만약 66600 ~ 66699 다 합해도 카운트가 n 보다 작으면 한번에 더하기
        if (cnt + Math.pow(10, t) < n) {
          cnt += Math.pow(10, t);
        // 그 사이에 있는 경우  
        } else {
          int laterNum = n - cnt - 1;
          // 앞 숫자
          sb.append(preNum);
          // 앞 숫자에서 6 연속되는 거 포함해서 666 만들기
          int k = 3;
          while (k - t > 0) {
            sb.append("6");
            k--;
          }
          // afterNum 이 만약 1이면 001 과 같은 형식으로 만들어주어야 함.
          // 따라서 먼저 0을 자릿수만큼 채우기
          sb.append("0".repeat(Math.max(0, t)));
          
          // 나머지 유효숫자 알맞는 자리에 넣기
          // afterNum = 10 : 000 -> 010
          String str = String.valueOf(laterNum);
          sb.delete(sb.length() - str.length(), sb.length());
          sb.append(laterNum);
          System.out.println(sb);
          return;
        }
      } else {
        cnt++;
      }
    }
    // afterNum 이 없는 경우, 즉 preNum + 666 형태인 경우
    if (preNum != 0) {
      sb.append(preNum);
    }
    sb.append("666");
    System.out.println(sb);
  }
}