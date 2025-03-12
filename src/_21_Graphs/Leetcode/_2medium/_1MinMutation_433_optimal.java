package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class _1MinMutation_433_optimal {

    public static void main(String[] args) {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = {"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String src, String target, String[] bank) {
        HashSet<String> dictionary = new HashSet<>(Arrays.asList(bank));
        ArrayDeque<String> q = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        String explore = "ACGT";
        q.offer(src);
        seen.add(src);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String s = q.removeFirst();
                if (s.equals(target)) return level; // found the target

                for (char ch : explore.toCharArray()) {
                    for (int i = 0; i < s.length(); i++) {
                        char[] arr = s.toCharArray();
                        arr[i] = ch;
                        String temp = String.valueOf(arr);
                        if (dictionary.contains(temp) && !seen.contains(temp)) {
                            q.offer(temp);
                            seen.add(temp);
                        }
                    }
                }
            }
            if (!q.isEmpty()) level++;
        }
        return -1;
    }

    public static int minMutation2(String src, String target, String[] bank) {
        HashSet<String> dictionary = new HashSet<>(Arrays.asList(bank));
        ArrayDeque<String> q = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        String explore = "ACGT";
        q.offer(src);
        seen.add(src);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String s = q.removeFirst();
                if (s.equals(target)) return level; // found the target

                char[] arr = s.toCharArray();

                for (char ch : explore.toCharArray()) {
                    for (int i = 0; i < arr.length; i++) {
                        char tempCh = arr[i];
                        arr[i] = ch;
                        String temp = String.valueOf(arr);
                        if (dictionary.contains(temp) && !seen.contains(temp)) {
                            q.offer(temp);
                            seen.add(temp);
                        }
                        arr[i] = tempCh;
                    }
                }
            }
            if (!q.isEmpty()) level++;
        }
        return -1;
    }
}