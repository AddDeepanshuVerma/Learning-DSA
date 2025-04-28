package _19_TRIE.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaximizeXor_1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            list.add(List.of(query[0], query[1], i));
        }

        list.sort((a, b) -> a.get(1) - b.get(1));

        int idx = 0;
        Trie node = new Trie();
        int[] res = new int[queries.length];
        for (List<Integer> query : list) {
            int xi = query.get(0);
            int mi = query.get(1);
            int index = query.get(2);
            while (idx < nums.length && nums[idx] <= mi) {
                node.insertBits(nums[idx++]);
            }
            if (idx == 0) {
                res[index] = -1;
            } else {
                res[index] = node.getMaximumInTrie(xi);
            }
        }
        return res;
    }


    private static class Node {
        Node[] links = new Node[2];

        public boolean contains(int bit) {
            return links[bit] != null;
        }

        public void put(int bit, Node node) {
            links[bit] = node;
        }

        public Node get(int bit) {
            return links[bit];
        }
    }
    private class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insertBits(int num) {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!temp.contains(bit)) {
                    temp.put(bit, new Node());
                }
                temp = temp.get(bit);
            }
        }

        public int getMaximumInTrie(int num) {
            Node temp = root;
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (temp.contains(bit ^ 1)) {
                    ans = ans | (1 << i);
                    temp = temp.get(bit ^ 1);
                } else {
                    temp = temp.get(bit);
                }
            }
            return ans;
        }
    }
}