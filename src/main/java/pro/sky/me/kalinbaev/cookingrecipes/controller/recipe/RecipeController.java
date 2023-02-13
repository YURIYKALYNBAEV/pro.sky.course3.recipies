package pro.sky.me.kalinbaev.cookingrecipes.controller.recipe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.me.kalinbaev.cookingrecipes.model.recipe.Recipe;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name = "API для работы с рецептом", description = "CRUD-операции для рецепта")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(
            summary = "Создание рецепта"
    )
    @PostMapping("/")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "всё хорошо, запрос выполнился"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "есть ошибка в параметрах запроса"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия нет в веб-приложении"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "во время выполнения запроса произошла ошибка на сервере"
            )
    })
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }

    @Operation(
            summary = "Чтение рецепта по идентификатору"
    )
    @GetMapping("/{recipeId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "всё хорошо, запрос выполнился"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "есть ошибка в параметрах запроса"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия нет в веб-приложении"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "во время выполнения запроса произошла ошибка на сервере"
            )
    })
    public ResponseEntity<Recipe> readRecipeById(@PathVariable int recipeId) {
        return ResponseEntity.of(recipeService.getRecipeById(recipeId));
    }

    @Operation(
            summary = "Чтение списка рецептов"
    )
    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "всё хорошо, запрос выполнился"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "есть ошибка в параметрах запроса"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия нет в веб-приложении"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "во время выполнения запроса произошла ошибка на сервере"
            )
    })
    public ResponseEntity<Map<Integer, Recipe>> readAllRecipes() {
        return ResponseEntity.ok(recipeService.readAllRecipes());
    }

    @Operation(
            summary = "Обновление рецепта по идентификатору"
    )
    @PutMapping("/{recipeId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "всё хорошо, запрос выполнился"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "есть ошибка в параметрах запроса"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия нет в веб-приложении"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "во время выполнения запроса произошла ошибка на сервере"
            )
    })
    public ResponseEntity<Recipe> updateRecipeById(@PathVariable int recipeId,
                                                   @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.updateRecipeById(recipeId, recipe));
    }

    @Operation(
            summary = "Удаление рецепта по идентификатору"
    )
    @DeleteMapping("/{recipeId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "всё хорошо, запрос выполнился"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "есть ошибка в параметрах запроса"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия нет в веб-приложении"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "во время выполнения запроса произошла ошибка на сервере"
            )
    })
    public ResponseEntity<Recipe> deleteRecipeById(@PathVariable int recipeId) {
        return ResponseEntity.ok(recipeService.deleteRecipeById(recipeId));
    }
}
