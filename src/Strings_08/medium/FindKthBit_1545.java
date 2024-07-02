package Strings_08.medium;

class FindKthBit_1545 {
    public static void main(String[] args) {
        System.out.println(new FindKthBit_1545().findKthBit(4, 11));

    }
    public char findKthBit(int n, int k) {
        String str = findBitValue(n);
        return str.charAt(k - 1);
    }

    private String findBitValue(int n) {
        if (n == 1) {
            return "0";
        }
        String str = findBitValue(n-1);
        return str + "1" + reverse_invert(str);
    }

    private String reverse_invert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i) == '1' ? 0 : 1);
        }
        return sb.toString();
    }
}