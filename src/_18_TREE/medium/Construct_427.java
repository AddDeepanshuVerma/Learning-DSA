package _18_TREE.medium;

class Construct_427 {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int r, int c, int n) {
        if (isAllSame(grid, r, c, n)) {
            return new Node(grid[r][c] == 1, true, null, null, null, null);
        }

        Node res = new Node(true, false);
//        Node res = new Node(false, false);
        int nN = n >> 1;
        res.topLeft = dfs(grid, r, c, nN);
        res.topRight = dfs(grid, r, c + nN, nN);
        res.bottomLeft = dfs(grid, r + nN, c, nN);
        res.bottomRight = dfs(grid, r + nN, c + nN, nN);

        return res;
    }

    private boolean isAllSame(int[][] grid, int r, int c, int n) {
        int base = grid[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (base != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}