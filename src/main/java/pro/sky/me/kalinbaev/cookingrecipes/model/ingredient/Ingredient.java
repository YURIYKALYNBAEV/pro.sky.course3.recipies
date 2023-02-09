package pro.sky.me.kalinbaev.cookingrecipes.model.ingredient;

import java.util.Objects;

public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;

    public Ingredient(String name, int count, String measureUnit) {
        this.name = name;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("название ингредиента");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("количество");
        }
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        if (measureUnit != null && !measureUnit.isEmpty()) {
            this.measureUnit = measureUnit;
        } else {
            throw new IllegalArgumentException("единица измерения");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return count == that.count && Objects.equals(name, that.name) && Objects.equals(measureUnit, that.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, measureUnit);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", measureUnit='" + measureUnit + '\'' +
                '}';
    }
}
