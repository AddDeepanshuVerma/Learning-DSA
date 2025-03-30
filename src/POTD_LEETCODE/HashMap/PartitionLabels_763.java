package POTD_LEETCODE.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        int[] occur = new int[26];
        char[] arr = s.toCharArray();
        for (char ch : arr) occur[ch - 'a']++;

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0, prev = -1;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            int val = map.merge(ch, 1, Integer::sum);
            if (val == occur[ch - 'a']) {
                count++;
            }
            if (count == map.size()) {
                ans.add(i - prev);
                prev = i;
                map = new HashMap<>();
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new PartitionLabels_763();
        List<Integer> list = obj.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println("list = " + list);
    }
}