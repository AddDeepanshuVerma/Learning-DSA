package Top_Interview_150;

class StrStr_28 {
    //    haystack = "sadbutsad", needle = "sad"
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(strStr(s1, s2));
    }

    public static int strStr(String haystack, String needle) {
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        int n = arr2.length - 1;
        for (int i = 0, j = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[j]) {
                if (n == j)
                    return i - arr2.length + 1;
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}