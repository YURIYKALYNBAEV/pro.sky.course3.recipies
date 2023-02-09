package pro.sky.me.kalinbaev.cookingrecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int recipeId = 1;
    private static Map<Integer, Recipe> recipeMap = new HashMap<>();

    @Override
    public int addRecipe(Recipe recipe) {
        recipeMap.put(recipeId++, recipe);
        return recipeId;
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        for (Recipe recipe : recipeMap.values()) {
            Recipe recipes = recipeMap.get(recipeId);
            if (recipes != null) {
                return recipes;
            }
        }
        return null;
    }
}
