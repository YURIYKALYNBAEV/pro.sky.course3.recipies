package pro.sky.me.kalinbaev.cookingrecipes.services;

import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;

public interface RecipeService {
    int addRecipe(Recipe recipe);

    Recipe getRecipe(int id);
}
