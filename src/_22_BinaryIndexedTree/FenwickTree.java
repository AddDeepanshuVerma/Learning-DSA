package _22_BinaryIndexedTree;

public class FenwickTree {
    private final int[] tree;

    public int getSum(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    public int getSum(int idx) {
        int res = 0;
        for (int i = idx + 1; i > 0; i -= i & (-i))
            res += tree[i];
        return res;
    }

    public void add(int idx, int val) {
        for (int i = idx + 1; i < tree.length; i += i & (-i))
            tree[i] += val;
    }

    public FenwickTree(int size) {
        tree = new int[size + 1];
    }
}