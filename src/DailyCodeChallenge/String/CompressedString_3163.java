package DailyCodeChallenge.String;

class CompressedString_3163 {
    public static void main(String[] args) {
        CompressedString_3163 obj = new CompressedString_3163();
        System.out.println(obj.compressedString("aaaaaaaaay"));

    }

    public String compressedString(String word) {
        int count = 1;
        char ch = word.charAt(0);
        char[] arr = word.toCharArray();
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ch) {
                count++;
                if (count == 9) {
                    ans.append(9).append(ch);
                    count = 0;
                }
            } else {
                if (count != 0) ans.append(count).append(ch);
                count = 1;
                ch = arr[i];
            }
        }
        if (count != 0) ans.append(count).append(ch);

        return ans.toString();
    }
}