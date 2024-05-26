package Searching_06;

import java.util.Arrays;

public class MinEatingSpeed_875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed2(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed2(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed2(new int[]{30,11,23,4,20}, 6));

    }
    public static int minEatingSpeed2(int[] piles, int h) {
        long start = 1,
                end = 0,
                mid = 0;
        for (int i = 0; i < piles.length; i++) {
            end  =  Math.max(end, piles[i]);
        }
        long ans = 0;
        while (start < end) {
            mid = (start + end) >> 1;
            if (!finishedWithinGivenTime(piles,mid,h)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }
    static boolean finishedWithinGivenTime(int[] arr, long speedPerHour, long h) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count + arr[i] / speedPerHour;
            if (arr[i] % speedPerHour != 0)  count++;
            if(count > h) return false;
        }
        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {
          long start = 1,
                end = getTheMax(piles),
                mid = 0;
        long ans = 0;
        while (start < end) {
            mid = (start + end) >> 1;
            long timeTaken = hours_ToEatAllBanana(piles, mid);
            if (h < timeTaken) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)start;
    }

    private static long getTheMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max  =  Math.max(max, arr[i]);
        }
        return max;
    }

    static long hours_ToEatAllBanana(int[] arr, long speedPerHour) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count + arr[i] / speedPerHour;
            if (arr[i] % speedPerHour != 0) {
                count++;
            }
        }
        return count;
    }
}
