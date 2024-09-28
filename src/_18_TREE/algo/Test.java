package _18_TREE.algo;

public class Test {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] arr = {8, 7, 12, 15, 2, 5, 11};

        for (int num : arr) bt.insert(num);
        bt.printTree();
    }

}
