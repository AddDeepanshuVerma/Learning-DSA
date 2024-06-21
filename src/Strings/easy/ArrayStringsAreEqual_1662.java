package Strings.easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

class ArrayStringsAreEqual_1662 {
    public static void main(String[] args) {
        String[] st1 = {"ab", "c"};
        String[] st2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(st1,st2));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String st1 = String.join("", word1);
        String st2 = String.join("", word2);
        return st1.equals(st2);
    }
}