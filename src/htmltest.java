import javafx.application.Application;
import java.io.File;
import java.net.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.*;
import javafx.stage.Stage;
import java.net.URI;

public class htmltest {

    public void main(String[] args) {
        WebEngine WebEngine = WebView.getEngine();
        File index = new File("//html/test.html");
        WebEngine.load("file://" + index.toURI().toString().substring(5));
        WebEngine.load("file://" + index.toURI().toString().substring(5)));
        System.out.println("file://" + index.toURI().toString().substring(5));
    }
}


