package Daily;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int [] time = new int[timePoints.size()];
        for(int i = 0; i<time.length; i++){
            String [] curr = timePoints.get(i).split(":");
            int minutes = Integer.valueOf(curr[0])*60;
            minutes += Integer.valueOf(curr[1]);
            time[i] = minutes;
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        for(int i =1; i<time.length; i++){
            min = Math.min(min, time[i]-time[i-1]);
            if(time[i-1]==0){
                min = Math.min(min, 24*60 - time[i]);
            }
        }
        return Math.min(min, 24*60-time[time.length-1]+time[0]);
    }
}
