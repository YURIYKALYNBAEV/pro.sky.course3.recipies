package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int recipeId = 1;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private final ValidationService validationService;
    private FilesServiceImpl filesService;

    public RecipeServiceImpl(ValidationService validationService, FilesServiceImpl filesService) {
        this.validationService = validationService;
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        saveToFile();
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
        saveToFile();
        return recipeMap.replace(recipeId, recipe);
    }

    @Override
    public Recipe deleteRecipeById(int recipeId) {
        return recipeMap.remove(recipeId);
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesService.saveToFileRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFileRecipe();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
