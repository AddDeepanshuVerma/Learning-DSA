package POTD_LEETCODE.Array;

class NumberOfArrays_2145 {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < differences.length; i++) {
            if (differences[i] < min) {
                minIdx = i;
                min = differences[i];
            }
        }

        // create dummy array
        int[] arr = new int[differences.length + 1];
        // now put the lower value in that minIdx+1 index
        minIdx++;
        arr[minIdx] = lower;
        // now build this array
        // first build right side
        for (int i = minIdx + 1; i < arr.length; i++) {
            arr[i] = differences[i - 1] + arr[i - 1];
        }
        // now build left side
        for (int i = minIdx - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] - differences[i];
        }

        // now get what is the minimum & maximum we got
        long lowest = Integer.MAX_VALUE;
        long highest = Integer.MIN_VALUE;
        for (int val : arr) {
            lowest = Math.min(lowest, val);
            highest = Math.max(highest, val);
        }
        // now lets match the lowest value with lower
        long diff = lower - lowest;
        // now add this difference to our highest
        highest += diff;
        // now if our highest is greater than upper then there is no such range available
        if (highest > upper) return 0;

        return (int) (upper - highest + 1);
    }

    public static void main(String[] args) {
        int[] diff = {23263, -3868, -24260, -11705};
        int count = numberOfArrays(diff, -26206, 23564);
//        int[] diff = {4, -7, 2};
//        int count = numberOfArrays(diff, 3, 6);
        System.out.println("count = " + count);
    }
}