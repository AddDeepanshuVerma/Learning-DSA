package LeetCode_33Question_challenge_2025.week1;

class Q2_MergeAlternately_1768 {
    public String mergeAlternately(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < arr1.length && j < arr2.length) {
            sb.append(arr1[i++]).append(arr2[j++]);
        }
        while (i < arr1.length) {
            sb.append(arr1[i++]);
        }
        while (j < arr2.length) {
            sb.append(arr2[j++]);
        }
        return sb.toString();
    }
}