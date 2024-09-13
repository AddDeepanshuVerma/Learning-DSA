package _11_BackTracking.Algo2;

public class LargestNumberIn_K_Swaps {
    public static void main(String[] args) {
        String str = "5689";
//        for (int k = 0; k < 5; k++) LargestNumber(str, k);
        LargestNumber(str, 5);
    }

    static class Max {
        String max;

        public Max(String max) {
            this.max = max;
        }
    }

    private static void LargestNumber(String str, int k) {
        Max max = new Max(str);
        int index = 0;
        dfs(str.toCharArray(), k, index, max);
        System.out.println("for k = " + k + " max.max = " + max.max);
    }

    private static void dfs(char[] arr, int k, int index, Max max) {
        if (index == arr.length - 1 || k == 0) {
            return;
        }

        // for example 5689, here for index = 0; why swap with 6 or 8 ? directly swap with 9
        char tempMax = findMax(arr, index + 1);
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index] && arr[i] == tempMax) {
                swap(arr, i, index);
                max.max = String.valueOf(arr).compareTo(max.max) > 0 ? String.valueOf(arr) : max.max;
                dfs(arr, k - 1, index + 1, max);
                swap(arr, i, index);
            }
        }
        dfs(arr, k, index + 1, max);
    }

    private static char findMax(char[] arr, int from) {
        char max = 0;
        for (int i = from; i < arr.length; i++) {
            max = (char) Math.max(arr[i], max);
        }
        return max;
    }

    private static void swap(char[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
