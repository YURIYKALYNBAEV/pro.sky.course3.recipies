package pro.sky.me.kalinbaev.cookingrecipes.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Сервис для работы с рецептами
 */

public interface RecipeService {
    /**
     * Добавить рецепт
     *
     * @param recipe рецепт для добавления
     * @return добавленный рецепт
     */
    Recipe addRecipe(Recipe recipe);

    /**
     * Получение рецепта по id
     *
     * @param recipeId идентификатор ингредиента
     * @return ингредиент
     */

    Optional<Recipe> getRecipeById(int recipeId);

    /**
     * Получение полного списка рецептов
     *
     * @return список рецептов
     */
    Map<Integer, Recipe> readAllRecipes();

    /**
     * редактирование ингредиента
     *
     * @param recipeId идентификатор
     * @param recipe   ингредиент
     * @return отредактированный ингредиент
     */
    Recipe updateRecipeById(int recipeId, Recipe recipe);

    /**
     * Удаление ингредиента по id
     *
     * @param recipeId идентификатор
     * @return удаленный ингредиент
     */


    Recipe deleteRecipeById(int recipeId);

    /**
     * Чтение файла рецептов
     * @return файл рецептов
     */
    File readFile();

    /**
     * Загрузка файла рецептов
     * @param file файл рецептов
     * @throws IOException
     */
    void uploadFile(MultipartFile file) throws IOException;

    File prepareRecipesTxt() throws IOException;
}
