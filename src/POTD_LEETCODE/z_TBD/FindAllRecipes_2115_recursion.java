package POTD_LEETCODE.z_TBD;

import jdk.jfr.Description;

import java.util.*;

@Description("Wrong approach, does not work!!!!")
class FindAllRecipes_2115_recursion {

    private HashSet<String> canBeCreated;
    private HashSet<String> supplies_set;
    private HashMap<String, Integer> recipes_hashMap;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        supplies_set = new HashSet<>(List.of(supplies));    // stores all supplies we have
        recipes_hashMap = new HashMap<>();                  // stores all recipes with their index value
        for (int i = 0; i < recipes.length; i++) recipes_hashMap.put(recipes[i], i);

        canBeCreated = new HashSet<>();                     // will contain everything that can be created

        // check either this recipe is there in updated canBeCreated HashSet otherwise
        // run a dfs on all its required ingredients & is they are available this recipe can be created
        for (int i = 0; i < recipes.length; i++) {
            if (canBeCreated.contains(recipes[i])) continue;
            dfs(i, ingredients.get(i), ingredients, recipes);
        }

        List<String> ans = new ArrayList<>();
        for (String recipe : recipes) {
            if (canBeCreated.contains(recipe)) {
                ans.add(recipe);
            }
        }
        return ans;
    }

    private boolean dfs(int i, List<String> requiredIngredient, List<List<String>> ingredients, String[] recipes) {
        for (String ingredient : requiredIngredient) {
            if (supplies_set.contains(ingredient)) {
                continue;
            } else if (recipes_hashMap.containsKey(ingredient)) {
                int index = recipes_hashMap.get(ingredient);
                if (i != index && dfs(index, ingredients.get(index), ingredients, recipes)) {
                    canBeCreated.add(ingredient);
                    continue;
                }
            } else {
                return false;
            }
        }
        canBeCreated.add(recipes[i]);
        return true;
    }
}