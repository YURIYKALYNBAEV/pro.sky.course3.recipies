package pro.sky.me.kalinbaev.cookingrecipes.exception;

/**
 * ошибка валидации
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String entity) {
        super("Ошибка валидации сущности: " + entity);
    }

}
