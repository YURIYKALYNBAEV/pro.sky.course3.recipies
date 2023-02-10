package pro.sky.me.kalinbaev.cookingrecipes.service;

import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;

/**
 * Сервис валидации
 */
public interface ValidationService {

    /**
     * Валидация рецепта
     *
     * @param recipe рецепт для валидации
     * @return true - рецепт корректный
     */
    public boolean validate(Recipe recipe);

    /**
     * Валидация ингредиента
     *
     * @param ingredient ингредиент для валидации
     * @return true - ингредиент корректный
     */
    public boolean validate(Ingredient ingredient);
}
