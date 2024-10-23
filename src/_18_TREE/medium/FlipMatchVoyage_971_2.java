package _18_TREE.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FlipMatchVoyage_971_2 {
    private int idx;
    ArrayList<Integer> list;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        idx = 0;
        list = new ArrayList<>();
        if (find(root, voyage)) return list;
        return List.of(-1);
    }

    public boolean find(TreeNode root, int[] voyage) {
        if (root == null) return true;
        if (root.val != voyage[idx]) return false;

        idx++;

        if (idx < voyage.length && root.left != null && root.left.val != voyage[idx]) {
            list.add(root.val);// now we have flipped with only available possibility hence remining has to be fine in PREORDER traversal
            // where right is left now hence right will be explored first
            return find(root.right, voyage) && find(root.left, voyage);
        } else {// here left val is fine hence remining all has to be fine as well for whole tree has to be fine in PREORDER traversal only
            return find(root.left, voyage) && find(root.right, voyage);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}