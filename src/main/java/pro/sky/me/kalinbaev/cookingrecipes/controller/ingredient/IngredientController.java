package pro.sky.me.kalinbaev.cookingrecipes.controller.ingredient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body(ingredient);
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> readIngredientById(@PathVariable int ingredientId) {
        return ResponseEntity.of(ingredientService.getIngredientById(ingredientId));
    }

    @GetMapping("/")
    public ResponseEntity<Map<Integer, Ingredient>> readAllIngredients() {
        return ResponseEntity.ok(ingredientService.readAllIngredients());
    }

    @PutMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredientById(@PathVariable int ingredientId,
                                                           @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.updateIngredientById(ingredientId, ingredient));
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> deleteIngredientById(@PathVariable int ingredientId) {
        return ResponseEntity.ok(ingredientService.deleteIngredientById(ingredientId));
    }


}
