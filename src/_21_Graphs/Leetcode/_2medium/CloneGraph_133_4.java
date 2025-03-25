package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CloneGraph_133_4 {
    private final HashMap<Node, Node> dp = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (dp.containsKey(node)) return dp.get(node);

        Node newNode = new Node(node.val);
        dp.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
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