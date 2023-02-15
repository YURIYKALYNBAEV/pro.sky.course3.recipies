package pro.sky.me.kalinbaev.cookingrecipes.controller.files;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.me.kalinbaev.cookingrecipes.service.FilesService;

import java.io.*;

@RestController
@RequestMapping("/files")
@Tag(name = "API для работы с файлами", description = "Операции выгрузки-загрузки для файлов")
public class FilesController {
    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping("/export/recipe")
    @Operation(
            summary = "Выгрузка рецептов в json-файл"
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

    public ResponseEntity<InputStreamResource> downLoadDataFile() throws FileNotFoundException {
        File fileIn = filesService.getDataFileRecipe();
        if (fileIn.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(fileIn));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(fileIn.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; " +
                            "filename=\"RecipeLog.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка рецептов из json-файла"
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
    public ResponseEntity<Void> upLoadDataFileRecipe(@RequestParam MultipartFile file) {
        filesService.cleanDataFileRecipe();
        File dataFile = filesService.getDataFileRecipe();

        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/import/ingredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка ингредиентов из json-файла"
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
    public ResponseEntity<Void> upLoadDataFileIngredient(@RequestParam MultipartFile file) {
        filesService.cleanDataFileIngredient();
        File dataFile = filesService.getDataFileIngredient();

        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
