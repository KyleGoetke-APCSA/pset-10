import java.util.Scanner;

public class Application {

    private Scanner in;
    public static boolean running;

    public Application() {
        this.in = new Scanner(System.in);
    }

    //////// STARTUP METHOD ///////////////////////////////////////////////////////////////

    public void startup() {

    }

    //////// MAIN METHOD //////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Application app = new Application();

        app.startup();
    }
}
