package POTD_LEETCODE.z_TBD;

import java.util.*;

class FindAllRecipes_2115_topological {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        /*Steps
         * 1. First make all supplies searchable in log(n) time
         * 2. Then make a graph(adj lists) of Strings with 2 one HashMap storing their in & out degree
         * 3. Now apply topological sort : all the nodes with 0 indegree needs to be source of starting the BFS approach
         * 4. Here when we reach to a leaf node means if we find a node whose inDegree & outDegree both are zero than it has to be available in supplies
         * 5. if all got nodes of graph (nodes ==hashMap size) traversed and every leaf node was present in supplies, means we can create that recipe
         * NOTE : ALL those nodes which were leaf will be added in our result rest would not be as they would be in a cycle
         * */

        // make supplies :
        HashSet<String> suppliesSet = new HashSet<>(List.of(supplies)); // store our supplies
        // make graph and nodes in&out degrees
        HashMap<String, List<String>> adj = new HashMap<>();            // store our graph
        HashMap<String, Integer> inDegree = new HashMap<>();            // stores all String inDegree
        HashMap<String, Integer> outDegree = new HashMap<>();           // stores all String outDegree

        for (int i = 0; i < recipes.length; i++) {
            String u = recipes[i];
            List<String> v = new ArrayList<>(ingredients.get(i));
            adj.put(u, v);

            outDegree.merge(u, v.size(), Integer::sum);
            for (String s : v) inDegree.merge(s, 1, Integer::sum);
        }

        // now start topological sort
        ArrayDeque<String> q = new ArrayDeque<>();
        for (var item : inDegree.entrySet()) {
            if (item.getValue() == 0) {
                q.offer(item.getKey());// all those nodes with inDegree == 0, will be starting point of topological sort
            }
        }

        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            String u = q.poll();
            if (inDegree.get(u) == 0 && outDegree.get(u) == 0 && suppliesSet.contains(u)) {
                ans.add(u);
                continue;
            }

            for (String v : adj.getOrDefault(u, Collections.emptyList())) {
                int vIndegree = inDegree.merge(v, -1, Integer::sum);
                if (vIndegree == 0) { // means this node can be added in queue again
                    q.offer(v);
                }
            }
        }
        return ans;
    }
}