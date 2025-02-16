import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for (int i = 0; i < numbers.length; i++) {
            pq.add(String.valueOf(numbers[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}