package Strings_08.easy;

class IsPalindrome_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                sb.append(c);
            }
        }

        s = sb.toString();
        return s.contentEquals(sb.reverse());
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString().contentEquals(sb.reverse());
    }
}