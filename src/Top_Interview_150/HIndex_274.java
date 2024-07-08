package Top_Interview_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

class HIndex_274 {
    public int hIndex(int[] citations) {
        int max = 0;
        for (int n : citations) max = Math.max(max, n);
        int[] arr = new int[max + 1];

        for (int num : citations) arr[num]++;

        int count = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            count += arr[j];
            if (count >= j) return j;
        }
        throw new IllegalArgumentException();
    }
}