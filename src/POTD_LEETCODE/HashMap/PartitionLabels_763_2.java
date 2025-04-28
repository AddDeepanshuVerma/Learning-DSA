package POTD_LEETCODE.HashMap;

import java.util.ArrayList;
import java.util.List;

class PartitionLabels_763_2 {
    public List<Integer> partitionLabels(String s) {
        int[] global = new int[26];
        char[] arr = s.toCharArray();
        for (char ch : arr) global[ch - 'a']++;

        List<Integer> ans = new ArrayList<>();

        int[] map = new int[26];
        int count = 0, tempCount = 0, prev = -1;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if (++map[ch - 'a'] == 1) tempCount++;
            if (map[ch - 'a'] == global[ch - 'a']) count++;

            if (count == tempCount) {
                ans.add(i - prev);
                prev = i;
                map = new int[26];
                count = 0;
                tempCount = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new PartitionLabels_763_2();
        List<Integer> list = obj.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println("list = " + list);
    }
}