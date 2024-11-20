package POTD_LEETCODE.Level_2;

class GetLucky {
    public static void main(String[] args) {
        GetLucky obj = new GetLucky();
        System.out.println(obj.getLucky("leetcode", 2));

    }

    public int getLucky(String s, int k) {
        char[] arr = s.toCharArray();
        StringBuilder src = new StringBuilder();
        for (char c : arr) {
            int temp = c - 'a' + 1;
            src.append(temp);
        }
        String ans = src.toString();
        while (k-- > 0) {
            ans = addDigits(ans);
        }
        return Integer.parseInt(ans);
    }

    private String addDigits(String s) {
        int temp = 0;
        for (char c : s.toCharArray()) {
            temp += c - '0';
        }
        return temp + "";
    }
}