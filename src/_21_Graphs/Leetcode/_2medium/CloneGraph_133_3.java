package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.List;

class CloneGraph_133_3 {
    private final Node[] arr = new Node[101];

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) return null;
        if (arr[node.val] != null) return arr[node.val];

        Node clone = new Node(node.val);
        arr[node.val] = clone;
        for (Node child : node.neighbors) {
            clone.neighbors.add(dfs(child));
        }
        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}