package DailyCodeChallenge.level_3;

class XorQueries_1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int temp = 0;
            for (int j = start; j <= end; j++) {
                temp ^= arr[j];
            }
            ans[i] = temp;
        }
        return ans;
    }

    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int temp = arr[start];
            for (int j = start + 1; j <= end; j++) {
                temp ^= arr[j];
            }
            ans[i] = temp;
        }
        return ans;
    }

    public int[] xorQueries3(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) {
                ans[i] = arr[end];
            } else {
                ans[i] = arr[start - 1] ^ arr[end];
            }
        }
        return ans;
    }

    public int[] xorQueries4(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            /*
            if (queries[i][0] == 0) {
                ans[i] = arr[queries[i][1]];
            } else {
                ans[i] = arr[queries[i][0] - 1] ^ arr[queries[i][1]];
            }
            */
            ans[i] = arr[queries[i][1]] ^ (queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1]);

        }
        return ans;
    }
}