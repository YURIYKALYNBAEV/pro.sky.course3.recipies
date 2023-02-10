package pro.sky.me.kalinbaev.cookingrecipes.service.impl;

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
                && recipe.getCookingInstructions() != null
                && recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty()
                && !recipe.getCookingInstructions().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null
                && ingredient.getCount() >= 0
                && ingredient.getMeasureUnit() != null;
    }
}
