package pro.sky.me.kalinbaev.cookingrecipes.service;

import java.io.File;

public interface FilesService {

    boolean saveToFileIngredient(String json);

    String readFromFileIngredient();

    boolean cleanDataFileIngredient();

    boolean saveToFileRecipe(String json);

    String readFromFileRecipe();

    boolean cleanDataFileRecipe();
    File getDataFileRecipe();

    File getDataFileIngredient();
}
