package POTD_LEETCODE.level_3;

import java.util.Arrays;
import java.util.List;

class FindMinDifference_539 {
    public static void main(String[] args) {
        FindMinDifference_539 obj = new FindMinDifference_539();
        System.out.println(obj.findMinDifference2(List.of("01:50", "23:59", "02:00", "00:00")));
    }

    // using counting sort
    private int findMinDifference2(List<String> timePoints) {
        int len = timePoints.size();
        boolean[] count = new boolean[24 * 60];
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            int timeInMin = timeInMin(timePoints.get(i));
            smallest = Math.min(smallest, timeInMin);// will be used later
            // if similar timeInMin was already present then min diff is found ~ 0
            if (count[timeInMin]) return 0;
            count[timeInMin] = true;
        }
        // now we need to check the min diff
        int minDiff = Integer.MAX_VALUE;
        int previous = smallest;
        for (int i = smallest + 1; i < count.length; i++) {
            if (count[i]) {
                minDiff = Math.min(minDiff, i - previous);
                previous = i;
            }
        }
        // crossCheck last case
        return Math.min(minDiff, 24 * 60 - previous + smallest);
    }

    private int timeInMin(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    //    Creating an array of given size
    public int findMinDifference(List<String> timePoints) {
//         convert all the given time to minutes in a 24-hour range array
        int[] timeInMinutes = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");
            timeInMinutes[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

//        System.out.println("timeInMinutes = " + Arrays.toString(timeInMinutes));

//         to calculate min diff , sort the min array and find pair differences
        Arrays.sort(timeInMinutes);
        int minimum_diff = Integer.MAX_VALUE;
        for (int i = 1; i < timeInMinutes.length; i++) {
            minimum_diff = Math.min(minimum_diff, timeInMinutes[i] - timeInMinutes[i - 1]);
        }

//         in this loop case if last element is close to first element as being in circulation, we'll check them too
        minimum_diff = Math.min(minimum_diff, ((24 * 60) - timeInMinutes[timeInMinutes.length - 1] + timeInMinutes[0]));

        return minimum_diff;
    }

}