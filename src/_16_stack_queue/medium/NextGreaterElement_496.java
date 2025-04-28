package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.HashMap;

class NextGreaterElement_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
         * First find all the next Greater element for each index in num2
         * then simply put them in map and find the respective values of num1 from that map
         * */
        int n = nums2.length;
        int[] NGE = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            NGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        // now NGE contains next greater element of whole nums2 array

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], NGE[i]);// all elements are unique
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    @Description("compact")
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        /*
         * First find all the next Greater element for each index in num2
         * then simply put them in map and find the respective values of num1 from that map
         * */
        int n = nums2.length;
        int[] NGE = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            NGE[i] = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], NGE[i]);// all elements are unique
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}