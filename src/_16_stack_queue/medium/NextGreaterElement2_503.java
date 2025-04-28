package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Arrays;

class NextGreaterElement2_503 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements2(nums)));
    }

    @Description("BruteForce approach")
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = findNext(i, nums, n);
        }

        return ans;
    }

    private static int findNext(int index, int[] nums, int size) {
        int next = index;
        for (int i = 0; i < size - 1; i++) {
            next = (next + 1) % size;
            if (nums[next] > nums[index]) {
                return nums[next];
            }
        }
        return -1;
    }

    // =================== optimal approach ================

    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n << 1];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
            temp[i + n] = nums[i];
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= temp[i]) {
                stack.pop();
            }
            temp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }

        return Arrays.copyOfRange(temp, 0, n);
    }
}