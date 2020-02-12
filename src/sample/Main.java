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
        window.setTitle("Kyle's eDictionary");
        window.setOnCloseRequest(e -> closeProgram());
        StackPane layout = new StackPane();

        Button add = new Button("Add");
        Button remove = new Button("Remove");

        ToggleGroup group = new ToggleGroup();
        RadioButton ascending = new RadioButton("Asc");
        ascending.setToggleGroup(group);
        RadioButton descending = new RadioButton("Desc");
        descending.setToggleGroup(group);
        TextField searchBar = new TextField("Search");

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(add, remove, ascending, descending, searchBar);
        flowpane.setHgap(10);
        flowpane.setVgap(10);

        Scene scene = new Scene(flowpane, 900, 450);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(RadioButton ascending, RadioButton descending){
        String message = "Users order:\n";

        if(ascending.isSelected())
            message += "Ascending\n";
            descending.setSelected(true);

        if(descending.isSelected())
            message += "Descending\n";
            ascending.setSelected(true);

        System.out.println(message);
    }

    private void closeProgram() {
        //Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        System.out.println("Safely closed the program");
        window.close();
    }
}
