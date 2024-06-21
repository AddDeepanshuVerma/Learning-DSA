package Sorting_07.Ques.Easy;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

class average_1491 {
    public static void main(String[] args) {
        int[] arr = {4000, 3000, 1000, 2000};
        System.out.println(average4(arr));
    }

    public static double average5(int[] s) {
        return Arrays.stream(s).sorted()
                .skip(1)
                .limit(s.length - 2)
                .average().orElse(0);
    }
    public static double average4(int[] salary) {
        var stat = Arrays.stream(salary).summaryStatistics();
        return (double) (stat.getSum() - stat.getMax() - stat.getMin()) / (stat.getCount() - 2);
    }

    public static double average3(int[] salary) {
        IntSummaryStatistics stat = Arrays.stream(salary).summaryStatistics();
        return (double) (stat.getSum() - stat.getMax() - stat.getMin()) / (stat.getCount() - 2);
    }

    public static double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0.0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }

    private static double average2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0.0;
        for (int num : arr) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            sum += num;
        }
        sum = sum - max - min;
        return sum / (arr.length - 2);
    }
}