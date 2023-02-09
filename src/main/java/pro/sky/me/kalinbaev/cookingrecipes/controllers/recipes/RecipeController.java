package pro.sky.me.kalinbaev.cookingrecipes.controllers.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createRecipe(@RequestBody Recipe recipe) {
        int recipeId = recipeService.addRecipe(recipe);
        return ResponseEntity.ok().body(recipeId);
    }

    @GetMapping("/read/{recipeId}")
    public ResponseEntity<Recipe> readRecipeById(@PathVariable int recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
