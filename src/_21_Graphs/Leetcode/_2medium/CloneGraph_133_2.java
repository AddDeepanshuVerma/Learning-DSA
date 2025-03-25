package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CloneGraph_133_2 {
    // ====================== using array as storage ======================
    private final Node[] arr = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        arr[node.val] = new Node(node.val);
        dfs(arr[node.val], node);
        return arr[node.val];
    }

    private void dfs(Node clone, Node node) {
        for (Node ngbr : node.neighbors) {
            if (arr[ngbr.val] == null) {
                arr[ngbr.val] = new Node(ngbr.val);
                dfs(arr[ngbr.val], ngbr);
            }
            clone.neighbors.add(arr[ngbr.val]);
        }
    }

    // ====================== using hashMap as storage ======================
    public Node cloneGraph2(Node node) {
        if (node == null) return null;

        HashMap<Integer, Node> db = new HashMap<>();
        db.put(node.val, new Node(node.val));
        dfs2(db.get(node.val), node, db);
        return db.get(node.val);
    }

    private void dfs2(Node clone, Node node, HashMap<Integer, Node> db) {
        for (Node ngbr : node.neighbors) {
            if (!db.containsKey(ngbr.val)) {
                db.put(ngbr.val, new Node(ngbr.val));
                dfs2(db.get(ngbr.val), ngbr, db);
            }
            clone.neighbors.add(db.get(ngbr.val));
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