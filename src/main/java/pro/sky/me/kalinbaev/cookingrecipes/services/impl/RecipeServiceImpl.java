package pro.sky.me.kalinbaev.cookingrecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int recipeId = 1;
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();

    @Override
    public int addRecipe(Recipe recipe) {
        recipeMap.put(recipeId++, recipe);
        return recipeId;
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        Recipe recipe = recipeMap.get(recipeId);
        if (recipe != null) {
            return recipe;
        }
        return null;
    }

    @Override
    public Recipe readAllRecipes() {
        for (Recipe recipe : recipeMap.values()) {
            if (recipe != null) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
        if (recipeMap.get(recipeId) != null) {
            recipeMap.put(recipeId, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int recipeId) {
        if (recipeMap.get(recipeId) != null) {
            recipeMap.remove(recipeId);
            return true;
        }
        return false;
    }
}
