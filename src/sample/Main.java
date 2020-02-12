package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// NOTES TO SELF:
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
        // Initialize and set up the window
        window = primaryStage;
        window.setTitle("Kyle's eDictionary");
        window.setOnCloseRequest(e -> closeProgram());
        StackPane layout = new StackPane();

        // Initialize the add & remove buttons
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");

        // Handles actions associated with add & remove buttons
        addButton.setOnAction(e -> System.out.println("Add"));
        removeButton.setOnAction(e -> System.out.println("Remove"));

        // Initialize the sorting buttons and assign to the ToggleGroup
        ToggleGroup group = new ToggleGroup();
        RadioButton ascendingRB = new RadioButton("Asc");
        ascendingRB.setToggleGroup(group);
        RadioButton descendingRB = new RadioButton("Desc");
        descendingRB.setToggleGroup(group);
        TextField searchBar = new TextField("Search");

        // Handles actions associated with sorting
        ascendingRB.setOnAction(e -> System.out.println("Ascending"));
        descendingRB.setOnAction(e -> System.out.println("Descending"));

        // Initialize the FlowPane and add all necessary children to it
        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(addButton, removeButton, searchBar, ascendingRB, descendingRB);
        flowpane.setHgap(10);
        flowpane.setVgap(10);

        // Initialize the scene and display it
        Scene scene = new Scene(flowpane, 900, 450);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        //Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        System.out.println("Safely closed the program");
        window.close();
    }
}
