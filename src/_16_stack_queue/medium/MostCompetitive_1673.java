package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;

class MostCompetitive_1673 {
    @Description("Slight mistake, doesn't work")
    public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int item : nums) {
            while (!stack.isEmpty() && stack.peek() > item && stack.size() > k) {
                stack.pop();
            }
            stack.push(item);
        }
        int[] arr = new int[k];
        int times = Math.min(k, stack.size());
        int index = 0;
        while (times-- > 0) {
            arr[index++] = stack.removeLast();
        }
        return arr;
    }

    @Description("Does work")
    public int[] mostCompetitive2(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            int item = nums[i];
            while (!stack.isEmpty() && stack.peek() > item && stack.size() + (nums.length - i) > k) {
                stack.pop();
            }
            stack.push(item);
        }
        int[] arr = new int[k];
        int times = Math.min(k, stack.size());
        int index = 0;
        while (times-- > 0) {
            arr[index++] = stack.removeLast();
        }
        return arr;
    }

    public int[] mostCompetitive3(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            int item = nums[i], remainingLength = nums.length - i; // including this item as-well
            while (!stack.isEmpty() && stack.peek() > item && stack.size() + remainingLength > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(item);
            }
        }

        int[] arr = new int[k];
        for (int i = 0; !stack.isEmpty(); i++) {
            arr[i] = stack.removeLast();
        }
        return arr;
    }
}