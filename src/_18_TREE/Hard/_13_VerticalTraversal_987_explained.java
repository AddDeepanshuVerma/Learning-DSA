package _18_TREE.Hard;

import java.util.*;

class _13_VerticalTraversal_987_explained {
    static int index;

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        index = -1;
        TreeNode root = insertArr(arr);

        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
    }

    private static TreeNode insertArr(int[] arr) {
        index++;
        if (arr[index] == -1) return null;

        TreeNode temp = new TreeNode(arr[index]);
        temp.left = insertArr(arr);
        temp.right = insertArr(arr);
        return temp;
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // taking treemap to store key as per their universal asd order
        // here we will store for nth row, how many column are there, where each column might have multiple values (need to be in asc order)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Need a queue to do BFS on Tree of type Trio to store {Node, row, col}
        ArrayDeque<Trio> que = new ArrayDeque<Trio>();
        //Adding root node to queue to start our BFS
        que.push(new Trio(root, 0, 0));

        while (!que.isEmpty()) {
            Trio pop = que.pop();
            // here each level does not matter, hence we do not need to keep pooing till queue is empty at a single go
            TreeNode temp = pop.node;
            int col = pop.col;
            int row = pop.row;

            // now we need to have valid map.get(col).get(row) so that we could put our node's data in priority queue
            if (!map.containsKey(col)) map.put(col, new TreeMap<>());
            if (!map.get(col).containsKey(row)) map.get(col).put(row, new PriorityQueue<>());
            // now we can put our values
            map.get(col).get(row).offer(temp.data);

            // now simply put node's left & right value in queue if they are not null
            if (temp.left != null) que.push(new Trio(temp.left, col - 1, row + 1));
            if (temp.right != null) que.push(new Trio(temp.right, col + 1, row + 1));
        }
        // now we have required data in structure form
        List<List<Integer>> ans = new ArrayList<>();
        // for every value in our first key, create a list and store value's value in it 
        for (var value : map.values()) {
            List<Integer> temp = new ArrayList<>();
            for (var pq : value.values()) {
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }
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