import java.util.*;

class Priority {
    public int priorityMinMeeting(int[][] intervals) {
        if (intervals == null || intervals.length < 1 || intervals.length > Math.pow(10, 4 )) {
            return -1;
        }
        for (int i = 0; i < intervals.length; i++){
            if (intervals[i][0] < 0)
                return -1;
            for(int j = 0; j < intervals[i].length; j++){
                if (intervals[j][1] > Math.pow(10, 6 ))
                    return -1;
            }                  
        }
        int count = 0, endIndex = 0;
        sortByStartTime(intervals);
        int endTimes [] = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(endTimes);

        for (int[] interval : intervals) {
            if (interval[0] < endTimes[endIndex]) {
                count++;
            } else {
                endIndex++;
            }
        }

        return count;
    }

    public void sortByStartTime(int[][] intervals) {
        int i = 0;
        int j = 0;
        int temp [] = new int [intervals.length];
        for (i = 0; i < intervals.length; i++) {
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{0, 1}, {1, 2}, {2, 3}};
        Priority priOb = new Priority();
        int num1 = priOb.priorityMinMeeting(intervals1);
        int num2 = priOb.priorityMinMeeting(intervals2);
        if (num1 != -1)
            System.out.println(num1); 
        else
            System.out.println("Invalid");
        if (num2 != -1)    
            System.out.println(num2); 
        else
            System.out.println("Invalid");
    }
}
