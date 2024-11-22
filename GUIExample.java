package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class GUIExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();

        // top border
        Label bannerLabel = new Label("roll no:113 Assignment");
        bannerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        bannerLabel.setPadding(new Insets(10));
        bannerLabel.setMaxWidth(Double.MAX_VALUE);
        bannerLabel.setStyle("-fx-alignment: center; -fx-background-color: lightblue;");
        mainLayout.setTop(bannerLabel);

        // Form Layout
        GridPane formLayout = new GridPane();
        formLayout.setPadding(new Insets(20));
        formLayout.setHgap(10);
        formLayout.setVgap(10);

        // Adding name, ftather name, etc in the form
        formLayout.add(new Label("Name:"), 0, 0);
        TextField nameField = new TextField();
        formLayout.add(nameField, 1, 0);
        formLayout.add(new Label("Father Name:"), 0, 1);
        TextField fatherNameField = new TextField();
        formLayout.add(fatherNameField, 1, 1);
        formLayout.add(new Label("CNIC:"), 0, 2);
        TextField cnicField = new TextField();
        formLayout.add(cnicField, 1, 2);
        formLayout.add(new Label("Date:"), 0, 3);
        DatePicker datePicker = new DatePicker();
        formLayout.add(datePicker, 1, 3);
        formLayout.add(new Label("Gender:"), 0, 4);
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio);
        formLayout.add(genderBox, 1, 4);
        formLayout.add(new Label("City:"), 0, 5);
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Peshawar", "Islamabad", "Quetta", "Gilgit Baltistan");
        formLayout.add(cityComboBox, 1, 5);

        // Image part
        VBox rightLayout = new VBox(10);
        rightLayout.setPadding(new Insets(20));
        Label imageLabel = new Label("Image");
        imageLabel.setStyle("-fx-border-color: black; -fx-min-width: 100px; -fx-min-height: 100px;");
        StackPane imageContainer = new StackPane();
        imageContainer.setMinSize(100, 100);
        imageContainer.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        imageLabel.setStyle("-fx-alignment: center;");
        imageContainer.getChildren().add(imageLabel); // Image label serves as a placeholder
        rightLayout.getChildren().add(imageContainer);

        // File Chooser Button gpt
        Button fileChooserButton = new Button("Browse Image");
        rightLayout.getChildren().add(fileChooserButton);

        // FileChooser setup gpt
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        // Add an action to the FileChooser button gpt
        fileChooserButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                // Display selected image in ImageView gpt
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100); // Set the width of the image
                imageView.setFitHeight(100); // Set the height of the image

                // Clear the previous placeholder label and add the image gpt
                imageContainer.getChildren().clear();
                imageContainer.getChildren().add(imageView); // Add the image to the container
            }
        });

        //Save button
        HBox bottomLayout = new HBox();
        Button saveButton = new Button("Save");
        bottomLayout.getChildren().add(saveButton);

        // Adding the layouts to the main form
        mainLayout.setCenter(formLayout);
        mainLayout.setRight(rightLayout);
        mainLayout.setBottom(bottomLayout);

        // Creatiing and setting the scene
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
