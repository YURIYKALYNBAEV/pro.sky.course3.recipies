package pro.sky.me.kalinbaev.cookingrecipes.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Сервис для работы с ингредиентами
 */

public interface IngredientService {
    /**
     * Добавить ингредиент
     *
     * @param ingredient ингредиент для добавления
     * @return добавленный ингредиент
     */
    Ingredient addIngredient(Ingredient ingredient);

    /**
     * Получение ингредиента по id
     *
     * @param ingredientId идентификатор ингредиента
     * @return ингредиент
     */
    Optional<Ingredient> getIngredientById(int ingredientId);

    /**
     * Получение полного списка ингредиентов
     *
     * @return список ингредиентов
     */
    Map<Integer, Ingredient> readAllIngredients();

    /**
     * редактирование ингредиента
     *
     * @param ingredientId идентификатор
     * @param ingredient   ингредиент
     * @return отредактированный ингредиент
     */
    Ingredient updateIngredientById(int ingredientId, Ingredient ingredient);

    /**
     * Удаление ингредиента по id
     *
     * @param ingredientId идентификатор
     * @return удаленный ингредиент
     */
    Ingredient deleteIngredientById(int ingredientId);

    /**
     * Чтение файла ингредиентов
     * @return файл ингредиентов
     */
    File readFile();

    /**
     * Загрузка файла ингредиентов
     * @param file файл ингредиентов
     * @throws IOException
     */
    void uploadFile(MultipartFile file) throws IOException;
}
