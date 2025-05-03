package POTD_LEETCODE.Greedy;

class MinDominoRotations_1007_2 {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        // try to check if we can make our top 1, 2 , 3 till 6

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            ans = Math.min(ans, count(tops, bottoms, i));
            ans = Math.min(ans, count(bottoms, tops, i));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int count(int[] arr, int[] help, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                if (help[i] == val) {
                    count++;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};

        int ans = minDominoRotations(tops, bottoms);
        System.out.println("ans = " + ans);
    }
}