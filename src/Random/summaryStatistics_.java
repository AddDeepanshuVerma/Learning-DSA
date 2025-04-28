package Random;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class summaryStatistics_ {
    public static void main(String[] args) {
        int[] arr ={4000,3000,1000,2000};
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        System.out.println(stat.getAverage());
        System.out.println(stat.getMax());
        System.out.println(stat.getMin());
        System.out.println(stat.getCount());
        System.out.println(stat.getSum());
        System.out.println(stat);
        System.out.println(stat.toString());
        System.out.println("====================");
        stat.accept(5000);
        System.out.println(stat.toString());
    }
}
