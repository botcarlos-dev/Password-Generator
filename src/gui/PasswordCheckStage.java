package gui;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.*;
public class PasswordCheckStage extends Stage{
    public PasswordCheckStage() {
        setTitle("Password Strength Checker");

        VBox layout = new VBox();
        layout.setSpacing(10);

        Label promptLabel = new Label("Enter your password:");
        TextField passwordField = new TextField();

        Button checkButton = new Button("Check Strength");
        checkButton.setOnAction(e -> {
            String input = passwordField.getText();
            final Password password = new Password(input);
            String strength = password.calculateScore();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Strength");
            alert.setHeaderText(null);
            alert.setContentText("Your password is " + strength);
            alert.showAndWait();
        });

        layout.getChildren().addAll(promptLabel, passwordField, checkButton);

        Scene scene = new Scene(layout, 300, 150);
        setScene(scene);

    }
}
