package POTD_LEETCODE.Array_Difference;

class IsZeroArray_3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            diff[query[0]]--;
            diff[query[1] + 1]++;
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] + diff[i];
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            diff[query[0]]--;
            diff[query[1] + 1]++;
        }

        int add = 0;
        for (int i = 0; i < nums.length; i++) {
            add += diff[i];
            if (nums[i] + add > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var obj = new IsZeroArray_3355();
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};

        boolean ans = obj.isZeroArray(nums, queries);
        System.out.println("ans = " + ans);
    }
}