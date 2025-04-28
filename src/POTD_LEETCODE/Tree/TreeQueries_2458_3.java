package POTD_LEETCODE.Tree;

class TreeQueries_2458_3 {
    private final int[] level = new int[100001];
    private final int[] maxHeightAtLevel = new int[100001];
    private final int[] _2maxHeightAtLevel = new int[100001];
    private final int[] height = new int[100001];

    public int[] treeQueries(TreeNode root, int[] queries) {
        height(root, 0);

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int removedNode = queries[i];
            int L = this.level[removedNode];
            ans[i] = L + (maxHeightAtLevel[L] == height[removedNode] ? _2maxHeightAtLevel[L] : maxHeightAtLevel[L]) - 1;
        }
        return ans;
    }

    private int height(TreeNode root, int l) {
        if (root == null) return 0;

        int height = Math.max(height(root.left, l + 1), height(root.right, l + 1)) + 1;
        this.height[root.val] = height;
        level[root.val] = l;

        if (maxHeightAtLevel[l] < height) {
            _2maxHeightAtLevel[l] = maxHeightAtLevel[l];
            maxHeightAtLevel[l] = height;
        } else if (_2maxHeightAtLevel[l] < height)
            _2maxHeightAtLevel[l] = height;

        return height;
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
