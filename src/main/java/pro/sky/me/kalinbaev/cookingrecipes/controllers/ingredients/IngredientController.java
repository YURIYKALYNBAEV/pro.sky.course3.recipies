package pro.sky.me.kalinbaev.cookingrecipes.controllers.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.services.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Integer> createIngredient(@RequestBody Ingredient ingredient) {
        int ingredientId =  ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body(ingredientId);
    }
    @GetMapping(value = "/read/{ingredientId}")
    public ResponseEntity<Ingredient> readIngredientById(@PathVariable int ingredientId) {
        Ingredient ingredient = ingredientService.getIngredient(ingredientId);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

}
