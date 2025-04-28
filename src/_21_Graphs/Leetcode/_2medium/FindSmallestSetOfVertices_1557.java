package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.List;

class FindSmallestSetOfVertices_1557 {
    /*
    Given :Given graph is mentioned as DAG (Directed Acyclic Graph)
    Approach : Being it a DAG; first thing we think about it TOPOLOGICAL SORT
    Also it is mentioned that "It's guaranteed that a unique solution exists" hence we don't need to calculate
    topological sort, we can simply return all nodes whose indegree == 0 as topological sort's will have to start from them
    */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1);
            indegree[v]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}