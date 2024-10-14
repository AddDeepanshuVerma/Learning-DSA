package _19_TRIE.algo;

class FindMaximumXOR_421 {
    public static void main(String[] args) {
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(FindMaximumXOR_421.findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        // first put all number in a trie, but we need to put their binary representation from end to start
        // Reason : Maximum elements will be having 1 bit in end first
        Node root = new Node();

        for (int num : nums) {
            Node temp = root;
            // we can iterate from 31st index without considering LSB value as all given integers in the array are +ive
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                // either bit will be 1 or 0; if bit is 1 search for 0 & vice-versa
                if (temp.links[bit] == null) {
                    temp.links[bit] = new Node();
                }
                temp = temp.links[bit];
            }
        }
        // all the elements binary representation is stored in trie
        // now we have a trie with all numbers binary representation
        // hence send one number at a time to trie to find maximum possible number out of trie who's XOR will provide max results

        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, findMaxXOR(num, root));
        }
        return ans;
    }

    private static int findMaxXOR(int num, Node root) {
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
        return res;
    }

    static class Node {
        Node[] links = new Node[2];
    }
}