package _10_Recursion.algo1;

import java.util.Arrays;

public class SortArray_usingArray {
    public static void main(String[] args) {
        int[] array = new SortArray_usingArray().sortArray(new int[]{7, 6, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(array));
    }

    public int[] sortArray(int[] num) {
        sort(num, num.length);
        return num;
    }

    private void sort(int[] num, int n) {
        // base case: an array of size 1 is already sorted
        if (n <= 1) return;
        // hypothesis: leave the last element and operate on the rest of the array
        int temp = num[n - 1];
        sort(num, n - 1);
       /* induction: after the remaining array is sorted, insert the last element in its correct
          position */
        sortedInsert(num, temp, n - 1);
    }

    private void sortedInsert(int[] num, int x, int n) {
        // base case:
        if (n == 0 || num[n - 1] <= x) {
            num[n] = x;
            return;
        }
        // hypothesis: shift the last element of the array one position ahead
        num[n] = num[n - 1];
        // induction: make the recursive call on the rest of the elements
        sortedInsert(num, x, n - 1);
    }

    static class Solution {
        public int[] sortArray(int[] num) {
            sort(num, num.length);
            return num;
        }

        private void sort(int[] num, int n) {
            if (n <= 1) return;
            int temp = num[n - 1];
            sort(num, n - 1);
            sortedInsert(num, temp, n - 1);
        }

        private void sortedInsert(int[] num, int x, int n) {
            if (n == 0 || num[n - 1] <= x) num[n] = x;
            else {
                num[n] = num[n - 1];
                sortedInsert(num, x, n - 1);
            }
        }
    }
}


