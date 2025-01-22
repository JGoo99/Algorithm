class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int endTime = getTime(video_len);
        int curTime = getTime(pos);
        int opStartTime = getTime(op_start);
        int opEndTime = getTime(op_end);
        
        for (int i = 0; i < commands.length; i++) {
            // 오프닝 시간 내인 경우 op_end 로 이동
            if (opStartTime <= curTime && curTime <= opEndTime) {
                curTime = opEndTime;
            }
            
            // 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동
            if (commands[i].equals("next")) {
                curTime = Math.min(curTime + 10, endTime);
                continue;
            }
            // 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동
            curTime = Math.max(curTime - 10, 0);
        }
        
        // 오프닝 시간 내인 경우 op_end 로 이동
        if (opStartTime <= curTime && curTime <= opEndTime) {
            curTime = opEndTime;
        }
        
        // 분, 초가 한 자리일 경우 0을 붙여 두 자리로 나타냅니다.
        return getTimeStr(curTime);
    }
    
    public static int getTime(String str) {
        int minSecond = Integer.parseInt(str.substring(0, 2)) * 60;
        int second = Integer.parseInt(str.substring(3, 5));
        return minSecond + second;
    }
    
    public static String getTimeStr(int time) {
        int min = time / 60;
        int second = time % 60;
        return parseToTimeStr(min) + ":" + parseToTimeStr(second);
    }
    
    public static String parseToTimeStr(int time) {
        String value = String.valueOf(time);
        if (value.length() < 2) {
            return "0" + value;
        }
        return value;
    }
}