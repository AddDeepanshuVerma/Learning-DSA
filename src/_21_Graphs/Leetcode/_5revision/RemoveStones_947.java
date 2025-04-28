package _21_Graphs.Leetcode._5revision;

class RemoveStones_947 {
    public int removeStones(int[][] stones) {
        /*
         * The hidden problem within this is :
         * we can remove a stone if & only if another stone shared the same row || colum
         * Here we will stop removing stones when only single stone is remaining
         * It simply means that : Group all those who belongs to same group & inside a group only single element will survive
         *                        Hence no of different groups = no of elements survives
         *                        Hence largest num of stones that can be removed = total stones - no of groups
         * SIMPLE DSU
         * */

        int nv = stones.length;
        // DSU prerequisite
        components = nv;
        parent = new int[nv];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < nv; i++) {
            for (int j = i + 1; j < nv; j++) {
                int[] src = stones[i];
                int[] dst = stones[j];
                if (src[0] == dst[0] || src[1] == dst[1]) {
                    union(i, j);
                }
            }
        }

        return nv - components;
    }

    int[] parent;
    int components;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if(bParent == aParent) return;
        parent[bParent] = aParent;
        components--;
    }
}