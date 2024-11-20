package POTD_LEETCODE.SubSequence;

class LengthOfLIS_300 {
    public static void main(String[] args) {
        LengthOfLIS_300 obj = new LengthOfLIS_300();
        int[] arr = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(obj.lengthOfLIS(arr));
    }

    int maxLength;

    public int lengthOfLIS(int[] arr) {
        int index = 0, length = 0, prev = -1;
        maxLength = 0;

        dfs(index, length, arr, prev);

        return maxLength;

    }

    private void dfs(int index, int length, int[] arr, int prev) {
        maxLength = Math.max(maxLength, length);

        if (index == arr.length) return;

        if (length == 0) {
            for (int i = index; i < arr.length; i++) {
                dfs(i + 1, length + 1, arr, arr[i]);
            }
        } else {
            for (int i = index; i < arr.length; i++) {
                if (prev < arr[i]) {
                    dfs(i + 1, length + 1, arr, arr[i]);
                }
            }
        }
    }
}