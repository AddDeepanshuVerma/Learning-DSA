package POTD_LEETCODE.Graph;

class FindChampion_2924 {
    public int findChampion(int n, int[][] edges) {
        /*
         * create an array : arr of size n
         * now run through edges and which ever value is at 2nd index make it -1 from arr
         * now simple run a loop in array and count how many has val == 0
         * if count is only one, that's our answer or else count > 1 then answer is -1
         * */
        int[] arr = new int[n];
        for (int[] edge : edges) arr[edge[1]]--;

        int count = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans = i;
                count++;
            }
        }
        return count == 1 ? ans : -1;
    }
}