import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curTime = 0;
        int totalWeight = 0;
        Queue<int[]> q = new LinkedList<>();
        
        int i = 0;
        while (i < truck_weights.length || !q.isEmpty()) {
            curTime++;
            
            if (!q.isEmpty() && q.peek()[1] == curTime) {
                totalWeight -= q.poll()[0];
            }
            
            if (i < truck_weights.length && totalWeight + truck_weights[i] <= weight) {
                totalWeight += truck_weights[i];
                q.add(new int[]{truck_weights[i], curTime + bridge_length});
                i++;
                continue;
            }
        }
        
        return curTime;
    }
}