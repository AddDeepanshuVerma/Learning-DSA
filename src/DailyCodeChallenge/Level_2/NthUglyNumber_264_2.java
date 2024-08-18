package DailyCodeChallenge.Level_2;

class NthUglyNumber_264_2 {
    public static void main(String[] args) {
        NthUglyNumber_264_2 obj = new NthUglyNumber_264_2();
        System.out.println(obj.nthUglyNumber(11));

    }

    public int nthUglyNumber(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int c2, c3, c5;
        c2 = c3 = c5 = 1;

        for (int i = 2; i < n + 1; i++) {
            int num_c2 = arr[c2] * 2;
            int num_c3 = arr[c3] * 3;
            int num_c5 = arr[c5] * 5;

            int min = Math.min(Math.min(num_c2, num_c3), num_c5);
            if (num_c2 == min) c2++;
            if (num_c3 == min) c3++;
            if (num_c5 == min) c5++;
            arr[i] = min;
        }
        return arr[n];
    }
}
