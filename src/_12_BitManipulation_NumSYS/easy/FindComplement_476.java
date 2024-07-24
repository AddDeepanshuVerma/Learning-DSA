package _12_BitManipulation_NumSYS.easy;

import java.util.concurrent.TimeUnit;

class FindComplement_476 {

    public static void main(String[] args) {
        System.out.println(findComplement4(8));
    }

    public static int findComplement4(int num) {
        // get number of digits in Binary num
        int digits = (int) (Math.log(num) / Math.log(2)) + 1;
        // XOR it with 1111 with matching length
        int mask = (1 << digits) - 1;
        System.out.println("mask " + Integer.toBinaryString(mask));
        return num ^ mask;
    }

    public static int findComplement3(int num) {
        // get number of digits in Binary num
        int digits = (int) (Math.log(num) / Math.log(2)) + 1;
        // XOR it with 1111 with matching length
        long mask = (long) Math.pow(2, digits) - 1;
        return (int) (num ^ mask);
    }

    public static int findComplement2(int num) {
        String str = "";
        while (num > 0) {
            if ((num & 1) == 1) {
                str = 0 + str;
            } else str = 1 + str;

            num >>= 1;
        }
        return Integer.parseInt(str, 2);
    }

    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if ((num & 1) == 1) {
                sb.append("0");
            } else sb.append("1");
            num >>= 1;
        }
        return Integer.parseInt(sb.reverse()
                                  .toString(), 2);
    }
}