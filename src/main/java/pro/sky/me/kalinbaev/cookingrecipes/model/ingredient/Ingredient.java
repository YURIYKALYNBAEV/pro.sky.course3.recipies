package pro.sky.me.kalinbaev.cookingrecipes.model.ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Сущность: Ингредиент
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;
}
