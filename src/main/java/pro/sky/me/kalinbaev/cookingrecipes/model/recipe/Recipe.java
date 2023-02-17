package pro.sky.me.kalinbaev.cookingrecipes.model.recipe;

import lombok.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import java.util.List;

/**
 * Сущность: Рецепт
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private int cookingTime;
    private int numberOfServings;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructions;

    @Override
    public String toString() {
        return name +
                "\n Время приготовления: " + cookingTime + " минут." +
                "\n Количество порций: " + numberOfServings;
    }
}