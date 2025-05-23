package _18_TREE.medium;

import java.util.*;

class ValidateBinaryTreeNodes_1361_3 {
    public static void main(String[] args) {
        ValidateBinaryTreeNodes_1361 obj = new ValidateBinaryTreeNodes_1361();
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        boolean b = obj.validateBinaryTreeNodes(4, leftChild, rightChild);
        System.out.println(b);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> childToParent = new HashMap<>(); //{child, parent}
        HashMap<Integer, List<Integer>> parentToChild = new HashMap<>(); //{parent, list of children}

        for (int i = 0; i < n; i++) {
            int node = i, left = leftChild[i], right = rightChild[i];

            if (left != -1) {
                if (childToParent.containsKey(left)) {
                    return false;
                }
                childToParent.put(left, node);
                parentToChild.computeIfAbsent(node, k -> new ArrayList<>()).add(left);
            }
            if (right != -1) {
                if (childToParent.containsKey(right)) {
                    return false;
                }
                childToParent.put(right, node);
                parentToChild.computeIfAbsent(node, k -> new ArrayList<>()).add(right);
            }

        }

        // 2. now check only a single node from 0 till n-1 has no parent (which will be node)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;

        //3. in this step we will do a traversal and keep counting number of nodes occurred while count
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.push(root);
        visited[root] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int child : parentToChild.getOrDefault(poll, Collections.emptyList())) {
                if (!visited[child]) {
                    visited[root] = true;
                    q.push(child);
                    count++;
                } else return false;
            }
        }
        return count == n;
    }
}