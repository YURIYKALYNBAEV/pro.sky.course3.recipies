package pro.sky.me.kalinbaev.cookingrecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private static Map<Integer, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientMap.put(ingredientId++, ingredient);
    }

    @Override
    public Ingredient getIngredient(int ingredientId) {
        return ingredientMap.get(ingredientId);
    }
}
