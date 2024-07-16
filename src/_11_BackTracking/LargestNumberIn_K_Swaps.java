package _11_BackTracking;

public class LargestNumberIn_K_Swaps {
    public static void main(String[] args) {
        String str = "3499";
        int k = 2;
        LargestNumber(str, k);
    }

    private static void LargestNumber(String str, int k) {
        String[] ans = {str};
        solve(str.toCharArray(), k, 0, ans);
        System.out.println(ans[0]);
    }

    private static void solve(char[] arr, int k, int start, String[] max) {
//        base condition
        if ((start == arr.length - 1) || k == 0) {
            return;
        }
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > arr[start]) {
                swap(arr, start, i);
//              compare which is greater arr or max[0] and put maximum in max[0]
                max[0] = compare(max[0], arr);
                solve(arr, k - 1, start + 1, max);
                swap(arr, start, i);
            }
        }
        solve(arr, k, start + 1, max);
    }

    private static String compare(String s1, char[] arr) {
        String s2 = String.valueOf(arr);
        return s1.compareTo(s2) > 0 ? s1 : s2;
    }

    private static void swap(char[] arr, int start, int i) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }

}
