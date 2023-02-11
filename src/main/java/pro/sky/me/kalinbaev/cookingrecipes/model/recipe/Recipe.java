package pro.sky.me.kalinbaev.cookingrecipes.model.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import java.util.List;

/**
 * Сущность: Рецепт
 */
@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private int cookingTime;
    private int numberOfServings;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructions;
}