package _16_stack_queue.easy;

import java.util.*;

class NextGreaterElement_496 {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2};
        int[] arr2 = {1, 3, 4, 2};
        NextGreaterElement_496 obj = new NextGreaterElement_496();
        System.out.println(Arrays.toString(obj.nextGreaterElement3(arr1, arr2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int ans = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    j++;
                    while (j < nums2.length) {
                        if (nums2[j] > nums1[i]) {
                            ans = nums2[j];
                            break;
                        }
                        j++;
                    }
                }
            }
            nums1[i] = ans;
        }
        return nums1;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // create Next greater element array of num2 array
        int[] nge = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nge.length; i++) {
            map.put(nums2[i], nge[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        // create Next greater element array of num2 array
        HashMap<Integer, Integer> map = new HashMap<>();
//        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.get(nums1[i]);
        return nums1;
    }

    public int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        // create Next greater element array of num2 array
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}