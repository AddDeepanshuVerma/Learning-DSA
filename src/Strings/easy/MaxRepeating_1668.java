package Strings.easy;

import Sorting_07.Algos.SelectionSort;

class MaxRepeating_1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeating2("abcabcabab", "ab"));
    }

    /*public static int maxRepeating3(String sequence, String word) {

    }*/


    public static int maxRepeating2(String sequence, String word) {
        String toFind = word;
        int count = 0;
        while (true) {
            int index = sequence.indexOf(toFind);
            if (index == -1) return count;
            else {
                count++;
                toFind += word;
            }
        }
    }
}