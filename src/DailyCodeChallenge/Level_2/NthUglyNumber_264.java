package DailyCodeChallenge.Level_2;

class NthUglyNumber_264 {
    public static void main(String[] args) {
        NthUglyNumber_264 obj = new NthUglyNumber_264();
        System.out.println(obj.nthUglyNumber(11));

    }

    private static final int[] arr;

    static {
        int n = 1690;
        arr = new int[n + 1];
        arr[1] = 1;
        int c2 = 1, c3 = 1, c5 = 1;

        for (int i = 2; i < n + 1; i++) {
            int num_c2 = arr[c2] * 2;
            int num_c3 = arr[c3] * 3;
            int num_c5 = arr[c5] * 5;

            int min = Math.min(Math.min(num_c2, num_c3), num_c5);
            arr[i] = min;
            if (num_c2 == min) c2++;
            if (num_c3 == min) c3++;
            if (num_c5 == min) c5++;
        }
    }

    //[1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
    public int nthUglyNumber(int n) {
        return arr[n];
    }
}
