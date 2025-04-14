package POTD_LEETCODE.Array;

class CountGoodTriplets_1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int x = Math.abs(arr[i] - arr[j]);
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[k] - arr[i]);
                    if (x <= a && y <= b && z <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int x = Math.abs(arr[i] - arr[j]);
                if (x > a) continue;
                for (int k = j + 1; k < n; k++) {
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[k] - arr[i]);
                    if (y <= b && z <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countGoodTriplets3(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}