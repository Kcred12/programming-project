package com.example;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AppUI extends Application {

    // Constants for default calorie and macro values
    // These values can be adjusted based on user input or preferences (if I end up
    // implementing that)
    private int calories = 2000;
    private int protein = 140; // in grams
    private int carbs = 120; // in grams
    private int fat = 90; // in grams

    // Some constant food items for ease of use
    private final FoodItem chickenBreast = new FoodItem("Chicken Breast", 165, 31, 0, 3.6);
    private final FoodItem potatoes = new FoodItem("Potatoes", 93, 2.5, 21, 0);
    private final FoodItem whiteRice = new FoodItem("White Rice", 130, 2.7, 28, 0);
    private final FoodItem eightyTwentyGroundBeef = new FoodItem("80/20 Ground Beef", 270, 26, 0, 18);

    ArrayList<FoodItem> FOOD_CONSTANTS = new ArrayList<FoodItem>();

    @Override
    public void start(Stage primaryStage) {

        // Initialize the food constants
        FOOD_CONSTANTS.add(chickenBreast);
        FOOD_CONSTANTS.add(potatoes);
        FOOD_CONSTANTS.add(whiteRice);
        FOOD_CONSTANTS.add(eightyTwentyGroundBeef);

        // Use a BorderPane to position the title at the top and the menu in the center
        BorderPane rootLayout = setupUI(primaryStage);

        // Set up the scene and stage
        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setResizable(false); // Disable resizing
        primaryStage.setTitle("Calorie Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Sets up the main menu UI
    private BorderPane setupUI(Stage primaryStage) {
        // Create a label for the title
        Label titleLabel = new Label("Calorie Tracker");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10;");

        // Combine title and subtitle in a VBox
        VBox topLayout = new VBox(5, titleLabel);
        topLayout.setAlignment(Pos.CENTER); // Center-align the content

        // Create buttons for the menu options
        Button viewCaloriesButton = new Button("View Remaining Calories/Macros");
        Button addFoodButton = new Button("Add Food/Recipes to Total Calories");
        Button createRecipeButton = new Button("Create Recipes");
        Button viewRecipesButton = new Button("View Recipes");

        // Set up button actions (to be implemented later)
        viewCaloriesButton.setOnAction(e -> showCalorieView(primaryStage));
        addFoodButton.setOnAction(e -> showAddFoodOptions(primaryStage));
        createRecipeButton.setOnAction(e -> System.out.println("Create Recipes clicked"));
        viewRecipesButton.setOnAction(e -> System.out.println("View Recipes clicked"));

        // Arrange buttons in a vertical layout
        VBox menuLayout = new VBox(10, viewCaloriesButton, addFoodButton, createRecipeButton, viewRecipesButton);
        menuLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        BorderPane rootLayout = new BorderPane();

        rootLayout.setTop(topLayout);
        rootLayout.setCenter(menuLayout);

        return rootLayout;
    }

    // Creates the menu for adding food or recipes
    private void showAddFoodOptions(Stage primaryStage) {
        // Create buttons for the options
        Button addRecipeButton = new Button("Add Recipe");
        Button addFoodButton = new Button("Add Food");

        // Create a back button to return to the main menu
        Button backButton = new Button("Back");

        // Set up actions for the buttons
        addRecipeButton.setOnAction(e -> System.out.println("Add Recipe functionality to be implemented."));
        addFoodButton.setOnAction(e -> showFoodList(primaryStage));

        backButton.setOnAction(e -> {
            BorderPane rootLayout = setupUI(primaryStage);
            Scene scene = new Scene(rootLayout, 400, 300);
            primaryStage.setScene(scene);
        });

        // Arrange buttons in a vertical layout
        VBox optionsLayout = new VBox(10, addRecipeButton, addFoodButton, backButton);
        optionsLayout.setAlignment(Pos.CENTER);

        // Set up the scene and switch to it
        Scene optionsScene = new Scene(optionsLayout, 400, 300);
        primaryStage.setScene(optionsScene);

    }

    // Displays the list of food items after "Add Food" is clicked
    private void showFoodList(Stage primaryStage) {
        // Create a label for the title
        Label titleLabel = new Label("Available Foods");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-padding: 10;");

        // Create a VBox to display the list of food items
        VBox foodListLayout = new VBox(10, titleLabel);
        foodListLayout.setAlignment(Pos.CENTER);

        // Add each food item as a button
        for (FoodItem food : FOOD_CONSTANTS) {
            Button foodButton = new Button(food.getName());
            foodButton.setOnAction(e -> {

                Stage popupStage = new Stage();
                popupStage.setTitle("Add Food");

                FoodItem selectedFood = food;
                TextField userGramEntry = new TextField("Enter food amount in grams");

                Button addButton = new Button("Add Food");

                addButton.setOnAction(event -> {
                    double grams = Double.parseDouble(userGramEntry.getText());

                    double caloriesToAdd = (selectedFood.getCalories() / 100) * grams;
                    double proteinToAdd = (selectedFood.getProtein() / 100) * grams;
                    double carbsToAdd = (selectedFood.getCarbs() / 100) * grams;
                    double fatToAdd = (selectedFood.getFat() / 100) * grams;

                    FoodItem foodToAdd = new FoodItem(food.getName(), caloriesToAdd, proteinToAdd, carbsToAdd,
                            fatToAdd);
                    addFoodToTracker(foodToAdd);
                    popupStage.close();
                });

                VBox popupLayout = new VBox(10, userGramEntry, addButton);
                popupLayout.setAlignment(Pos.CENTER);

                Scene popupScene = new Scene(popupLayout, 300, 200);
                popupStage.setScene(popupScene);
                popupStage.show();

            });
            foodListLayout.getChildren().add(foodButton);
        }

        // Add a back button to return to the previous menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showAddFoodOptions(primaryStage));
        foodListLayout.getChildren().add(backButton);

        // Set up the scene and switch to it
        Scene foodListScene = new Scene(foodListLayout, 400, 300);
        primaryStage.setScene(foodListScene);
    }

    // This is used to add food items to the calorie tracker
    // It updates the calorie and macro values based on the selected food item
    private void addFoodToTracker(FoodItem food) {
        if (food != null) {
            calories -= food.getCalories();
            protein -= food.getProtein();
            carbs -= food.getCarbs();
            fat -= food.getFat();
            System.out.println(food.getName() + " added: " + food);
        } else {
            System.out.println("Food not found.");
        }
    }

    // Displays the calorie and macro information
    private void showCalorieView(Stage primaryStage) {
        // Create labels to display calorie and macro information
        Label calorieLabel = new Label("Remaining Calories: " + getCalories());
        Label proteinLabel = new Label("Protein: " + getProtein() + "g");
        Label carbsLabel = new Label("Carbs: " + getCarbs() + "g");
        Label fatLabel = new Label("Fat: " + getFat() + "g");

        // Style the labels
        calorieLabel.setStyle("-fx-font-size: 16px; -fx-padding: 5;");
        proteinLabel.setStyle("-fx-font-size: 16px; -fx-padding: 5;");
        carbsLabel.setStyle("-fx-font-size: 16px; -fx-padding: 5;");
        fatLabel.setStyle("-fx-font-size: 16px; -fx-padding: 5;");

        // Create a back button to return to the main menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            BorderPane rootLayout = setupUI(primaryStage);
            Scene scene = new Scene(rootLayout, 400, 300);
            primaryStage.setScene(scene);
        });

        // Arrange labels and back button in a vertical layout
        VBox calorieLayout = new VBox(10, calorieLabel, proteinLabel, carbsLabel, fatLabel, backButton);
        calorieLayout.setAlignment(Pos.CENTER);
        calorieLayout.setStyle("-fx-padding: 20;");

        // Set up the scene and switch to it
        Scene calorieScene = new Scene(calorieLayout, 400, 300);
        primaryStage.setScene(calorieScene);
    }

    // Getter methods for default values
    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    // Setter methods for default values
    public void setCalories(int calories, int num) {
        this.calories += num;
    }

    public void setProtein(int protein, int num) {
        this.protein += num;
    }

    public void setCarbs(int carbs, int num) {
        this.carbs += num;
    }

    public void setFat(int fat, int num) {
        this.fat += num;
    }

    public static void main(String[] args) {
        launch();
    }
}