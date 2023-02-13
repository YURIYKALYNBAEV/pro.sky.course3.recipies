package pro.sky.me.kalinbaev.cookingrecipes.model.ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность: Ингредиент
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;
}
