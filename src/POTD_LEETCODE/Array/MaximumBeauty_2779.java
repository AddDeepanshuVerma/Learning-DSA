package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Arrays;

class MaximumBeauty_2779 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 2};
        System.out.println(maximumBeauty3(nums, 2));

    }

    record Pair<K, V>(K getKey, V getValue) {
    }

    public static int maximumBeauty(int[] nums, int k) {
        Pair<Integer, Integer>[] intrvl = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            intrvl[i] = new Pair<>(nums[i] - k, nums[i] + k);
        }
        Arrays.sort(intrvl, (a, b) -> a.getKey() - b.getKey());

        // now the question is to find the maximum number of intrvl overlapping
        int res = 1;
        ArrayDeque<Pair<Integer, Integer>> deq = new ArrayDeque<>();
        for (int i = 0; i < intrvl.length; i++) {

            while (!deq.isEmpty() && deq.peekFirst().getValue() < intrvl[i].getKey()) {
                deq.removeFirst();
            }

            deq.addLast(new Pair<>(intrvl[i].getKey(), intrvl[i].getValue()));
            res = Math.max(res, deq.size());
        }
        return res;
    }

    @Description("we just need second element of deq hence no need to make it pair type")
    public static int maximumBeauty2(int[] nums, int k) {
        Pair<Integer, Integer>[] intrvl = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            intrvl[i] = new Pair<>(nums[i] - k, nums[i] + k);
        }
        Arrays.sort(intrvl, (a, b) -> a.getKey() - b.getKey());

        int res = 1;
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < intrvl.length; i++) {

            while (!deq.isEmpty() && deq.peekFirst() < intrvl[i].getKey()) {
                deq.removeFirst();
            }

            deq.addLast(intrvl[i].getValue());
            res = Math.max(res, deq.size());
        }
        return res;
    }

    @Description("Using Sliding window approach")
    public static int maximumBeauty3(int[] nums, int k) {
        Arrays.sort(nums);

        k <<= 1;
        int i = 0;
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            while (i <= j && nums[i] + k < nums[j]) {
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}