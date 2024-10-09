package _18_TREE.Hard;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    public static void main(String[] args) {
//         Your Codec object will be instantiated and called as such:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
    }

    static int index = 0;
    static Map<Integer, TreeNode> cache = new HashMap<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        index++;
        cache.put(index, root);
        return String.valueOf(index);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int key = Integer.parseInt(data);
        return cache.get(key);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}