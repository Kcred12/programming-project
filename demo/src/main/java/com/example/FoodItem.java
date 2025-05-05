package com.example;

public class FoodItem {
    private String name;
    private double calories; // Total calories
    private double protein; // Protein in grams
    private double carbs; // Carbs in grams
    private double fat; // Fat in grams

    // Constructor
    public FoodItem(String name, double calories, double protein, double carbs, double fat) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return name + " - Calories: " + calories + ", Protein: " + protein + "g, Carbs: " + carbs + "g, Fat: " + fat
                + "g";
    }
}