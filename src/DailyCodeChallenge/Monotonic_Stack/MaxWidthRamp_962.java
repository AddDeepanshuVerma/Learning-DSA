package DailyCodeChallenge.Monotonic_Stack;

import java.security.KeyPair;
import java.util.ArrayDeque;
import java.util.Deque;

class MaxWidthRamp_962 {
    // TC : ~ O(N^2)
    public int maxWidthRamp2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    // Need to use monotonic stack
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        var stack = new ArrayDeque<Pair<Integer, Integer>>();

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                var temp = stack.removeLast();
                if (temp.value >= nums[idx]) {
                    ans = Math.max(ans, temp.index - idx);
                }
                stack.addFirst(temp);
            }

            if (stack.isEmpty() || stack.peek().value < nums[idx]) {
                stack.addFirst(new Pair<>(nums[idx], idx));
            }
        }

        return ans;
    }

    record Pair<K, V>(K value, V index) {

    }

    //TC : O(N)
    public int maxWidthRamp3(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) stack.push(i);
        }

        for (int i = nums.length - 1; i > ans; --i) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }

        return ans;
    }

}