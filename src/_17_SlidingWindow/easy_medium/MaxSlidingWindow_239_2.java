package _17_SlidingWindow.easy_medium;

import java.util.*;

class MaxSlidingWindow_239_2 {
    public static void main(String[] args) {
        MaxSlidingWindow_239_2 obj = new MaxSlidingWindow_239_2();
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(obj.maxSlidingWindow2(nums, 5)));
    }

    //    [1  3  -1] -3  5  3  6  7       3
    // using same approach but removing the use of list to array conversion
    public int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int r = 0;
        int[] res = new int[(nums.length - k) + 1];

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // removing all those elements from back which are lower than the one we are going to add now
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.pollLast();
            }
            queue.offerLast(nums[j]);
            if (j - i + 1 == k) {
                if (!queue.isEmpty()) res[r++] = queue.peekFirst();
                if (queue.peekFirst() == nums[i]) queue.pollFirst();// if this ith element was usable, it will be at first
                i++;
            }
        }
        return res;
    }

}