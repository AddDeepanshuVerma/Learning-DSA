package _08_Strings.easy;

class NumOfStrings_1967 {
    public static void main(String[] args) {
        String[] str = {"a", "abc", "bc", "d"};
        System.out.println(numOfStrings(str, "abc"));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns)
            if (word.contains(pattern))
                count++;
        return count;
    }
}