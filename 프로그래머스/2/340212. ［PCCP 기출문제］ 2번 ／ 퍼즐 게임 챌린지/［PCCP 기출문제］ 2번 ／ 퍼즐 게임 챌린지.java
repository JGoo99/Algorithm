class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = 1;
        int r = 100_000;
        int answer = 0;
        
        while (l <= r) {
            int level = (l + r) / 2;
            long totalTime = getTotalTime(level, diffs, times);
            
            if (totalTime > limit) {
                l = level + 1;
            } else {
                answer = level;
                r = level - 1;
            }
        }
        return answer;
    }
    
    private long getTotalTime(int level, int[] diffs, int[] times) {
        long time = 0;
        if (diffs[0] <= level) {
            time = times[0];
        } else {
            time = times[0] * (diffs[0] - level + 1);
        }
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
                continue;
            }
            
            time += ((times[i] + times[i - 1]) * (diffs[i] - level) + times[i]);
        }
        return time;
    }
}