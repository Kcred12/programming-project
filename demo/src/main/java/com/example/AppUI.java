package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class AppUI extends Application {

    // Constants for default calorie and macro values
    // These values can be adjusted based on user input or preferences (if I end up
    // implementing that)
    private final int DEFUALTCALORIES = 2000;
    private final int DEFAULTPROTEIN = 140; // in grams
    private final int DEFAULTCARBS = 120; // in grams
    private final int DEFAULTFAT = 90; // in grams

    @Override
    public void start(Stage primaryStage) {

        // Use a BorderPane to position the title at the top and the menu in the center
        BorderPane rootLayout = setupUI(primaryStage);

        // Set up the scene and stage
        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setTitle("Calorie Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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
        addFoodButton.setOnAction(e -> System.out.println("Add Food/Recipes clicked"));
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

    private void showCalorieView(Stage primaryStage) {
        // Create labels to display calorie and macro information
        Label calorieLabel = new Label("Remaining Calories: " + DEFUALTCALORIES);
        Label proteinLabel = new Label("Protein: " + DEFAULTPROTEIN + "g");
        Label carbsLabel = new Label("Carbs: " + DEFAULTCARBS + "g");
        Label fatLabel = new Label("Fat: " + DEFAULTFAT + "g");

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

    public static void main(String[] args) {
        launch();
    }
}