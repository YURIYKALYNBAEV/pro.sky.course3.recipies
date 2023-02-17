package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.exception.ValidationException;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.service.FilesService;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private static int ingredientId = 1;
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private final ValidationService validationService;
    private final FilesService filesService;
    @Value("${path.to.file.ingredients}")
    private String dataFilePathIngredient;
    @Value("${file.name.ingredients}")
    private String dataFileNameIngredient;
    private Path ingredientPath;


    @PostConstruct
    private void init() {
        ingredientPath = Path.of(dataFilePathIngredient, dataFileNameIngredient);
        ingredientMap = filesService.readMapFromFile(ingredientPath, new TypeReference<HashMap<Integer, Ingredient>>() {
        });
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        ingredientMap.put(ingredientId++, ingredient);
        filesService.saveMapToFile(ingredientMap, ingredientPath);
        return ingredient;
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
        filesService.saveMapToFile(ingredientMap, ingredientPath);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredientById(int ingredientId) {
        Ingredient ingredient = ingredientMap.remove(ingredientId);
        filesService.saveMapToFile(ingredientMap, ingredientPath);
        return ingredient;
    }

    @Override
    public File readFile() {
        return ingredientPath.toFile();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        filesService.uploadFile(file, ingredientPath);
        ingredientMap = filesService.readMapFromFile(ingredientPath, new TypeReference<HashMap<Integer, Ingredient>>() {
        });
    }
}
