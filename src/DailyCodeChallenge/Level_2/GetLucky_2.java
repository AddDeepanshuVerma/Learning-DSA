package DailyCodeChallenge.Level_2;

class GetLucky_2 {
    public static void main(String[] args) {
        GetLucky_2 obj = new GetLucky_2();
        System.out.println(obj.getLucky("leetcode", 2));

    }

    public int getLucky(String s, int k) {
        StringBuilder src = new StringBuilder();
        for (char c : s.toCharArray())
            src.append(c - 'a' + 1);
        String ans = src.toString();
        while (k-- > 0) ans = addDigits(ans);
        return Integer.parseInt(ans);
    }

    private String addDigits(String s) {
        int temp = 0;
        for (char c : s.toCharArray())
            temp += c - '0';
        return temp + "";
    }
}