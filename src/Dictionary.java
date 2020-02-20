import java.io.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Dictionary {
    public static Words[] wordList;
    public static void addAllWords() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        wordList = new Gson().fromJson(new FileReader("../data/words.json"), Words[].class);
    }

    public static ArrayList<String> listWords() {
        ArrayList<String> listOfWords = new ArrayList<String>();
        for(Words word : wordList) {
            listOfWords.add(word.getSpelling());
        }
        return listOfWords;
    }
    static void addWord() {
        //TODO implement adding words
        System.out.println("Add");
    }

    static void removeWord() {
        //TODO implement deleting words
        System.out.println("Remove");
    }

    private void search () {
        //TODO implement search
    }
}