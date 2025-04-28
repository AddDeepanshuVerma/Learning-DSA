package POTD_LEETCODE.Array;

import java.util.Arrays;

class CountDays_3169 {
    // TC : M + N
    public int countDays(int days, int[][] meetings) {
        int[] prefix = new int[days + 2]; // starting from 1 to days
        for (int[] meeting : meetings) {
            prefix[meeting[0]]++;
            prefix[meeting[1] + 1]--;
        }

        int sum = 0, count = 0;
        for (int i = 1; i < prefix.length - 1; i++) {
            sum += prefix[i];
            if (sum == 0) count++;
        }
        return count;
    }

    // TC : NlogN
    public int countDays2(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int min = meetings[0][0], max = meetings[0][1];

        int meetingDays = 0;
        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            if (start > max) {
                meetingDays += max - min + 1;
                min = start;
            }
            max = Math.max(max, end);
        }
        meetingDays += max - min + 1;

        return days - meetingDays;
    }

    public static void main(String[] args) {
        var obj = new CountDays_3169();
        int day = 5;
        int[][] meetings = {{2, 4}, {1, 3}};
        System.out.println(obj.countDays2(day, meetings));
    }
}