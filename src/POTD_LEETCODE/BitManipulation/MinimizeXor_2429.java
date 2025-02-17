package POTD_LEETCODE.BitManipulation;

class MinimizeXor_2429 {
    public static void main(String[] args) {
        int i = Integer.valueOf("110110", 2);
        System.out.println("i = " + i);
        System.out.println(Integer.toBinaryString(25));
        System.out.println(Integer.toBinaryString(72));

        System.out.println(minimizeXor(25, 72));
    }

    public static int minimizeXor(int num1, int num2) {
        int required = Integer.bitCount(num2);
        int bitCount = Integer.bitCount(num1);

        if (bitCount == required) {
            return num1;
        } else if (bitCount > required) {
            // find right to left 1's from num1 and only keep them in resultant
            return rightToLeft(num1, required);
        } else {
            return leftToRight(num1, required - bitCount);
        }
    }

    private static int leftToRight(int num1, int count) {
        for (int i = 0; i <= 31 && count > 0; i++) {
            if (((1 << i) & num1) == 0) { // means this bit it 0
                // convert this bit to 1 as we are doing left to right hence it will be helpful to make ans minimal
                num1 |= 1 << i;
                count--;
            }
        }
        return num1;
    }

    private static int rightToLeft(int num1, int count) {
        int ans = 0;
        for (int i = 31; i >= 0 && count > 0; i--) {
            if (((num1 >> i) & 1) == 1) { // means 31'st bit is 1
                // change this ith bit to 1 in ans
                ans |= (1 << i);
                count--;
            }
        }
        return ans;
    }
}
