package POTD_LEETCODE.Level_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DelNodes1110 {
    private TreeNode deleteHelper(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if (root == null)
            return null;

        root.left = deleteHelper(root.left, set, result);
        root.right = deleteHelper(root.right, set, result);

        if (set.contains(root.val)) {
            if (root.left != null) result.add(root.left);
            if (root.right != null) result.add(root.right);
            return null;
        } else
            return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : to_delete)
            set.add(num);

        deleteHelper(root, set, result);

        if (!set.contains(root.val)) result.add(root);

        return result;
    }
}