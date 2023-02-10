package pro.sky.me.kalinbaev.cookingrecipes.service;

import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;

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
}
