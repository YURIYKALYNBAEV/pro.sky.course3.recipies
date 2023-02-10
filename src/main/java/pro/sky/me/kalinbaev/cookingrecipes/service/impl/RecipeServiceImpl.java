package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int recipeId = 1;
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private final ValidationService validationService;

    public RecipeServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipeMap.put(recipeId++, recipe);
    }

    @Override
    public Optional<Recipe> getRecipeById(int recipeId) {
        return Optional.ofNullable(recipeMap.get(recipeId));
    }

    @Override
    public Map<Integer, Recipe> readAllRecipes() {
        return recipeMap;
    }

    @Override
    public Recipe updateRecipeById(int recipeId, Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        return recipeMap.replace(recipeId, recipe);
    }

    @Override
    public Recipe deleteRecipeById(int recipeId) {
        return recipeMap.remove(recipeId);
    }
}
