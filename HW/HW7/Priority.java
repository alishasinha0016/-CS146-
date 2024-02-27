import java.util.*;

class Priority {
    public int priorityMinMeeting(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
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

    private void sortByStartTime(int[][] intervals) {
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
        System.out.println(num1); 
        System.out.println(num2); 
    }
}

