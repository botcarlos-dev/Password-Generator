package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;



public class MenuPane extends VBox {

    public MenuPane() {
        setSpacing(10);

        Button option1 = new Button("Password Generator");
        Button option2 = new Button("Password Strength Checker");
        Button option3 = new Button("Useful Information");
        Button option4 = new Button("Exit");

        option1.setOnAction(e -> {
            // Handle the action for Password Generator button
            showPasswordGeneratorStage();
        });

        option2.setOnAction(e -> {
            // Handle the action for Password Strength Checker button
            showPasswordCheckStage();
        });

        option3.setOnAction(e -> {
            // Show the useful information dialog
            showUsefulInfoDialog();
        });

        option4.setOnAction(e -> {
            Generator.printQuitMessage();
            System.exit(0);
        });

        getChildren().addAll(option1, option2, option3, option4);
    }



    private void showPasswordGeneratorStage(){
        PasswordGeneratorStage passwordGeneratorStage = new PasswordGeneratorStage();
        passwordGeneratorStage.show();
    }

    private void showPasswordCheckStage() {
        PasswordCheckStage passwordCheckStage = new PasswordCheckStage();
        passwordCheckStage.show();
    }

    private void showUsefulInfoDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Useful Information");
        alert.setHeaderText(null);
        alert.setContentText(Generator.printUsefulInfo()); // Call the static method directly
        alert.showAndWait();
    }
}

