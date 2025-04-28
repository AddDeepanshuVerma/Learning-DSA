package _18_TREE.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class FindMode_501_2 {
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        // pq will store :: { value, count }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
        for (var item : map.entrySet()) pq.add(new int[]{item.getKey(), item.getValue()});

        int max = pq.peek()[1]; // max occurance of a value
        while (!pq.isEmpty() && pq.peek()[1] == max) {
            list.add(pq.poll()[0]);
        }

        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;

        inOrder(root.left, map);
        map.merge(root.val, 1, Integer::sum);
        inOrder(root.right, map);
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