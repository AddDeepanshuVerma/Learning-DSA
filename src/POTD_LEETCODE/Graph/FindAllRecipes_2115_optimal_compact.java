package POTD_LEETCODE.Graph;

import java.util.*;

class FindAllRecipes_2115_optimal_compact {

    // Topological sort + using Stream API to get answer list
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String u = recipes[i];
            for (String v : ingredients.get(i)) {
                adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
            }
            indegree.merge(u, ingredients.get(i).size(), Integer::sum);
        }

        ArrayDeque<String> q = new ArrayDeque<>(List.of(supplies));
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
        return Arrays.stream(recipes).filter(distinctStrings::contains).toList();
    }

    public static void main(String[] args) {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};

        var obj = new FindAllRecipes_2115_optimal_compact();
        List<String> ans = obj.findAllRecipes(recipes, ingredients, supplies);
        System.out.println("ans = " + ans);
    }
}