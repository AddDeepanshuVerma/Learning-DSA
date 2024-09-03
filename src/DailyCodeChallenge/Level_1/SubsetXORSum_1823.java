package DailyCodeChallenge.Level_1;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class SubsetXORSum_1823 {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    static int[] arr2 = {5,1,6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr2));
        System.out.println("=============================================");
        printSubsetOfArray(arr2);
        System.out.println("=============================================");
        findSubsets(arr2);
    }

    static void printSubsetOfArray(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = k; i < arr.length; i++) {
                for (int j = k; j <= i; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void findSubsets(int[] nums)
    {
        // Get the length of the input array
        int n = nums.length;

        // Loop through all possible subsets
        // using bit manipulation
        for (int i = 0; i < (1 << n); i++) {

            // Loop through all elements
            // of the input array
            for (int j = 0; j < n; j++) {

                // Check if the jth bit is set
                // in the current subset
                if ((i & (1 << j)) != 0) {

                    // If the jth bit is set,
                    // add the jth
                    // element to the subset
                    System.out.print(nums[j] + " ");
                }
            }

            System.out.println();
        }
    }

    public int subsetXORSum(int[] nums) {
        return 0;
    }
}
