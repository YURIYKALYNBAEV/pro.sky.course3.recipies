package pro.sky.me.kalinbaev.cookingrecipes.services;

import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;

public interface IngredientService {
    int addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);

    Ingredient readAllIngredients();

    Ingredient updateIngredient(int ingredientId, Ingredient ingredient);

    boolean deleteIngredient(int ingredientId);
}
