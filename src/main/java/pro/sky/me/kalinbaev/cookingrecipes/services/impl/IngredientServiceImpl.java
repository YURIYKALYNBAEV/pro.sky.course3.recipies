package pro.sky.me.kalinbaev.cookingrecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public int addIngredient(Ingredient ingredient) {
        ingredientMap.put(ingredientId++, ingredient);
        return ingredientId;
    }

    @Override
    public Ingredient getIngredient(int ingredientId) {
        Ingredient ingredient = ingredientMap.get(ingredientId);
        if (ingredient != null) {
            return ingredient;
        }
        return null;
    }

    @Override
    public Ingredient readAllIngredients() {
        for (Ingredient ingredient : ingredientMap.values()) {
            if (ingredient != null) {
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public Ingredient updateIngredient(int ingredientId, Ingredient ingredient) {
        if (ingredientMap.get(ingredientId) != null) {
            ingredientMap.put(ingredientId, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int ingredientId) {
        if (ingredientMap.get(ingredientId) != null) {
            ingredientMap.remove(ingredientId);
            return true;
        }
        return false;
    }


}
