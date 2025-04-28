package _06_Searching;

import java.util.Scanner;

public class reachNumber_754 {
    public static void main(String[] args) {
        System.out.println(reachNumber(new Scanner(System.in).nextInt()));
    }

    public static int reachNumber(int target) {
        boolean elementNotFound = true;
        int count = 0;
        int sum = 0;
        target = Math.abs(target);
        for (int i = 1; elementNotFound; i++) {

            if (sum + i < target) {
                sum += i;
                count++;
            } else if (sum + i == target) {
                return ++count;
            } else {
                return count + (target - sum) * 2;
            }
        }
        return -1;
    }

    public int reachNumber2(int target) {
        target = Math.abs(target);

        long lo = 1, hi = target;
        long minPos = Integer.MAX_VALUE;
        long minSteps = Integer.MAX_VALUE;
        while (lo <= hi) {
            long mid = lo + ((hi - lo) >> 1);
            long dist = ((mid * (mid + 1)) >> 1);
            long finPos = dist;
            if (finPos >= target) {
                minSteps = Math.min(minSteps, mid);
                minPos = Math.min(minPos, finPos);
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        long diff = target - minPos;
        if ((diff & 1) == 0) {
            return ((minSteps & 1) == 0) ? (int) (minSteps + 2) : (int) (minSteps + 1);
        }

        return (int) minSteps;
    }

}
