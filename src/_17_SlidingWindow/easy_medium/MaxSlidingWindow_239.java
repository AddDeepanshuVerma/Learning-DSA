package _17_SlidingWindow.easy_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 obj = new MaxSlidingWindow_239();
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(obj.maxSlidingWindow2(nums, 5)));
    }

    //    [1  3  -1] -3  5  3  6  7       3
    // using priority queue : GETTING TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> ans = new ArrayList<>();

        int i = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {
            pq.add(nums[j]);
            if (j - i + 1 == k) {
                ans.add(pq.peek());
//                if (!pq.isEmpty() && pq.peek() == nums[i]) pq.poll();
                if (!pq.isEmpty()) pq.remove(nums[i]);
                i++;
            }
        }
//        System.out.println("ans = " + ans);

        int[] res = new int[ans.size()];
        for (int l = 0; l < res.length; l++) {
            res[l] = ans.get(l);
        }
        return res;
    }

    // STILL GETTING TLE : using same approach but removing the use of list to array conversion
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> ans = new ArrayList<>();
        int size = (nums.length - k) + 1;
        int r = 0;
        int[] res = new int[size];

        int i = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {
            pq.add(nums[j]);
            while (!pq.isEmpty() && pq.peek() < nums[j]) pq.poll();
            if (j - i + 1 == k) {
                res[r++] = pq.peek();
                if (!pq.isEmpty()) pq.remove(nums[i]);
                i++;
            }
        }
        return res;
    }

}