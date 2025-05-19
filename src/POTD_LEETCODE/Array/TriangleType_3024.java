package POTD_LEETCODE.Array;

import java.util.Arrays;
import java.util.HashSet;

class TriangleType_3024 {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) return "none";

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        return switch (set.size()) {
            case 1 -> "equilateral";
            case 2 -> "isosceles";
            case 3 -> "scalene";
            default -> "";
        };
    }
}