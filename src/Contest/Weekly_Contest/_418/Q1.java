package Contest.Weekly_Contest._418;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Q1 q1 = new Q1();
        System.out.println(q1.maxGoodNumber(arr));
    }

    int max;

    public int maxGoodNumber(int[] nums) {
        max = Integer.MIN_VALUE;
        solve(0, nums);
        return max;
    }

    private void solve(int idx, int[] arr) {
        if (idx == arr.length - 1) {
            max = Math.max(max, getValue(arr));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            solve(idx + 1, arr);
            swap(arr, idx, i);
        }
    }

    private static void swap(int[] arr, int idx, int i) {
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }

    public int getValue(int[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(Integer.toBinaryString(num));
        }
        return Integer.parseInt(ans.toString(), 2);
    }
}
