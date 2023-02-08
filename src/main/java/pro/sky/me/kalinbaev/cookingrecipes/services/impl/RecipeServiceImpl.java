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
    public void addRecipe(Recipe recipe) {
        recipeMap.put(recipeId++, recipe);
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        return recipeMap.get(recipeId);
    }
}
