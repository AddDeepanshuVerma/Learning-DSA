package _17_SlidingWindow.easy_medium.FixedSize;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Description("First Negative Number in every Window of Size K | fixed size sliding window")
class PrintFirstNegativeInteger {
    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        PrintFirstNegativeInteger obj = new PrintFirstNegativeInteger();
        long[] longs = obj.printFirstNegativeInteger(arr, 5, 2);
        System.out.println(Arrays.toString(longs));
    }

    //
    public long[] printFirstNegativeInteger(long[] A, int N, int K) {
        // a[] = {-8, 2, 3, -6, 10}
        List<Long> list = new ArrayList<>();
        List<Long> ans = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < N; j++) {
            if (A[j] < 0) list.add(A[j]);
            if (j - i + 1 == K) {
                ans.add(list.isEmpty() ? 0 : list.getFirst());
                list.remove(A[i]);
                i++;
            }
        }

        long[] result = new long[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }

    public long[] printFirstNegativeInteger2(long[] A, int N, int K) {
        // a[] = {-8, 2, 3, -6, 10}
        ArrayDeque<Long> queue = new ArrayDeque<>();
        List<Long> ans = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < N; j++) {
            if (A[j] < 0) queue.offerLast(A[j]);
            if (j - i + 1 == K) {
                ans.add(queue.isEmpty() ? 0L : queue.peek());
                if (!queue.isEmpty() && queue.peek() == A[i]) queue.pollFirst();
                i++;
            }
        }

        long[] result = new long[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }

    public long[] printFirstNegativeInteger_gfg(long[] A, int N, int K) {
        List<Long> list = new ArrayList<>();
        List<Long> ans = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < N; j++) {
            if (A[j] < 0) list.add(A[j]);
            if (j - i + 1 == K) {
                if (list.size() == 0) ans.add(0L);
                else ans.add(list.get(0));
                list.remove(A[i]);
                i++;
            }
        }

        long[] result = new long[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }

        return result;
    }

}