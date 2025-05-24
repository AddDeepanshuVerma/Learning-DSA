package Contest.Weekly_Contest._450;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2 {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            temp.add(nums[i]);
        }

        temp.sort((a, b) -> {
            int first = digitSum(a), second = digitSum(b);
            if (first == second) {
                return a - b;
            } else {
                return first - second;
            }
        });

        int swaps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp.get(i)) {
                int first = i;
                int second = map.get(temp.get(i));
                int firstValue = nums[first];
                int secondValue = nums[second];
                swap(nums, first, second);
                // now we need to swap there index values in HashMap as well
                map.put(firstValue, second);
                map.put(secondValue, first);
                swaps++;
            }
        }
        return swaps;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        int[] nums = {625468152, 191921893, 821181574};
        int count = obj.minSwaps(nums);
        System.out.println("count = " + count);
    }
}
