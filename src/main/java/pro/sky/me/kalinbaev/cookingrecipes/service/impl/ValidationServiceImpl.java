package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getName() != null
                && !StringUtils.isEmpty(recipe.getName())
                && recipe.getCookingInstructions() != null
                && !recipe.getCookingInstructions().isEmpty()
                && recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty();

    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null
                && !StringUtils.isEmpty(ingredient.getName())
                && ingredient.getCount() >= 0
                && ingredient.getMeasureUnit() != null;
    }
}
