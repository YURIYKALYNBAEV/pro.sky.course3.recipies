package pro.sky.me.kalinbaev.cookingrecipes.services;

import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;

public interface IngredientService {
    int addIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);
}
