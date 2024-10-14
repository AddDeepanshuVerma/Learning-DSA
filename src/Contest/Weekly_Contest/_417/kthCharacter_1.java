package Contest.Weekly_Contest._417;

class kthCharacter_1 {
    public static void main(String[] args) {
        System.out.println(kthCharacter_1.kthCharacter(5));
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
            if (ch == 'z') {
                newStr.append("a");
            }
            newStr.append((char)(ch - 'a' + 'b'));

        }
        return newStr.toString();
    }

}