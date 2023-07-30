package gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;

public class PasswordGeneratorStage extends Stage {

    public PasswordGeneratorStage() {
        setTitle("Password Generator");
        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);

        // Create labels and checkboxes for user input
        Label upperCaseLabel = new Label("Include Uppercase letters?");
        CheckBox upperCaseCheckBox = new CheckBox();

        Label lowerCaseLabel = new Label("Include Lowercase letters?");
        CheckBox lowerCaseCheckBox = new CheckBox();

        Label numbersLabel = new Label("Include Numbers?");
        CheckBox numbersCheckBox = new CheckBox();

        Label symbolsLabel = new Label("Include Symbols?");
        CheckBox symbolsCheckBox = new CheckBox();

        Label lengthLabel = new Label("Password Length:");
        TextField lengthField = new TextField();

        // Create the "Generate Password" button
        Button generateButton = new Button("Generate Password");
        generateButton.setOnAction(e -> {
            // Parse user input
            boolean includeUpper = upperCaseCheckBox.isSelected();
            boolean includeLower = lowerCaseCheckBox.isSelected();
            boolean includeNumbers = numbersCheckBox.isSelected();
            boolean includeSymbols = symbolsCheckBox.isSelected();
            int length = Integer.parseInt(lengthField.getText());

            // Generate and show the password
            final Generator generator = new Generator(includeUpper, includeLower, includeNumbers, includeSymbols);
            final Password password = generator.GeneratePassword(length);
            System.err.println("Your password -> " + password);

            // Show the password in an Alert dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Generated Password");
            alert.setHeaderText(null);
            alert.setContentText("Your password -> " + password);
            alert.showAndWait();
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            close();
        });


        layout.addRow(0, upperCaseLabel, upperCaseCheckBox);
        layout.addRow(1, lowerCaseLabel, lowerCaseCheckBox);
        layout.addRow(2, numbersLabel, numbersCheckBox);
        layout.addRow(3, symbolsLabel, symbolsCheckBox);
        layout.addRow(4, lengthLabel, lengthField);
        layout.addRow(5, generateButton);
        layout.addRow(5, backButton);

        Scene scene = new Scene(layout, 400, 300);
        setScene(scene);
    }
}
