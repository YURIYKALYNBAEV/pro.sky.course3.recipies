package pro.sky.me.kalinbaev.cookingrecipes.service;

public interface FilesService {

    boolean saveToFileIngredient(String json);

    String readFromFileIngredient();

    boolean cleanDataFileIngredient();

    boolean saveToFileRecipe(String json);

    String readFromFileRecipe();

    boolean cleanDataFileRecipe();
}
