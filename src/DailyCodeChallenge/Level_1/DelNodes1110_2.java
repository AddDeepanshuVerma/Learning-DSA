package DailyCodeChallenge.Level_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DelNodes1110_2 {
    private boolean[] unique = new boolean[1001];
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete) unique[x] = true;
        if (dfs(root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (!unique[root.val])
            return root;
        if (root.left != null)  ans.add(root.left);
        if (root.right != null) ans.add(root.right);
        return null;
    }
}