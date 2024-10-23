package _18_TREE.medium;

class intersect_558 {
    public Node intersect(Node quadTree1, Node quadTree2) {

        // if any one of two is a leaf tree; means resultant will also be a leaf tree
        // just get the value
        if (quadTree1.isLeaf) return quadTree1.val ? quadTree1 : quadTree2;
        // if tree1 is leaf && all its values are 1 then resultant will be same a tree1 as OR operator will convert them to 1 but if tree1 is leaf && all its
        // values are 0 then resultant tree depends on tree2
        if (quadTree2.isLeaf) return quadTree2.val ? quadTree2 : quadTree1; // same as above

        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val && topLeft.isLeaf && topRight.isLeaf &&
                bottomLeft.isLeaf && bottomRight.isLeaf) return new Node(topLeft.val, true);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }
    }
}
