package gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.TextField;
import model.*;

public class PasswordGeneratorGUI extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMenu();

    }

    private void showMenu() {
        MenuPane menuPane = new MenuPane();
        Scene scene = new Scene(menuPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Generator");
        primaryStage.show();
    }


}