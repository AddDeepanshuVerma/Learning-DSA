package _07_Sorting.Ques.Easy;

import java.util.Arrays;

class findContentChildren_455 {
    public static void main(String[] args) {
        int[] nums = {10,9,8,7};
        int[] nums2 = {5,6,7,8};
        System.out.println(findContentChildren(nums, nums2));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++; j++;
                count++;
            }else{
                j++;
            }
        }
        return count;
    }
}