package Binary_Search_on_answers;

import java.util.Arrays;

class MinimizedMaximum_2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (isValid(quantities, mid, n)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    //checking if we divide arr in maximum mid-mid parts
    // how many parts there will be
    private boolean isValid(int[] arr, int mid, int parts) {
        int count = 0;
        for (int num : arr) {
            count += num / mid;
            if (num % mid != 0) {
                count++;
            }
        }
//        if we got count lower than parts: we can divide in even smaller parts
//        ,the smaller the parts, the maxElement bw those parts will be smaller
//        but we can make smaller till it gets distributed with given parts
        return count <= parts;
    }
}