import java.util.Scanner;

public class Application {

    private Scanner in;
    public static boolean running;

    public Application() {
        this.in = new Scanner(System.in);
    }

    //////// STARTUP METHOD ///////////////////////////////////////////////////////////////

    public void startup() {
        System.out.print("\nEnter your input: ");
        String test = in.nextLine();
        System.out.print(test);
    }

    public void selectWord() {
        // When you select a word in the sidebar, it should display:
          // The word
          // Its definitions (there will likely be more than one)
          // Parts of speech (for each definition)
          // Synonyms
          // Antonyms
    }

    public void addWord() {

    }

    public void removeWord() {
        // Users may remove one or more words at a time from the dictionary.
        // To remove a word (or words), highlight the desired word or words and click the Remove button.
        // A message dialog box should appear and ask the user to confirm his or her desire to remove the word or words.
    }

    public void search() {
        // Searches should be case-insensitive.
        // There are many built-in search fuctions in Java. Unfortunately, you aren't permitted to use any of them.
        // Pick a search algorithm (linear or binary) and implement it yourself.
    }

    public void sort() {
        // There are two checkboxes to sort the dictionary in either ascending or descending order.
        // Only one checkbox can be selected at a time. When a user selects Asc, the list should sort itself ascending.
        // Likewise, when a user selects Desc, the list should sort itself descending.
        // There are many built-in sorting fuctions in Java. Unfortunately, you aren't permitted to use any of them.
        // Pick a sorting algorithm (selection, insertion, bubble, or merge) and implement it yourself.
    }

    public void saveData() {

    }

    //////// MAIN METHOD //////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Application app = new Application();

        app.startup();
    }
}
