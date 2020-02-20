import javafx.application.Application;
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
// https://www.youtube.com/watch?v=MAiKpkQqb6Q&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=26
// https://www.one-tab.com/page/0vjtNHudTpWFCDc7cUWfnA

public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize and set up the window and other things for the program
        window = primaryStage;
        window.setTitle("Kyle's eDictionary");
        window.setOnCloseRequest(e -> closeProgram());
        StackPane layout = new StackPane();

        // Initialize Add Word & Remove Word buttons and assign actions on click
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        addButton.setOnAction(e -> /*System.out.println("Add")*/ Dictionary.addWord());
        removeButton.setOnAction(e -> /*System.out.println("Remove")*/ Dictionary.removeWord());

        // Initialize the Search box and the sorting buttons, group them under ToggleGroup, and assign actions on click
        ToggleGroup group = new ToggleGroup();
        RadioButton ascendingRB = new RadioButton("Asc");
        ascendingRB.setToggleGroup(group);
        RadioButton descendingRB = new RadioButton("Desc");
        descendingRB.setToggleGroup(group);
        TextField searchBar = new TextField("Search");
        ascendingRB.setOnAction(e -> System.out.println("Ascending"));
        descendingRB.setOnAction(e -> System.out.println("Descending"));

        // Initialize the FlowPane and add all necessary children to it
        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(addButton, removeButton, searchBar, ascendingRB, descendingRB);
        flowpane.setHgap(10);
        flowpane.setVgap(10);

        // Initialize the scene and display it
        Scene scene = new Scene(flowpane, 900, 450);
        scene.getStylesheets().add("/styles.css");
        window.setScene(scene);
        window.show();
    }

    // Asks the user if they are sure they want to close the program
    private void closeProgram() {
        // Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        System.out.println("Safely closed the program");
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
