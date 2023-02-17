package pro.sky.me.kalinbaev.cookingrecipes.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public interface FilesService {

    <T> void saveMapToFile(Map<Integer, T> map, Path path);

    <T> Map<Integer, T> readMapFromFile(Path path, TypeReference<HashMap<Integer, T>> typeReference);


    void uploadFile(MultipartFile file, Path filePath) throws IOException;

    Path saveToFile(String content, Path path) throws IOException;
}
