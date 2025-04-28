package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.List;

class CloneGraph_133_DFS {
    private final Node[] arr = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node clone = new Node(node.val);
        arr[node.val] = clone;
        dfs(clone, node, arr);
        return clone;
    }

    private void dfs(Node clone, Node node, Node[] arr) {
        for (Node child : node.neighbors) {
            if (arr[child.val] == null) {
                arr[child.val] = new Node(child.val);
                dfs(arr[child.val], child, arr);
            }
            clone.neighbors.add(arr[child.val]);
        }
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