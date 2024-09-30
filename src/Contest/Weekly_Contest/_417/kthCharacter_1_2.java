package Contest.Weekly_Contest._417;

class kthCharacter_1_2 {
    public static void main(String[] args) {
        System.out.println(kthCharacter_1_2.kthCharacter(5));
    }

    public static char kthCharacter(int k) {
        StringBuilder str = new StringBuilder();
        str.append("a");
        while (str.length() < k) {
            str.append(getString(str.toString()));
        }
        return str.charAt(k - 1);
    }

    private static String getString(String str) {
        StringBuilder newStr = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == 'z') newStr.append("a");
            newStr.append(((char) (ch + 1)));
//            newStr.append(((char) ((ch - 'a' + 1) % 26 + 'a')));

        }
        return newStr.toString();
    }

}