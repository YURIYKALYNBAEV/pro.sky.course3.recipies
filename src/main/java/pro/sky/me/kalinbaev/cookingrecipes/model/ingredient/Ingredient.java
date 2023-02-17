package pro.sky.me.kalinbaev.cookingrecipes.model.ingredient;

import lombok.*;

/**
 * Сущность: Ингредиент
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;

    @Override
    public String toString() {
        return " • " + name + " - " + count + " " + measureUnit;
    }
}