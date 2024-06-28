package Strings_08.easy;

class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] arr = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix2(arr));
    }

    public static String longestCommonPrefix2(String[] strs) {
        String key = strs[0];
        StringBuilder toFind = new StringBuilder();
        for (int i = 1; i < key.length(); i++) {
            toFind.append(key.charAt(i));
            if (!validString(strs, toFind.toString())) {
                return toFind.deleteCharAt(toFind.length() - 1).toString();
            }
        }
        return toFind.toString();
    }

    private static boolean validString(String[] strs, String string) {
        for (String str : strs) {
            if (!str.startsWith(string)) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}