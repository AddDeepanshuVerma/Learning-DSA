package Contest.Weekly_Contest._446;

import java.util.Arrays;

public class Q3 {

    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] q = new long[k];
        long[] a = new long[k];
        long[] b = new long[k];

        for (int i = 0; i < n; ++i) {
            int m = nums[i] % k;
            Arrays.fill(b, 0L);

            for (int p = 0; p < k; ++p) {
                int index = (int) (((long) p * m) % k);
                b[index] += a[p];
            }

            b[m]++;

            for (int x = 0; x < k; ++x) {
                q[x] += b[x];
            }

            // Swap arrays a and b
            long[] temp = a;
            a = b;
            b = temp;
        }

        return q;
    }


    public long[] resultArray_base(int[] nums, int k) {
        int z = nums.length;
        int K = k;
        long[] q = new long[K];
        long[] a = new long[K];
        long[] b = new long[K];

        for (int i = 0; i < z; ++i) {
            int m = nums[i] % K;
            Arrays.fill(b, 0L);

            for (int p = 0; p < K; ++p) {
                int index = (int) ((1L * p * m) % K);
                b[index] += a[p];
            }

            b[m]++;

            for (int x = 0; x < K; ++x) {
                q[x] += b[x];
            }

            // Swap arrays a and b
            long[] temp = a;
            a = b;
            b = temp;
        }

        return q;
    }

    public static void main(String[] args) {
        Q3 obj = new Q3();
    }
}
