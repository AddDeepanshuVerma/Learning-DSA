package POTD_LEETCODE.Graph;

import java.util.*;

class FindAllRecipes_2115_optimal_2 {

    //Topological sorting + initially we can add all supplies in queue, no need to check
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
        // step 1: insert all supplies whose indegree is == 0,
        // here all supplies will always have indegree == 0, hence we can add all supplies in here
        ArrayDeque<String> q = new ArrayDeque<>(List.of(supplies));

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
//        return Arrays.stream(recipes).filter(distinctStrings::contains).toList();
        return ans;
    }

    public static void main(String[] args) {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};

        var obj = new FindAllRecipes_2115_optimal_2();
        List<String> ans = obj.findAllRecipes(recipes, ingredients, supplies);
        System.out.println("ans = " + ans);
    }
}