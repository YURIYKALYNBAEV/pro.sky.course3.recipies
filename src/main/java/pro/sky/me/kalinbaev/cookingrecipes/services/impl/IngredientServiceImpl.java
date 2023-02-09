package pro.sky.me.kalinbaev.cookingrecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private static Map<Integer, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public int addIngredient(Ingredient ingredient) {
        ingredientMap.put(ingredientId++, ingredient);
        return ingredientId;
    }

    @Override
    public Ingredient getIngredient(int ingredientId) {
        for (Ingredient ingredient : ingredientMap.values()) {
            Ingredient ingredients = ingredientMap.get(ingredientId);
            if (ingredients != null) {
                return ingredients;
            }
        }
        return null;
    }
}
