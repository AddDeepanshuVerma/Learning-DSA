package DailyCodeChallenge;

import java.util.*;

public class Subsets_78 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Integer.toBinaryString(n));
        printBinaryRepresentations(n);
    }
    static void printBinaryRepresentations(int n){
        int j =0;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            System.out.print("ith value : " + i +", ");
            String bitmask = Integer.toBinaryString(i).substring(1);
            System.out.print("real value : " + Integer.toBinaryString(i)+", ");
            System.out.println(bitmask+ " for " + j);
            j++;
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
