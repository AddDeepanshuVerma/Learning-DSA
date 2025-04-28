package _11_BackTracking.Algo1;

public class LargestNumberIn_K_Swaps_1 {
    public static void main(String[] args) {
        String str = "978";
        int k = 2;
        LargestNumber(str, k);
    }

    static class max {
        String max;

        public max() {
            max = "";
        }
    }

    private static void LargestNumber(String str, int k) {
        max m = new max();
        m.max = str;
        solve(str.toCharArray(), k, 0, m);
        System.out.println(m.max);
    }

    private static void solve(char[] arr, int k, int start, max m) {
        if ((start == arr.length - 1) || k == 0) {
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > arr[start]) {
                swap(arr, start, i);
                m.max = compare(m.max, arr);
                solve(arr, k - 1, start + 1, m);
                swap(arr, start, i);
            }
        }
        solve(arr, k, start + 1, m); // if first index was already max, then check for further indexes until base condition ep : 978
    }

    private static String compare(String s1, char[] arr) {
        String s2 = new String(arr);
        return s1.compareTo(s2) > 0 ? s1 : s2;
    }

    private static void swap(char[] arr, int start, int i) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }

}
