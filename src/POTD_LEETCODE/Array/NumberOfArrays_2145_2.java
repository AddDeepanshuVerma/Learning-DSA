package POTD_LEETCODE.Array;

class NumberOfArrays_2145_2 {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < differences.length; i++) {
            if (differences[i] < min) {
                minIdx = i;
                min = differences[i];
            }
        }

        int[] arr = new int[differences.length + 1];
        arr[++minIdx] = lower;
        for (int i = minIdx + 1; i < arr.length; i++) {
            arr[i] = differences[i - 1] + arr[i - 1];
        }
        for (int i = minIdx - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] - differences[i];
        }

        long lowest = Integer.MAX_VALUE, highest = Integer.MIN_VALUE;
        for (int val : arr) {
            lowest = Math.min(lowest, val);
            highest = Math.max(highest, val);
        }

        highest += lower - lowest;
        if (highest > upper) return 0;
        return (int) (upper - highest + 1);
    }

    public static void main(String[] args) {
        int[] diff = {23263, -3868, -24260, -11705};
        int count = numberOfArrays(diff, -26206, 23564);
        System.out.println("count = " + count);

        int[] diff2 = {4, -7, 2};
        int count2 = numberOfArrays(diff2, 3, 6);
        System.out.println("count2 = " + count2);
    }
}