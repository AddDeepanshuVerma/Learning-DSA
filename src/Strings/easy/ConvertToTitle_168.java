package Strings.easy;

import jdk.jfr.Description;

import java.util.HashMap;

class ConvertToTitle_168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
//        System.out.println(convertToDecimal(10));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                reminder = 26;
                columnNumber--;
            } else {
                reminder = columnNumber % 26;
            }
            sb.append((char) ('A' + reminder - 1));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    @Description("lets say 26 nahi tha value to -- vaise bhi reminder me rk rhe the jo aage jake devide" +
            "hone ke baad farak nahi dalta but 26 hone pe dikkat thi jo -1 krne se solve ho jati" +
            "hence dono condition me -1 kr diya phle hi" +
            "means: jb bhi reminder 0 aaega to use 26 kr denge and next time same result na aaye divide krne pe " +
            "to number-- kr denge")
    public static String convertToTitle2(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        while (columnNumber > 0) {
            columnNumber--;
            reminder = columnNumber % 26;
            sb.append((char) ('A' + reminder));
            columnNumber /= 26;

        }
        return sb.reverse().toString();
    }

    public static String convertToTitle3(int columnNumber) {
        StringBuilder columnHeading = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put(i + 1, String.valueOf((char) (65 + i)));

        while (columnNumber > 0) {
            int rem = columnNumber % 26;
            columnNumber = columnNumber / 26;

            if (rem == 0) {
                rem = 26;
                columnNumber -= 1;
            }
            columnHeading.insert(0, map.get(rem));
        }

        System.gc();
        return columnHeading.toString();
    }
}