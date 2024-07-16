package _08_Strings.easy;

class IsLongPressedName_925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName2("alexd", "ale"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        for (int j = 0; j < typed.length(); ++j)
            if (i < name.length() && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;

        return i == name.length();
    }

    public static boolean isLongPressedName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public boolean isLongPressedName3(String name, String typed) {
        if (typed.length() < name.length()) return false;

        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++; j++;
            }
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }
            else if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
        }
        for (int k = j ; k < typed.length(); k++) {
            if (typed.charAt(k) != typed.charAt(k-1)) {
                return false;
            }
        }
        return i == name.length();
    }
}