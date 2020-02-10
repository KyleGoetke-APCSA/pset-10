package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

// NOTES TO SELF:
// Install IntelliJ
// Download JavaFX 13 from Gluon
// Import everything into IntelliJ
// https://www.youtube.com/watch?v=YtKF1JKtRWM&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=9
// https://www.one-tab.com/page/0vjtNHudTpWFCDc7cUWfnA

public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Window Title");
        window.setOnCloseRequest(e -> closeProgram());
        StackPane layout = new StackPane();
//
//        HBox leftMenu = new HBox();
//        Button addButton = new Button("Add");
//        Button removeButton = new Button("Remove");
//        leftMenu.getChildren().addAll(addButton, removeButton);
//        BorderPane leftBorderPane = new BorderPane();
//        leftBorderPane.setTop(leftMenu);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        //Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        System.out.println("Safely closed the program");
        window.close();
    }
}
