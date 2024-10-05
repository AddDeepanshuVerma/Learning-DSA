package _18_TREE.Hard;

import java.util.*;

class _13_VerticalTraversal_987 {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        ArrayDeque<Trio> que = new ArrayDeque<Trio>();

        que.push(new Trio(root, 0, 0));
        while (!que.isEmpty()) {
            Trio pop = que.pop();

            TreeNode temp = pop.node;
            int col = pop.col;
            int row = pop.row;

            if (!map.containsKey(col)) map.put(col, new TreeMap<>());
            if (!map.get(col).containsKey(row)) map.get(col).put(row, new PriorityQueue<>());
            map.get(col).get(row).offer(temp.data);

            if (temp.left != null) que.push(new Trio(temp.left, col - 1, row + 1));
            if (temp.right != null) que.push(new Trio(temp.right, col + 1, row + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (var value : map.values()) {
            List<Integer> temp = new ArrayList<>();
            for (var pq : value.values())
                while (!pq.isEmpty()) temp.add(pq.poll());
            ans.add(temp);
        }
        return ans;
    }

    static class Trio {
        TreeNode node;
        int col;
        int row;

        public Trio(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}