package POTD_LEETCODE.Level_2;

import java.util.ArrayList;
import java.util.List;


class Postorder_590 {
    public static void main(String[] args) {
        Node child = new Node(5);
        for (Node node : child.children) {
            if (node == null) {
                System.out.println("node");
            }
        }
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        solve(root);
        return list;
    }

    private void solve(Node root) {
        if(root == null) return;
        System.out.println("root.children = " + root.children);
        for (Node child : root.children) {
            solve(child);
        }
        list.add(root.val);
    }
}