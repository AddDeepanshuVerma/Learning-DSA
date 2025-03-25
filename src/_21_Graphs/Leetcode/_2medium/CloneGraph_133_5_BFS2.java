package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class CloneGraph_133_5_BFS2 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node[] arr = new Node[101];
        ArrayDeque<Node> q = new ArrayDeque<>();

        arr[node.val] = new Node(node.val);
        q.offer(node);

        while (!q.isEmpty()) {
            Node u = q.poll();
            Node clone = arr[u.val];

            for (Node child : u.neighbors) {
                if (arr[child.val] == null) {
                    arr[child.val] = new Node(child.val);
                    q.offer(child);
                }
                clone.neighbors.add(arr[child.val]);
            }
        }
        return arr[node.val];
    }

    record Pair(Node temp, Node node) {
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