package com.example;

public class Recipe {
    private String name;
    private double totalCalories;
    private double totalProtein;
    private double totalCarbs;
    private double totalFat;

    public Recipe(String name, double totalCalories, double totalProtein, double totalCarbs, double totalFat) {
        this.name = name;
        this.totalCalories = totalCalories;
        this.totalProtein = totalProtein;
        this.totalCarbs = totalCarbs;
        this.totalFat = totalFat;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalProtein() {
        return totalProtein;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public double getTotalFat() {
        return totalFat;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setTotalProtein(double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public String toCSV() {
        return name + "," + totalCalories + "," + totalProtein + "," + totalCarbs + "," + totalFat;
    }

    @Override
    public String toString() {
        String result = "Recipe: " + name + "\n";
        result += "Total Calories: " + totalCalories + "\n";
        result += "Total Protein: " + totalProtein + "g\n";
        result += "Total Carbs: " + totalCarbs + "g\n";
        result += "Total Fat: " + totalFat + "g\n";
        return result;
    }
}