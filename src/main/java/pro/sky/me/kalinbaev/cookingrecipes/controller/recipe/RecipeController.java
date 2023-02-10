package pro.sky.me.kalinbaev.cookingrecipes.controller.recipe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok().body(recipe);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> readRecipeById(@PathVariable int recipeId) {
        return ResponseEntity.of(recipeService.getRecipeById(recipeId));
    }

    @GetMapping("/")
    public ResponseEntity<Map<Integer, Recipe>> readAllRecipes() {
        return ResponseEntity.ok(recipeService.readAllRecipes());
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<Recipe> updateRecipeById(@PathVariable int recipeId,
                                                   @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.updateRecipeById(recipeId, recipe));
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Recipe> deleteRecipeById(@PathVariable int recipeId) {
        return ResponseEntity.ok(recipeService.deleteRecipeById(recipeId));
    }
}
