package _21_Graphs.Questions_MikePlayList;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class _1MinMutation_433_3 {

    public static void main(String[] args) {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    private static HashSet<String> dic;

    public static int minMutation(String src, String target, String[] bank) {
        if (src.equals(target)) return 0;

        dic = new HashSet<>(List.of(bank));
        dic.remove(src);
        if (!dic.contains(target)) return -1;

        char[] types = {'A', 'C', 'G', 'T'};
        ArrayDeque<String> q = new ArrayDeque<>();
        q.addLast(src);
        int count = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                String s = q.removeFirst();

                if (s.equals(target)) return count;

                for (char ch : types) {
                    for (int i = 0; i < 8; i++) {
                        String temp = s.substring(0, i) + ch + s.substring(i + 1);
                        if (dic.contains(temp)) {
                            q.addLast(temp);
                            dic.remove(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }
}