public class Application {

    private Scanner in;
    public static boolean running;

    public Application() {
        this.in = new Scanner(System.in);

        try {
            PowerSchool.initialize(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
