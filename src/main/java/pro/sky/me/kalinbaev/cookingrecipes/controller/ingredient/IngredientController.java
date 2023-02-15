package pro.sky.me.kalinbaev.cookingrecipes.controller.ingredient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "API для работы с ингредиентом", description = "CRUD-операции для ингредиента")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(
            summary = "Создание ингредиента"
    )
    @PostMapping("/")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Игредиент создан успешно."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка в параметрах запроса"
            )
    })
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @Operation(
            summary = "Чтение ингредиента по идентификатору"
    )
    @GetMapping("/{ingredientId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Чтение ингредиента завершено успешно"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Не найден запрашиваемый ресурс"
            )
    })
    public ResponseEntity<Ingredient> readIngredientById(@PathVariable int ingredientId) {
        return ResponseEntity.of(ingredientService.getIngredientById(ingredientId));
    }

    @Operation(
            summary = "Чтение списка ингредиентов"
    )
    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Чтение списка ингредиентов выполнено успешно"
            )
    })
    public ResponseEntity<Map<Integer, Ingredient>> readAllIngredients() {
        return ResponseEntity.ok(ingredientService.readAllIngredients());
    }

    @Operation(
            summary = "Обновление ингредиента по идентификатору"
    )
    @PutMapping("/{ingredientId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Обновление ингредиента завершено успешно"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка в параметрах запроса"
            )
    })
    public ResponseEntity<Ingredient> updateIngredientById(@PathVariable int ingredientId,
                                                           @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.updateIngredientById(ingredientId, ingredient));
    }

    @Operation(
            summary = "Удаление ингредиента по идентификатору"
    )
    @DeleteMapping("/{ingredientId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Удаление ингредиента завершено успешно"
            )
    })
    public ResponseEntity<Void> deleteIngredientById(@PathVariable int ingredientId) {
        if (ingredientService.deleteIngredientById(ingredientId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
