package _12_BitManipulation_NumSYS.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReadBinaryWatch_401 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(readBinaryWatch(11));
}

    public static List<String> readBinaryWatch(int turnedOn) {
        // create an array from 0 to 60 and put count of 1's in it in the Binary representation of their indexes
        int[] arr = new int[61];
        for (int i = 1; i < 61; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i >> 1];
            } else {
                arr[i] = arr[i >> 1] + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        ArrayList<String> list = new ArrayList<>();
        // now loop from 0 to 12 and for its each value again loop through 0 to 60
        // if count of their 1's are same, simply put their combo in the resultant list
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                if (arr[i] + arr[j] == turnedOn) {
                    list.add(i + (j < 10 ? ":0" : ":") + j);
                }
            }
        }
        return list;
    }
}