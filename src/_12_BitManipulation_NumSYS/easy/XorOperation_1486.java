package _12_BitManipulation_NumSYS.easy;

class XorOperation_1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(4, 3));
    }
    public static int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans ^= start + (i >> 1);
        return ans;
    }
}