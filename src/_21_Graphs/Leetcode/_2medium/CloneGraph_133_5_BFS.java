package _21_Graphs.Leetcode._2medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class CloneGraph_133_5_BFS {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node[] arr = new Node[101];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        arr[node.val] = new Node(node.val);
        q.offer(new Pair(arr[node.val], node));

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            Node clone = poll.temp();
            Node src = poll.node();

            for (Node ngbr : src.neighbors) {
                if (arr[ngbr.val] == null) {
                    arr[ngbr.val] = new Node(ngbr.val);
                    q.offer(new Pair(arr[ngbr.val], ngbr));
                }
                clone.neighbors.add(arr[ngbr.val]);
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