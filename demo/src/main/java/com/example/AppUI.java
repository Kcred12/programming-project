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

    @Override
    public void start(Stage primaryStage) {

        // Use a BorderPane to position the title at the top and the menu in the center
        BorderPane rootLayout = setupUI();

        // Set up the scene and stage
        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setTitle("Calorie Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BorderPane setupUI() {
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
        viewCaloriesButton.setOnAction(e -> System.out.println("View Remaining Calories/Macros clicked"));
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

    public static void main(String[] args) {
        launch();
    }
}