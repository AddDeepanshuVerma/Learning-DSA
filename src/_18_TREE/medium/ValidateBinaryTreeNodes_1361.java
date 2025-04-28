package _18_TREE.medium;

import java.util.ArrayDeque;

class ValidateBinaryTreeNodes_1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(0);
        int index = 0;

        while (!q.isEmpty()) {
            int pop = q.pop();
            if(index >= n) return false;

            if (leftChild[index] != -1) q.push(leftChild[index]);
            if (rightChild[index] != -1) q.push(rightChild[index]);
            index++;
        }
        return index == n;
    }
}