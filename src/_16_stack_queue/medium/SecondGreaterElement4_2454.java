package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Arrays;

class SecondGreaterElement4_2454 {
    @Description("Brute force N^2 approach")
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        outer:
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                    if (count == 2) {
                        ans[i] = nums[j];
                        continue outer;
                    }
                }
            }
            ans[i] = -1;
        }
        return ans;
    }

    @Description("Brute force N^2 approach")
    public int[] secondGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                    if (count == 2) {
                        ans[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    @Description("Optimal")
    public int[] secondGreaterElement3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.size() <= 1) {
                ans[i] = -1;
            } else {
                int temp = stack.pop();
                ans[i] = stack.peek();
                stack.push(temp);
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}