package pro.sky.me.kalinbaev.cookingrecipes.model.recipe;

import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Сущность: Рецепт
 */

public class Recipe {
    private String name;
    private int cookingTime;
    private int numberOfServings;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> cookingInstructions = new ArrayList<>();

    public Recipe(String name, int cookingTime, int numberOfServings, List<Ingredient> ingredients, List<String> cookingInstructions) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.numberOfServings = numberOfServings;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(List<String> cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime && numberOfServings == recipe.numberOfServings && Objects.equals(name, recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(cookingInstructions, recipe.cookingInstructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cookingTime, numberOfServings, ingredients, cookingInstructions);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", cookingTime=" + cookingTime +
                ", numberOfServings=" + numberOfServings +
                ", ingredients=" + ingredients +
                ", cookingInstructions=" + cookingInstructions +
                '}';
    }
}