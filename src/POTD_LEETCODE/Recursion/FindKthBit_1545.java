package POTD_LEETCODE.Recursion;

class FindKthBit_1545 {
    public static void main(String[] args) {
        FindKthBit_1545 obj = new FindKthBit_1545();
        System.out.println(obj.findKthBit(3, 7));
    }

    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int strLength = (1 << n) - 1;
        int mid = strLength >> 1;

        if (k <= mid) return findKthBit(n - 1, k);
        else if (k == (mid + 1)) return '1';
        else {
//            k = (n + 1) - (k % (n + 1));
            k = strLength - k + 1;
            return findKthBit(n - 1, k) == '1' ? '0' : '1';
        }
    }
}