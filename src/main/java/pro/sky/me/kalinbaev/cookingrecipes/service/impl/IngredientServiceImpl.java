package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();
    private final ValidationService validationService;
    private final FilesServiceImpl filesService;

    public IngredientServiceImpl(ValidationService validationService, FilesServiceImpl filesService) {
        this.validationService = validationService;
        this.filesService = filesService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        ingredientMap.put(ingredientId++, ingredient);
        saveToFile();
        return ingredientMap.get(ingredientId);
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
        ingredientMap.replace(ingredientId, ingredient);
        saveToFile();
        return ingredientMap.get(ingredientId);
    }

    @Override
    public Ingredient deleteIngredientById(int ingredientId) {
        ingredientMap.remove(ingredientId);
        saveToFile();
        return ingredientMap.get(ingredientId);
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            filesService.saveToFileIngredient(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFileIngredient();
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
