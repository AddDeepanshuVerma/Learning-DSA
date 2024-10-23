package _18_TREE.medium;

class PathSum_437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = 0;
        count += (int) getSumForRoot(root, 0, targetSum);

        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    private long getSumForRoot(TreeNode root, long currSum, long targetSum) {
        if (root == null) return 0;

        long count = 0;
        currSum += root.val;
        if (currSum == targetSum) {
            count++;
        }
        count += getSumForRoot(root.left, currSum, targetSum);
        count += getSumForRoot(root.right, currSum, targetSum);

        return count;
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