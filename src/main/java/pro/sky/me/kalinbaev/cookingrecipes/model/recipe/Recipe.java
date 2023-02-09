package pro.sky.me.kalinbaev.cookingrecipes.model.recipe;

import pro.sky.me.kalinbaev.cookingrecipes.model.ingredient.Ingredient;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private int cookingTime;
    private int numberOfServings;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> cookingInstructions = new ArrayList<>();

    public Recipe(String name,
                  int cookingTime,
                  int numberOfServings) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.numberOfServings = numberOfServings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("название рецепта");
        }
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime < 0) {
            this.cookingTime = cookingTime;
        } else {
            throw new IllegalArgumentException("время приготовления");
        }
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        if (numberOfServings < 1) {
            this.numberOfServings = numberOfServings;
        } else {
            throw new IllegalArgumentException("количество порций");
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public void addIngredients(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addCookingInstructions(String instruction) {
        cookingInstructions.add(instruction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime
                && numberOfServings == recipe.numberOfServings
                && Objects.equals(name, recipe.name)
                && Objects.equals(ingredients, recipe.ingredients)
                && Objects.equals(cookingInstructions, recipe.cookingInstructions);
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