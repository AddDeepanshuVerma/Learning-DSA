package _10_Recursion;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class Print_Array_subSets_explain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> list1 = Print_Array_subSets_explain.Solution1.subsets(arr);
        System.out.println(list1);

        List<List<Integer>> list2 = Print_Array_subSets_explain.Solution2.subsets(arr);
        System.out.println(list2);

        List<List<Integer>> list3 = Print_Array_subSets_explain.Solution3_1.subsets(arr);
        System.out.println(list3);

        List<List<Integer>> list4 = Print_Array_subSets_explain.Solution3_2.subsets(arr);
        System.out.println(list4);

    }
/*
     * Subarray:
     * 1: Contiguous
     * 2: Order of appearance is maintained
     * 3: Every subarray is a subset.
     * 4: Every subarray is a subsequence
     * 5:For an array/string of size n, we can have ( (n*(n+1))/2 + 1 ) Subarray in
     * total i.e (n*(n+1))/2 non-empty subarray + 1 Empty subarray.
     *
     * Subsequence:
     * 1: May or may not be contiguous
     * 2: Order of appearance is maintained.
     * 3: Derived by deleting some or none of the elements of the sequence without
     * changing the order of
     * the remaining elements.
     * 4: Every subsequence is subset.
     * 5: For a sequence/array/string of size n, we can have 2^n Subsequence in
     * total i.e ((2^n)-1) non-empty sub-sequences + 1 Empty Subsequence.
     *
     * Subset:
     * 1 : May or may not be contiguous
     * 2: Order of appearance may or may not be maintained.
     * 3: Subsets and subsequence ae exactly same thing the only difference between
     * them is that subsequence should maintain order of appearance of elements
     * while subsets don't need to preserve order of appearance of elements
     * for ex : {1,2} and {2,1} represent the same subset however while
     * writing/listing the subsets of the sets you can either write {1,2} or {2,1}
     * it doesn't matter, but you can not list both at the same time
     * since they are exactly the same thing.
     *
     * Ex: arr[]={1, 2, 3}
     *
     * Subarrays :
     *
     * [1]
     * [1,2]
     * [1, 2, 3]
     * [2]
     * [2,3]
     * [3]
     *
     *
     * Subsequences:
     *
     * []
     * [1]
     * [1, 2]
     * [1, 3]
     * [1, 2, 3]
     * [2]
     * [2, 3]
     * [3]
     *
     * Subsets:
     *
     * []
     * [1]
     * [1, 2] or [2, 1]
     * [1, 3] or [3, 1]
     * [1, 2, 3] or [1, 3, 2] or [2, 3, 1] or [2, 1, 3] or [3, 1, 2] or [3, 2, 1]
     * [2]
     * [2, 3] or [3, 2]
     * [3]
     */

//Iterative Approach

//Method 1 :

/*
For arr[] = {1, 2, 3}:

Initially:  subsets :[[]].  (Add an empty subset)

Iteration 1: (arr[0]=1)
Pair 1 with all existing subsets i.e [1]
subsets: [[],[1]]

Iteration 2: (arr[1]=2)
Pair 2 with all existing subsets i.e  [2] and [1, 2]
subsets: [[], [1], [2], [1, 2]].

Iteration 3: (arr[2]=3)
Pair 3 with all existing subsets i.e [3], [1, 3] , [2, 3] and [1, 2, 3]
subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
*/

    static class Solution1 {
        public static List<List<Integer>> subsets(int[] arr) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>()); // Start with the empty subset

            for (int val : arr) {
                int size = res.size();
                for (int i = 0; i < size; i++) {
                    // Create a new subset from the existing res by adding the current number to
                    // it
                    List<Integer> subset = new ArrayList<>(res.get(i));
                    subset.add(val);
                    res.add(subset);
                }
            }

            return res;
        }
    }

// Method 2 : Bit Manipulation

    /*
     * For example : arr[] = {1, 2, 3, 4}; there are 16 (i.e 2^4) sub-sequences.
     * If we carefully notice it is nothing but binary numbers from 0 to 15 which
     * can be shown as below:
     *
     * 0000 {}
     *
     * 0001 {1}
     *
     * 0010 {2}
     *
     * 0011 {1, 2}
     *
     * 0100 {3}
     *
     * 0101 {1, 3}
     *
     * 0110 {2, 3}
     *
     * 0111 {1, 2, 3}
     *
     * 1000 {4}
     *
     * 1001 {1, 4}
     *
     * 1010 {1, 4}
     *
     * 1011 {1, 2, 4}
     *
     * 1100 {3, 4}
     *
     * 1101 {1, 3, 4}
     *
     * 1110 {2, 3, 4}
     *
     * 1111 {1, 2, 3, 4}
     *
     *
     * Starting from right,whenever we encounter set bit(1) in a number at ith
     * position the we print the element present at (i-1)th index in the array.
     */

// Intuitive Implementation

    static class Solution2 {
        public static List<List<Integer>> subsets(int[] arr) {
            List<List<Integer>> subsets = new ArrayList<>();

            // Total number of subsets is 2^n
            int totalSubsets = 1 << arr.length; // x << y = x * 2^n

            // Generate all subsets
            for (int num = 0; num < totalSubsets; num++) {
                List<Integer> subset = new ArrayList<>();
                String binaryWithoutLeadingZeroes = Integer.toBinaryString(num);// to get binary representation without leading zeroes
                /*
                 * Check each bit in binary representation of number(starting from right to
                 * left) to decide which elements to include in the current subset,
                 * if bit is set include the element corresponding to that position in the array
                 */
                int length = binaryWithoutLeadingZeroes.length();
                for (int i = length - 1; i >= 0; i--) {
                    if (binaryWithoutLeadingZeroes.charAt(i) == '1') {
                        subset.add(arr[length - i - 1]);
                    }
                }
                subsets.add(subset);
            }

            return subsets;
        }
    }

// Optimal Implementation

    static class Solution3 {
        public static List<List<Integer>> subsets(int[] arr) {
            List<List<Integer>> subsets = new ArrayList<>();
            int totalSubsets = 1 << arr.length; // x << y = x * 2^n

            for (int num = 0; num < totalSubsets; num++) {
                List<Integer> subset = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    if ((num & (1 << i)) != 0) {
                        subset.add(arr[i]);
                    }
                }
                subsets.add(subset);
            }

            return subsets;
        }
    }

// Using Backtracking

    /*
     * []
     * ├── [1] //Include 1
     * │ ├── [1, 2] //Include 2
     * │ │ ├── [1, 2, 3] //Include 3
     * │ │ │ ├── [1, 2, 3, 4] //Include 4
     * │ │ │ └── [1, 2, 3] //Exclude 4
     * │ │ └── [1, 2] //Exclude 3
     * │ │ ├── [1, 2, 4] //Include 4
     * │ │ └── [1, 2] //Exclude 4
     * │ └── [1] //Exclude 2
     * │ ├── [1, 3] //Include 3
     * │ │ ├── [1, 3, 4] //Include 4
     * │ │ └── [1, 3] //Exclude 4
     * │ └── [1] //Exclude 3
     * │ ├── [1, 4] //Include 4
     * | └── [1] //Exclude 4
     * └── [] //Exclude 1
     * ├── [2] //Include 2
     * │ ├── [2, 3] //Include 3
     * │ │ ├── [2, 3, 4] //Include 4
     * │ │ └── [2, 3] //Exclude 4
     * │ └── [2] //Exclude 3
     * │ ├── [2, 4] //Include 4
     * │ └── [2] //Exclude 4
     * └── [] //Exclude 2
     * ├── [3] //Include 3
     * │ ├── [3, 4] //Include 4
     * │ └── [3] //Exclude 4
     * └── [] //Exclude 3
     * ├── [4] //Include 4
     * └── [] //Exclude 4
     *
     */

    static class Solution3_1 {
        public static List<List<Integer>> subsets(int[] arr) {
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();

            subset(arr, 0, subset, subsets);
            return subsets;
        }

        private static void subset(int[] arr, int index, List<Integer> subset, List<List<Integer>> subsets) {
            /*
             * When index equals arr.length, it means we have processed all elements of the
             * array for the current subset. Thus, we add the current subset to subsets.
             */
            if (index == arr.length) {
                subsets.add(new ArrayList<>(subset)); // Adds a copy of subset (to prevent reference issues) to subsets.
            } else {
                // current element (arr[index]) is added to the subset
                subset.add(arr[index]);
                // explore the path where the current element is included
                subset(arr, index + 1, subset, subsets);
                /*
                 * Backtracking :After exploring the path where the current element is included,
                 * the element is removed from the subset. It reverts the state of subset to
                 * what it was before the current element was added, allowing the exploration
                 * of the path where the current element is excluded.
                 */
                subset.remove(subset.size() - 1);
                // explore the path where the current element is excluded
                subset(arr, index + 1, subset, subsets);
            }
        }
    }

// Aliter

    static class Solution3_2 {
        public static List<List<Integer>> subsets(int[] arr) {
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();

            subset(arr, 0, subset, subsets);
            return subsets;
        }

        private static void subset(int[] arr, int index, List<Integer> subset, List<List<Integer>> subsets) {
            /*
             * When index equals arr.length, it means we have processed all elements of the
             * array for the current subset. Thus, we add the current subset to subsets.
             */
            if (index == arr.length) {
                subsets.add(new ArrayList<>(subset)); // Adds a copy of subset (to prevent reference issues) to subsets.
            } else {
                // explore the path where the current element is excluded
                subset(arr, index + 1, subset, subsets);
                // current element (arr[index]) is added to the subset
                subset.add(arr[index]);
                // explore the path where the current element is included
                subset(arr, index + 1, subset, subsets);
                /*
                 * Backtracking :After exploring the path where the current element is included,
                 * the element is removed from the subset. It reverts the state of subset to
                 * what it was before the current element was added
                 */
                subset.remove(subset.size() - 1);
            }
        }
    }
}
