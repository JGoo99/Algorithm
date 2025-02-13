import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0] - 1;
            int loser = results[i][1] - 1;
            
            map[winner][loser] = 1;
            map[loser][winner] = -1;
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                for (int x = 0; x < map.length; x++) {
                    if (map[i][j] == 1 && map[j][x] == 1) {
                        map[i][x] = 1;
                        map[x][i] = -1;
                    }
                    
                    if (map[i][j] == -1 && map[j][x] == -1) {
                        map[i][x] = -1;
                        map[x][i] = 1;
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            boolean unknown = false;
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) continue;
                
                if (map[i][j] == 0) {
                    unknown = true;
                    break;
                }
            }
            if (!unknown) {
                cnt++;
            }
        }
        return cnt;
    }
}