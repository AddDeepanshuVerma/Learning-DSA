package POTD_LEETCODE.Level_1;

class MaximumGain_1717 {
    public static void main(String[] args) {
        String str = "aabbaaxybbaabb";
        System.out.println(maximumGain(str, 5, 4));
    }

    public static int maximumGain(String s, int x, int y) {
        if (x > y)
            return searchElements(s, "ab", x, "ba", y);
        else
            return searchElements(s, "ba", y, "ab", x);
    }

    private static int searchElements(String s, String s1, int x, String s2, int y) {
        int indexS1 = 0, indexS2 = 0;
        int countS1 = 0, countS2 = 0;
        while (indexS1 != -1) {
            indexS1 = s.indexOf(s1);
            if (indexS1 != -1) {
                s = s.substring(0, indexS1) + s.substring(indexS1 + 2);
                countS1++;
            }
        }
        while (indexS2 != -1) {
            indexS2 = s.indexOf(s2);
            if (indexS2 != -1) {
                s = s.substring(0, indexS2) + s.substring(indexS2 + 2);
                countS2++;
            }
        }
        return (countS1 * x) + (countS2 * y);
    }

}