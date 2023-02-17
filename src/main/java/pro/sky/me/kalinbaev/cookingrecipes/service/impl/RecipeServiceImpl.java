package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.FilesService;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private static int recipeId = 1;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private final ValidationService validationService;
    private final FilesService filesService;
    @Value("${path.to.file.recipes}")
    private String dataFilePathRecipe;
    @Value("${file.name.recipes}")
    private String dataFileNameResipe;
    @Value("${file.name.txt.recipes}")
    private String dataTxtFileNameResipe;

    private Path recipePath;


    @PostConstruct
    private void init() {
        recipePath = Path.of(dataFilePathRecipe, dataFileNameResipe);
        recipeMap = filesService.readMapFromFile(recipePath, new TypeReference<HashMap<Integer, Recipe>>() {
        });
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipeMap.put(recipeId++, recipe);
        filesService.saveMapToFile(recipeMap, recipePath);
        return recipe;
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
        recipeMap.replace(recipeId, recipe);
        filesService.saveMapToFile(recipeMap, recipePath);
        return recipe;
    }

    @Override
    public Recipe deleteRecipeById(int recipeId) {
        Recipe recipe = recipeMap.remove(recipeId);
        filesService.saveMapToFile(recipeMap, recipePath);
        return recipe;
    }

    @Override
    public File readFile() {
        return recipePath.toFile();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        filesService.uploadFile(file, recipePath);
        recipeMap = filesService.readMapFromFile(recipePath, new TypeReference<HashMap<Integer, Recipe>>() {
        });
    }

    @Override
    public File prepareRecipesTxt() throws IOException {
        return filesService
                .saveToFile(recipesToString(), Path.of(dataFilePathRecipe, dataTxtFileNameResipe))
                .toFile();
    }

    private String recipesToString() {
        StringBuilder sb = new StringBuilder();
        int nom = 1;
        for (Recipe recipe : recipeMap.values()
        ) {
            sb.append("\n").append(recipe.toString()).append("\n");

            sb.append("\nИнгредиенты:\n");
            for (Ingredient ingredient : recipe.getIngredients()
            ) {
                sb.append(ingredient.toString()).append("\n");
            }

            sb.append("\nИнструкция приготовления:\n");
            for (String step : recipe.getCookingInstructions()
            ) {
                sb.append(nom + " " + step).append("\n");
            }
        }
        return sb.append("\n").toString();
    }
}
