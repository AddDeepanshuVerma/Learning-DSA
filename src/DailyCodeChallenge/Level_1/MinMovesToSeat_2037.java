package DailyCodeChallenge.Level_1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

class MinMovesToSeat_2037 {
    public static void main(String[] args) {
        int[] seats = {12, 14, 19, 19, 12};
        int[] students = {19, 2, 17, 20, 7};
        System.out.println(minMovesToSeat2(seats, students));

    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int diff = 0;
        for (int i = 0; i < seats.length; i++) {
            diff += Math.abs(seats[i] - students[i]);
        }
        return diff;
    }

    public static int minMovesToSeat2(int[] seats, int[] students) {
        IntSummaryStatistics seat = Arrays.stream(seats).summaryStatistics();
        IntSummaryStatistics student = Arrays.stream(students).summaryStatistics();
        System.out.println(seat);
        System.out.println(student);
        return (int) Math.abs(student.getSum() - seat.getSum());

    }
}