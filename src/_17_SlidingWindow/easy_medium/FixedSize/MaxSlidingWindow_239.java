package _17_SlidingWindow.easy_medium.FixedSize;

import jdk.jfr.Description;

import java.util.*;

@Description("Maximum of all subarrays of size k")
class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 obj = new MaxSlidingWindow_239();
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(obj.maxSlidingWindow3(nums, 5)));
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

    // NOW Working fine : Had to use double ended queue
    public int[] maxSlidingWindow3(int[] nums, int k) {
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