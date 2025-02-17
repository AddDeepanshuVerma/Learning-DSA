package POTD_LEETCODE.Tree;

import java.util.*;

class MinimumOperations_2471 {
    public int minimumOperations(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int count = 0;
        int[] arr;
        while (!q.isEmpty()) {
            int size = q.size();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
                arr[i] = poll.val;
            }
            count += requiredSwaps2(arr);
        }
        return count;
    }

    private int requiredSwaps2(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>(); // map will tell us the index of element
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i);
        }

        int count = 0, i = 0;
        while (i < arr.length) {
            int validIndex = map.get(arr[i]);
            if (validIndex == i) {
                i++;
            } else {
                swap(arr, validIndex, i);
                count++;
            }
        }
        return count;
    }

    //minimum number of operations needed to make list sorted
    private int requiredSwaps(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int index = 0, max = Integer.MIN_VALUE;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            if (index != n - i - 1) count++;
            swap(arr, index, n - i - 1);
        }
        return count;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}