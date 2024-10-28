package DailyCodeChallenge.Tree;

class TreeQueries_2458_2 {
    int[] level;
    int[] maxAtLevel; // stores : at curr index(level) which is the max height
    int[] _2maxAtLevel;
    int[] height;

    public int[] treeQueries(TreeNode root, int[] queries) {
        /*
         * get the level of each node : as level can be same hence index = node, index value = level
         * get the max and second max of each level : as max[0] = 0'th level max element similar secondMax[0] = 0'th level max element
         * after removing a node X, effective height of tree = level of X - that level height after removing X node
         * */
        // count the number of nodes
        int count = count(root);
        this.level = new int[count + 1];
        this.maxAtLevel = new int[count + 1];
        this._2maxAtLevel = new int[count + 1];
        this.height = new int[count + 1];

        int level = 0;
        assignAllStructure(root, level);

        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int node = queries[i];
            int L = this.level[node];
            ans[i] = L + (maxAtLevel[L] == height[node] ? _2maxAtLevel[L] : maxAtLevel[L]) - 1;
        }
        return ans;
    }

    private int assignAllStructure(TreeNode root, int level) {
        if (root == null) return 0;

        int height = Math.max(assignAllStructure(root.left, level + 1), assignAllStructure(root.right, level + 1)) + 1;
        this.height[root.val] = height;
        this.level[root.val] = level;

        if (this.maxAtLevel[level] < height) {
            this._2maxAtLevel[level] = this.maxAtLevel[level];
            this.maxAtLevel[level] = height;
        } else if (this._2maxAtLevel[level] < height) {
            this._2maxAtLevel[level] = height;
        }

        return height;

    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
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