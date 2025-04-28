package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.*;

class AsteroidCollision_735 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, -5};
        AsteroidCollision_735 obj = new AsteroidCollision_735();
        System.out.println(Arrays.toString(obj.asteroidCollision1(arr)));
    }

    public int[] asteroidCollision(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() < 0 || arr[i] > 0) {
                stack.push(arr[i]);
            } else {
                int temp = arr[i] + stack.peek();
                // if temp is positive means : arr[i] was -ive and peek element overwhelmed it hence ignore
                // if temp is 0 means : arr[i] & temp destroyed each other
                if (temp == 0) stack.pop();
                // if temp is negative means : arr[i] overwhelmed peek element
                else if (temp < 0) {
                    stack.pop();
                    i--;
                }
            }
        }

        int[] ans = new int[stack.size()];
        int j = 0;
        while (!stack.isEmpty()) {
            ans[j++] = stack.removeLast();
        }
        return ans;
    }

    public int[] asteroidCollision1(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() < 0 || arr[i] > 0) {
                stack.push(arr[i]);
            } else if (arr[i] + stack.peek() <= 0) {
                if (arr[i] + stack.peek() < 0) i--;
                stack.pop();
            }
        }

        int[] ans = new int[stack.size()];
        int j = 0;
        while (!stack.isEmpty())
            ans[j++] = stack.removeLast();
        return ans;
    }

    @Description("Wrong!!!")
    public int[] asteroidCollision_2(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int n : asteroids) {
            if (stack.isEmpty() || n >= 0) {
                stack.push(n);
            } else {
                int temp = n + stack.peek();
                if (temp == 0) {
                    stack.pop();
                    n = 0;
                } else if (temp < 0) {
                    stack.pop();
                    stack.push(n);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            if (stack.peek() != 0) list.add(stack.pop());
        }
        Collections.reverse(list);
        System.out.println("list = " + list);
        return new int[2];
    }
}