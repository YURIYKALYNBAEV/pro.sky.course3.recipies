package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.service.FilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.file.ingredients}")
    private String dataFilePathIngredient;
    @Value("${path.to.file.recipes}")
    private String dataFilePathRecipe;
    @Value("${file.name.ingredients}")
    private String dataFileNameIngredient;
    @Value("${file.name.recipes}")
    private String dataFileNameRecipe;


    @Override
    public boolean saveToFileIngredient(String json) {
        Path filePathIngredient = Path.of(dataFilePathIngredient, dataFileNameIngredient);
        try {
            cleanDataFileIngredient();
            Files.writeString(filePathIngredient, json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFileIngredient() {
        Path filePathIngredient = Path.of(dataFilePathIngredient, dataFileNameIngredient);
        try {
            return Files.readString(filePathIngredient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFileIngredient() {
        Path filePathIngredient = Path.of(dataFilePathIngredient, dataFileNameIngredient);
        try {
            Files.deleteIfExists(filePathIngredient);
            Files.createFile(filePathIngredient);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveToFileRecipe(String json) {
        Path filePathRecipe = Path.of(dataFilePathRecipe, dataFileNameRecipe);
        try {
            cleanDataFileRecipe();
            Files.writeString(filePathRecipe, json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromFileRecipe() {
        Path filePathRecipe = Path.of(dataFilePathRecipe, dataFileNameRecipe);
        try {
            return Files.readString(filePathRecipe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFileRecipe() {
        Path filePathRecipe = Path.of(dataFilePathRecipe, dataFileNameRecipe);
        try {
            Files.deleteIfExists(filePathRecipe);
            Files.createFile(filePathRecipe);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
