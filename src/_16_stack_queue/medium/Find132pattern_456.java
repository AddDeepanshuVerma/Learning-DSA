package _16_stack_queue.medium;

import java.util.ArrayDeque;

class Find132pattern_456 {
    public boolean find132pattern(int[] nums) {
/*
    Intution :
        we need     i < j < k
        and         nums[i] < nums[k] < nums[j]
        here jth element(middle one) is the largest element

        We will assign this largest element as the minimum element
        And it will only be updated if we find an element which is greatet then previously occured elements
        while we are traversing in reverse order
        Hence when largest element is updated something else from minimum elements it means : we have find
        2 such elements which are (nums[k] / largest) < nums[j].
        now while still traversing in reversing we just need to find asSuch one more element which is lower then
        this largest element hence we retun true only in that case else false

        brief:  put a -infinite value to a number k and try to find any element which is lesser then this.
                we will only be able to find such case when this number k is updated to some sensible number.
                Now we will update this number only if we find a case where one number is greater then another
                number while traversing in reverse Order
*/
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int _2nd_largest = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < _2nd_largest) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                /*here nums[i] is the largest values here we are trying to make our _2nd_largest
                value as high as possible out of passed elements which are still lower then the num[i] we found.*/
                _2nd_largest = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;

    }
}