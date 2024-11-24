package POTD_LEETCODE.String;

class CompressedString_3163_2 {
    public static void main(String[] args) {
        CompressedString_3163_2 obj = new CompressedString_3163_2();
        System.out.println(obj.compressedString("abcde"));

    }

    public String compressedString(String word) {
        int n = word.length();
        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < n) {
            int count = 0;
            char ch = word.charAt(i);

            while (i < n && ch == word.charAt(i) && count < 9) {
                count++;
                i++;
            }

            ans.append(count).append(ch);
        }
        return ans.toString();
    }

    public String compressedString2(String word) {
        char[] arr = word.toCharArray();

        int n = arr.length;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; ) {
            int count = 0;
            char ch = arr[i];

            while (i < n && ch == arr[i] && count < 9) {
                count++;
                i++;
            }

            ans.append(count).append(ch);
        }
        return ans.toString();
    }
}