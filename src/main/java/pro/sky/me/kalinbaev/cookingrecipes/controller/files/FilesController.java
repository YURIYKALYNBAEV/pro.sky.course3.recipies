package pro.sky.me.kalinbaev.cookingrecipes.controller.files;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.service.IngredientService;
import pro.sky.me.kalinbaev.cookingrecipes.service.RecipeService;

import java.io.*;

@RestController
@RequestMapping("/files")
@Tag(name = "API для работы с файлами", description = "Операции выгрузки-загрузки для файлов")
@RequiredArgsConstructor
public class FilesController {
    private RecipeService recipeService;
    private IngredientService ingredientService;

    @GetMapping("/recipe/export")
    @Operation(
            summary = "Выгрузка файла рецептов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Выгрузка в файл прошла успешно."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Не найден запрашиваемый ресурс"
            )
    })

    public ResponseEntity<InputStreamResource> downloadRecipesFile() {
        try {
            File fileRecipes = recipeService.readFile();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(fileRecipes));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(fileRecipes.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
                            fileRecipes.getName())
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/recipe/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла рецептов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Загрузка из файла прошла успешно."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Превышен размер загружаемого файла"
            )
    })
    public ResponseEntity<String> uploadRecipesFile(@RequestParam MultipartFile file) {
        try {
            recipeService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла." +
                    " Проверьте корректность файла");
        }
    }

    @PostMapping(value = "/ingredient/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла ингредиентов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Загрузка из файла прошла успешно."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Превышен размер загружаемого файла"
            )
    })
    public ResponseEntity<String> uploadIngredientsFile(@RequestParam MultipartFile file) {
        try {
            ingredientService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла." +
                    " Проверьте корректность файла");
        }
    }

    @GetMapping("/recipe/export/txt")
    @Operation(
            summary = "Выгрузка файла рецептов в формате txt"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Выгрузка в файл прошла успешно."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Не найден запрашиваемый ресурс"
            )
    })

    public ResponseEntity<InputStreamResource> downloadRecipesTxtFile() {
        try {
            File recipesFile = recipeService.prepareRecipesTxt();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(recipesFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(recipesFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +
                            recipesFile.getName())
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
}
