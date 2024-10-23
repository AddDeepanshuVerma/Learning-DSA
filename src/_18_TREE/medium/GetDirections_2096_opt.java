package _18_TREE.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class GetDirections_2096_opt {
    public static void main(String[] args) {
        GetDirections_2096_opt obj = new GetDirections_2096_opt();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(obj.getDirections(root, 3, 6));

    }

    public String getDirections(TreeNode root, int start, int dest) {
        /*get path from ROOT -> start
         * get path from ROOT -> dest
         * Now remove the common part and get "U" repeated uncommon part of for start
         * and just add dest part
         * */

        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();

        findPath(root, start, rootToStart); // "LRLLR"
        findPath(root, dest, rootToDest);   // "LRRRL"

        int shift = 0;
        while (shift < rootToStart.length() && shift < rootToDest.length() && rootToStart.charAt(shift) == rootToDest.charAt(shift)) {
            shift++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = shift; i < rootToStart.length(); i++) result.append("U");
        for (int i = shift; i < rootToDest.length(); i++) result.append(rootToDest.charAt(i));

        return result.toString();
    }

    private boolean findPath(TreeNode root, int start, StringBuilder path) {
        if (root == null) return false;
        if (root.val == start) return true;

        path.append("L");
        if (findPath(root.left, start, path)) return true;
        path.setLength(path.length() - 1);

        path.append("R");
        if (findPath(root.right, start, path)) return true;
        path.setLength(path.length() - 1);

        return false;
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