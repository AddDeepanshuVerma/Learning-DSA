package _19_TRIE.medium;

class FindMaximumXOR_421 {
    public static int findMaximumXOR(int[] nums) {
        Node root = new Node();

        for (int num : nums) {
            Node temp = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (temp.links[bit] == null) {
                    temp.links[bit] = new Node();
                }
                temp = temp.links[bit];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            Node temp = root;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (temp.links[bit ^ 1] != null) {
                    res |= 1 << i;
                    temp = temp.links[bit ^ 1];
                } else {
                    temp = temp.links[bit];
                }
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }

    static class Node {
        Node[] links = new Node[2];
    }
}