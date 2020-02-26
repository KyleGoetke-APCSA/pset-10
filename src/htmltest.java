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

        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load("/webView/main.html");
    }
}


