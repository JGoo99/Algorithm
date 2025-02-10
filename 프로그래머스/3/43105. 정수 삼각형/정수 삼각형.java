class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = triangle.clone();
        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][dp[i].length - 1] += dp[i - 1][dp[i - 1].length - 1];
            
            for (int j = 1; j < triangle[i].length - 1; j++) {
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        
        int max = 0;
        for (int v : dp[dp.length - 1]) {
            max = Math.max(v, max);
        }
        return max;
    }
}