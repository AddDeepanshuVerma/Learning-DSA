package POTD_LEETCODE.sliding_window;

class NumberOfAlternatingGroups_3208 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 0, 1};
        System.out.println(numberOfAlternatingGroups2(arr, 6));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n + k - 1];
        int m = 0;
        for (int i = 0; i < colors.length; i++) {
            arr[m++] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            arr[m++] = colors[i];
        }

        int prev = -1;
        int i = 0, count = 0;
        for (int j = 0; j < arr.length; j++) {
            int curr = arr[j];
            if (curr == prev) {
                while (j > i) i++;
            }
            if (j - i + 1 == k) {
                count++;
                i++;
            }

            prev = curr;
        }
        return count;
    }

    public static int numberOfAlternatingGroups2(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n << 1];
        int m = 0;
        for (int color : colors) {
            arr[m + n] = color;
            arr[m++] = color;
        }

        int prev = -1;
        int i = 0, count = 0;
        for (int j = 0; j < n + k - 1; j++) {
            int curr = arr[j];

            if (curr == prev) while (j > i) i++;

            if (j - i + 1 == k) {
                count++;
                i++;
            }

            prev = curr;
        }
        return count;
    }
}