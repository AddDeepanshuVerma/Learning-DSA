import java.util.Arrays;

public class PreRequisite {

    static class FenwickTree {
        private final int size;
        private final int[] tree;

        public FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 1];
        }

        public void update(int i, int val) {
            for (; i <= size; i += i & -i) {
                tree[i] += val;
            }
        }

        public int query(int i) {
            int s = 0;
            for (; i > 0; i -= i & -i) {
                s += tree[i];
            }
            return s;
        }

        public int rangeSum(int i, int j) {
            return query(j) - query(i - 1);
        }
    }

    record Pair(Integer first, Integer Second) {

    }

    public static int abs(int a) {
        return a < 0 ? -a : a;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static long min(long a, long b) {
        return a < b ? a : b;
    }

    public static long max(long a, long b) {
        return a > b ? a : b;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean containsAllOnes(int n) {
        return (n & (n + 1)) == 0;
    }

    public static <Y> void print(Y res) {
        System.out.println(res);
    }

    public static <E> void printArr(E[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
