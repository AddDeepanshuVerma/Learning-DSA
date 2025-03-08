package _21_Graphs.Questions_MikePlayList;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class _1MinMutation_433_2 {

    public static void main(String[] args) {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bank = {"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    private static HashSet<String> dic;

    public static int minMutation(String src, String target, String[] bank) {
        dic = new HashSet<>(List.of(bank));
        dic.remove(src);
        if (!dic.contains(target)) return -1;

        if (src.equals(target)) return 0;
        char[] types = {'A', 'C', 'G', 'T'};

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.addLast(new Pair(src, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair pair = q.removeFirst();
                String s = pair.s;

                if (s.equals(target)) return pair.count;

                for (char ch : types) {
                    for (int i = 0; i < 8; i++) {
                        String temp = s.substring(0, i) + ch + s.substring(i + 1);
                        if (dic.contains(temp)) {
                            q.addLast(new Pair(temp, pair.count + 1));
                            dic.remove(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    record Pair(String s, Integer count) {

    }
}