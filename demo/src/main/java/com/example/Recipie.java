package com.example;

import java.util.ArrayList;
import java.util.List;

public class Recipie {
    private String name;
    private int totalCalories;
    private int totalProtein;
    private int totalCarbs;
    private int totalFat;
    private List<FoodItem> ingredients;

    public Recipie(String name) {
        this.name = name;
        this.totalCalories = 0;
        this.totalProtein = 0;
        this.totalCarbs = 0;
        this.totalFat = 0;
        this.ingredients = new ArrayList<>();
    }

    // Add a food item to the recipe
    public void addIngredient(FoodItem food) {
        ingredients.add(food);
        totalCalories += food.getCalories();
        totalProtein += food.getProtein();
        totalCarbs += food.getCarbs();
        totalFat += food.getFat();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public List<FoodItem> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        String result = "Recipe: " + name + "\n";
        result += "Total Calories: " + totalCalories + "\n";
        result += "Total Protein: " + totalProtein + "g\n";
        result += "Total Carbs: " + totalCarbs + "g\n";
        result += "Total Fat: " + totalFat + "g\n";
        result += "Ingredients:\n";
        for (FoodItem food : ingredients) {
            result += " - " + food.toString() + "\n";
        }
        return result;
    }
}