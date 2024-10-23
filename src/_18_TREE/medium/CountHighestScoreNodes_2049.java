package _18_TREE.medium;

import java.util.*;

// Getting beats 22% only
class CountHighestScoreNodes_2049 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 0, 2, 0};
        CountHighestScoreNodes_2049 obj = new CountHighestScoreNodes_2049();
        System.out.println(obj.countHighestScoreNodes(arr));
    }

    HashMap<Integer, List<Integer>> parentToChild;
    int[] dp;

    public int countHighestScoreNodes(int[] parents) {
        int count = 0;
        long max = Long.MIN_VALUE;
        int totalNodes = parents.length;
        parentToChild = new HashMap<>();
        dp = new int[totalNodes];
        Arrays.fill(dp, -1);

        for (int i = 0; i < totalNodes; i++) {
            parentToChild.computeIfAbsent(parents[i], val -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < totalNodes; i++) {
            List<Integer> list = left_Right_nodes(i);
            int add = 0, mul = 1;
            for (int num : list) {
                add += num;
                mul *= num;
            }

            long aboveNodes = totalNodes - (add + 1);
            if (aboveNodes == 0) aboveNodes = 1;

            long product = aboveNodes * mul; // product of the sizes of all those subtrees.
//            System.out.println("product = " + product);
            if (max == product) {
                count++;
            } else if (max < product) {
                max = product;
                count = 1;
            }
        }
        return count;
    }

    private List<Integer> left_Right_nodes(int root) {
        List<Integer> childs = parentToChild.getOrDefault(root, Collections.emptyList());
        ArrayList<Integer> ans = new ArrayList<>();

        for (int child : childs) {
            int count = countOfNodes(child);
            ans.add(count);
        }
        return ans;
    }

    private int countOfNodes(int root) {
        if (dp[root] != -1) {
            return dp[root];
        }
        int count = 0;
        List<Integer> childs = parentToChild.getOrDefault(root, Collections.emptyList());
        for (int child : childs) {
            count += countOfNodes(child);
        }
        return dp[root] = count + 1;
    }
}