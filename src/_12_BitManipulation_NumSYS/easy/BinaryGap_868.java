package _12_BitManipulation_NumSYS.easy;

class BinaryGap_868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }

    public static int binaryGap(int n) {
        int count = 0, ans = 0;
        while (n > 0) {
            int bit = n & 1;
            count += bit;
            if (count == 2) {
                
            }
        }
        return ans;
    }
}