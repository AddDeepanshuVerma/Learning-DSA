package DailyCodeChallenge.Level_1;

//https://leetcode.com/problems/evaluate-boolean-binary-tree/
public class EvaluateTree {

    public static void main(String[] args) {

        System.out.println(false | true);
    }

//    public boolean evaluateTree(TreeNode root) {
//        if (root.value == 1) return true;
//        else if (root.value == 0) return false;
//
//        if (root == 2)
//            return evaluateTree(root.left) && evaluateTree(root.right);
//        else if (root == 3)
//            return evaluateTree(root.left) || evaluateTree(root.right);
//        return false;
//    }
}
