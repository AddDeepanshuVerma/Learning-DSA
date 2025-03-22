package POTD_LEETCODE.z_TBD;

import java.util.*;

class FindAllRecipes_2115_topological_tbd {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // make supplies :
        HashSet<String> suppliesSet = new HashSet<>(List.of(supplies)); // store our supplies
        HashSet<String> recipesSet = new HashSet<>(List.of(recipes)); // store our supplies
        // make graph and nodes in&out degrees
        HashMap<String, List<String>> adj = new HashMap<>();            // store our graph
        HashMap<String, Integer> inDegree = new HashMap<>();            // stores all String inDegree
        HashMap<String, Integer> outDegree = new HashMap<>();           // stores all String outDegree

        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
            outDegree.put(recipe, 0);
        }

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
            if (inDegree.getOrDefault(u, 0) == 0 && recipesSet.contains(u)) {
                ans.add(u);
            }
            if (inDegree.getOrDefault(u, 0) == 0 && outDegree.getOrDefault(u, 0) == 0 && !suppliesSet.contains(u)) {
                break;
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

    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich", "burger"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));
        String[] supplies = {"yeast", "flour", "meat"};

        var obj = new FindAllRecipes_2115_topological_tbd();
        List<String> ans = obj.findAllRecipes(recipes, ingredients, supplies);
        System.out.println("ans = " + ans);
    }
}