package pro.sky.me.kalinbaev.cookingrecipes.controllers.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.services.IngredientService;
import pro.sky.me.kalinbaev.cookingrecipes.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe/creating")
    public ResponseEntity createIngredient(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/recipe/read")
    public ResponseEntity getUser(@RequestParam int recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        return recipe != null
                ? new ResponseEntity<>(recipe, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
