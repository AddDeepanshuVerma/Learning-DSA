package _18_TREE.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class GetDirections_2096_3 {
    public static void main(String[] args) {
        GetDirections_2096_3 obj = new GetDirections_2096_3();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(obj.getDirections(root, 3, 6));

    }

    HashMap<TreeNode, TreeNode> childToParent;
    TreeNode startNode;

    public String getDirections(TreeNode root, int start, int dest) {
        // get parent to children and child to parent mapping first
        childToParent = new HashMap<>();
        dfs(root, start);

        // now find the node having our start value
        return BFS(startNode, dest);
    }

    private String BFS(TreeNode node, int dest) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.addLast(new Pair(node, ""));
        visited.add(node.val);
        String ans = "";

        while (!q.isEmpty()) {
            Pair poll = q.removeFirst();
            TreeNode temp = poll.node;
            String path = poll.path;
            if (temp.val == dest) {
                ans = path;
                break;
            }

            if (temp.left != null && !visited.contains(temp.left.val)) {
                visited.add(temp.left.val);
                q.addLast(new Pair(temp.left, path + "L"));
            }
            if (temp.right != null && !visited.contains(temp.right.val)) {
                visited.add(temp.right.val);
                q.addLast(new Pair(temp.right, path + "R"));
            }
            if (childToParent.containsKey(temp) && !visited.contains(childToParent.get(temp).val)) {
                TreeNode parent = childToParent.get(temp);
                visited.add(parent.val);
                q.addLast(new Pair(parent, path + "U"));
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, int start) {
        if (root == null) return;

        if (root.val == start) {
            startNode = root;
        }

        if (root.left != null) {
            childToParent.put(root.left, root);
        }
        if (root.right != null) {
            childToParent.put(root.right, root);
        }

        dfs(root.left, start);
        dfs(root.right, start);
    }

    record Pair(TreeNode node, String path) {
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