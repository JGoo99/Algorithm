import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            int[] cur = new int[]{i, prices[i]};
            
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            
            while (!stack.isEmpty()) {
                int[] prev = stack.peek();
                if (prev[1] > cur[1]) {
                    stack.pop();
                    answer[prev[0]] = cur[0] - prev[0];
                } else {
                    break;
                }
            }
            stack.add(cur);
        }
        
        if (!stack.isEmpty()) {
            int[] cur = stack.pop();
            
            while (!stack.isEmpty()) {
                int[] prev = stack.pop();
                answer[prev[0]] = cur[0] - prev[0];
            }
        }
        return answer;
    }
}

// [1, 2, 3, 1, 3]
// [4, 2, 1, 1, 0]
// answer[2] = 3 - 2 = 1
// answer[3] = 1
// answer[1] = 3
// answer[0] = 4