package _18_TREE.medium;

import java.util.*;

class ValidateBinaryTreeNodes_1361_2 {
    public static void main(String[] args) {
        ValidateBinaryTreeNodes_1361 obj = new ValidateBinaryTreeNodes_1361();
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        boolean b = obj.validateBinaryTreeNodes(4, leftChild, rightChild);
        System.out.println(b);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
//        A valid tree must have nodes with only one parent and exactly one node with no parent.
        /*Here we need to check below points
         * 1. Every child should have single parent
         * 2. a single node must not have any parent (node node)
         * 3. Tree that needs to be generated from the valid node, must contain all remaining nodes
         *    , there should not be more than one tree disconnected*/

//        1. let's create a child-to-parent map and each child must have single entry of their parent
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
        // now it's confirmed that every child had single parent

        // 2. now check only a single node from 0 till n-1 has no parent (which will be node)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;
        // now we got the value of applicable node value

        //3. in this step we will do a traversal and keep counting number of nodes occurred while count
        // which should be equal to n
        // for traversal we need parent-to-child relationship
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        q.push(root);
        visited.add(root);
        int count = 1;

        while (!q.isEmpty()) {
            int poll = q.poll();
            List<Integer> list = parentToChild.get(poll);
            if (list != null) {
                for (Integer child : list) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        q.push(child);
                        count++;
                    } else {
                        // it was already visited while doing a level order traversal hence it's not a tree
                        return false;
                    }
                }
            }
        }
        return count == n;
    }
}