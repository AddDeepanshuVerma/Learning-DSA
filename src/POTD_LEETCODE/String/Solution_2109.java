package POTD_LEETCODE.String;

class Solution_2109 {
    public static void main(String[] args) {
        int[] spaces = {8, 13, 15};
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();

        char[] arr = s.toCharArray();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j < spaces.length && i == spaces[j]) {
                ans.append(" ");
                j++;
            }
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}