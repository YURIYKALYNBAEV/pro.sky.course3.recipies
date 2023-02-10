package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private final ValidationService validationService;

    public IngredientServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.put(ingredientId++, ingredient);
    }

    @Override
    public Optional<Ingredient> getIngredientById(int ingredientId) {
        return Optional.ofNullable(ingredientMap.get(ingredientId));
    }

    @Override
    public Map<Integer, Ingredient> readAllIngredients() {
        return ingredientMap;
    }

    @Override
    public Ingredient updateIngredientById(int ingredientId, Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredientMap.replace(ingredientId, ingredient);
    }

    @Override
    public Ingredient deleteIngredientById(int ingredientId) {
        return ingredientMap.remove(ingredientId);
    }
}
