package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

public class _1Palindrome_partition_recursion {
    //Given a string s, partition s such that every substring of the partition is a palindrome.
    //Return the minimum cuts needed for a palindrome partitioning of s.
    public static void main(String[] args) {
        String s = "nitia";
        int minimumCuts = palindromePartition(s);
        System.out.println("minimumCuts = " + minimumCuts);
    }

    private static int palindromePartition(String s) {
        int i = 0, j = s.length() - 1;
        return dfs(i, j, s);
    }

    private static int dfs(int i, int j, String s) {
        if (i >= j || isPalindrome(i, j, s)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = dfs(i, k, s);
            int right = dfs(k + 1, j, s);
            min = Math.min(min, left + right + 1);
        }
        return min;
    }

    private static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
