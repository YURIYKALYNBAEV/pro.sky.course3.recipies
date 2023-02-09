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
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/read")
    public ResponseEntity<Ingredient> readIngredientById(@RequestParam int ingredientId) {
        Ingredient ingredient = ingredientService.getIngredient(ingredientId);
        return ingredient != null
                ? new ResponseEntity<>(ingredient, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
