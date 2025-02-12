import java.util.*;

class Solution {
    public int solution(int N, int number) { 
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
            if (i != 0) {
                String repeated = String.valueOf(N).repeat(i);
                dp.get(i).add(Integer.parseInt(repeated));
            }
        }
        
        for (int i = 1; i < dp.size(); i++) {
            for (int j = 1; j <= i / 2; j++) {
                int leftIdx = j;
                int rightIdx = i - j;
                
                for (int left : dp.get(leftIdx)) {
                    for (int right : dp.get(rightIdx)) {
                        dp.get(i).add(left + right);
                        dp.get(i).add(left - right);
                        dp.get(i).add(right - left);
                        dp.get(i).add(left * right);
                        if (right != 0) {
                            dp.get(i).add(left / right);
                        }
                        if (left != 0) {
                            dp.get(i).add(right / left);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}