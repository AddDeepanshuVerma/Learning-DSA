package Strings.medium;

class minimumLength_1750 {
    public static void main(String[] args) {
        System.out.println(new minimumLength_1750().minimumLength("a"));
    }

    public int minimumLength2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            final char c = s.charAt(i);
            while (i < j && s.charAt(i) == c) ++i;
            while (j >= i && s.charAt(j) == c) --j;
        }
        return j - i + 1;
    }

    public int minimumLength3(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end && arr[start] == arr[end]) {
            start++;
            end--;
            while (start < end && arr[start] == arr[start - 1]) start++;
            while (start <= end && arr[end] == arr[end + 1]) end--;
        }
        return end - start + 1;
    }

    public int minimumLength(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return end - start + 1;
            } else {
                start++;
                end--;
                while (start < end && arr[start] == arr[start - 1]) start++;
                while (start <= end && arr[end] == arr[end + 1]) end--;
            }
        }
        return end - start + 1;
    }
}