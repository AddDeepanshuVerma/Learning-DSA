package POTD_LEETCODE.Graph;

import java.util.*;

class FindAllRecipes_2115_optimal {

    // proper Topological sorting
    /*TOPOLOGICAL SORT : A really smart question based on this sorting is there on leetcode: 2115, Here even to identify that "it is a graph question
    and being a directed graph can be solved using topological sort" is hard.
    Here problems where, the one node depends on another and that another can be dependent of any other can be solved if we are ale top write the
    Topological sorted order of all of those node(here we start bfs with those nodes that has no dependency or has indegree == 0).
    And every other node that we go through, for this topological order to be created, is a reachable node. Rest those were not reachable must be
    in some kind of cycle and topological order does not contain cycle, hence only valid node will be there.*/
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String u = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                String v = ingredient;
                adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
            }
            indegree.merge(u, ingredients.get(i).size(), Integer::sum); // v is pointing towards u hence indegree of u increases by no of v
        }

        // apply topological sorting
        // step 1: insert all supplies whose indegree is == 0
        ArrayDeque<String> q = new ArrayDeque<>();
        for (String supply : supplies) {
            int val = indegree.getOrDefault(supply, 0);
            if (val == 0) {
                q.offer(supply);
            }
        }
        // now we will do a BFS where we'll start with these 0 inDegrees source and explore those whose inDegrees also gets equal to zero
        HashSet<String> distinctStrings = new HashSet<>();
        while (!q.isEmpty()) {
            String u = q.poll();
            distinctStrings.add(u);

            for (String v : adj.getOrDefault(u, Collections.emptyList())) {
                int val = indegree.merge(v, -1, Integer::sum);
                if (val == 0) {
                    q.offer(v);
                }
            }
        }
        // now distinctStrings contains all string to which we can reach vai given supplies
        // hence simple search which of our recipes are there in distinctStrings will be reachable
        List<String> ans = new ArrayList<>();
        for (String recipe : recipes) {
            if (distinctStrings.contains(recipe)) {
                ans.add(recipe);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};

        var obj = new FindAllRecipes_2115_optimal();
        List<String> ans = obj.findAllRecipes(recipes, ingredients, supplies);
        System.out.println("ans = " + ans);
    }
}