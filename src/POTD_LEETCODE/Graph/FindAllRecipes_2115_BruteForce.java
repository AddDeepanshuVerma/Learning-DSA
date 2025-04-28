package POTD_LEETCODE.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class FindAllRecipes_2115_BruteForce {

    //Brute force approach
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashSet<String> suppliesSet = new HashSet<>(List.of(supplies));
        HashSet<String> unique = new HashSet<>();

        while (n-- > 0) {
            outer:
            for (int i = 0; i < recipes.length; i++) {
                for (String ingredient : ingredients.get(i)) {
                    if (!suppliesSet.contains(ingredient)) {
                        continue outer;
                    }
                }
                unique.add(recipes[i]);
                suppliesSet.add(recipes[i]);
            }
        }
        return new ArrayList<>(unique);
    }

    //Brute force approach + slight improvement
    public List<String> findAllRecipes2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashSet<String> suppliesSet = new HashSet<>(List.of(supplies));
        boolean[] recipeCreated = new boolean[n];
        List<String> ans = new ArrayList<>();

        while (n-- > 0) {
            outer:
            for (int i = 0; i < recipes.length; i++) {
                if (recipeCreated[i]) continue;// this recipe has already been created hence no need to explore
                for (String ingredient : ingredients.get(i)) {
                    if (!suppliesSet.contains(ingredient)) {
                        continue outer;
                    }
                }
                recipeCreated[i] = true; // this recipe was created just now hence mark true, put in recipes list and in answerList as well
                ans.add(recipes[i]);
                suppliesSet.add(recipes[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] recipes = {"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        String[] supplies = {"yeast", "flour", "corn"};

        var obj = new FindAllRecipes_2115_BruteForce();
        List<String> ans = obj.findAllRecipes2(recipes, ingredients, supplies);
        System.out.println("ans = " + ans);
    }
}