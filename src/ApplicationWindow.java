import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.google.gson.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationWindow {
    private JFrame frmKylesEdictionary;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        getWordsDLM();
        Dictionary.addAllWords();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicationWindow window = new ApplicationWindow();
                    window.frmKylesEdictionary.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * DLM of words, sorted in ascending order
     */
    private static DefaultListModel<String> getWordsDLM() throws FileNotFoundException, NullPointerException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(".\\JSON\\words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
        for (Words word : words) {
            listOfWords.addElement(word.getWord());
        };
        return sortWordsAsc(listOfWords);
    }

    /**
     * Create the application.
     * @throws FileNotFoundException
     */
    public ApplicationWindow() throws FileNotFoundException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws FileNotFoundException
     */
    private void initialize() throws FileNotFoundException {
        frmKylesEdictionary = new JFrame();
        frmKylesEdictionary.setResizable(false);
        frmKylesEdictionary.setTitle("Kyle's eDictionary");
        frmKylesEdictionary.setBounds(100, 100, 965, 512);
        frmKylesEdictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmKylesEdictionary.getContentPane().setLayout(null);
        Words[] wordList = Dictionary.wordList;

        /**
         * Main container for word information and dialogues
         */
        JScrollPane wordInfo = new JScrollPane();
        wordInfo.setBounds(214, 11, 725, 452);
        frmKylesEdictionary.getContentPane().add(wordInfo);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        wordInfo.setViewportView(textPane);
        StyledDocument doc = textPane.getStyledDocument();
        DefaultCaret caret = (DefaultCaret) textPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        textPane.setBorder(BorderFactory.createCompoundBorder(textPane.getBorder(), BorderFactory.createEmptyBorder(10, 10 ,10 , 10)));

        /**
         * Scroll pane that contains the list of words
         */
        JScrollPane wordListSP = new JScrollPane();
        wordListSP.setBounds(10, 99, 188, 364);
        frmKylesEdictionary.getContentPane().add(wordListSP);

        /**
         * List of words
         */
        JList<String> list = new JList<String>();
        list.addListSelectionListener(new ListSelectionListener() {
            boolean ranOnce = false;
            public void valueChanged(ListSelectionEvent arg0) {
                if (ranOnce) {
                    ranOnce = false;
                } else {
                    ranOnce = true;

                    String selectedWord = list.getSelectedValue();
                    System.out.println("Selected word 2: " + selectedWord);

                    try {
                        ArrayList<Words> Words = getWordClass();
                        for (Words word: Words) {
                            if (word.getWord().equals(selectedWord)) {
                                doc.remove(0, doc.getLength());
                                Style bigWord = textPane.addStyle("Style", null);
                                Style header = textPane.addStyle("Style", null);
                                StyleConstants.setFontSize(header, 20);
                                StyleConstants.setFontSize(bigWord, 36);
                                StyleConstants.setBold(bigWord, true);
                                doc.insertString(doc.getLength(), selectedWord.substring(0, 1).toUpperCase() + selectedWord.substring(1) + "\n", bigWord );
                                doc.insertString(doc.getLength(), "\n" ,null );
                                doc.insertString(doc.getLength(), "Definitions\n", header );
                                doc.insertString(doc.getLength(), "\n" ,null );
                                Definitions[] definitions = word.getDefinitions();
                                int definitionCounter = 1;
                                for (Definitions definition : definitions) {
                                    doc.insertString(doc.getLength(), definitionCounter + ". " + selectedWord +" (" + definition.getPartOfSpeech() +")\n\n    "  +  definition.getDefinition() + "\n\n", null);
                                    definitionCounter++;
                                }
                                String[] synonyms = word.getSynonyms();
                                if(synonyms.length != 0) {
                                    doc.insertString(doc.getLength(),"Synonyms\n" ,header );
                                    doc.insertString(doc.getLength(),"\n" ,null );
                                    int synonymCounter = 1;
                                    for(String synonym : synonyms) {

                                        doc.insertString(doc.getLength(), synonymCounter + ". " + synonym + "\n", null);
                                        synonymCounter++;
                                    }
                                }
                                String[] antonyms = word.getAntonyms();
                                if (antonyms.length != 0) {
                                    doc.insertString(doc.getLength(),"\n" ,null );
                                    doc.insertString(doc.getLength(),"Antonyms\n" ,header );
                                    doc.insertString(doc.getLength(),"\n" ,null );
                                    int antonymCounter = 1;
                                    for(String antonym : antonyms) {
                                        doc.insertString(doc.getLength(), antonymCounter + ". " + antonym + "\n", null);
                                        antonymCounter++;
                                    }
                                }

                            }
                        }
                    } catch (FileNotFoundException | BadLocationException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        /**
         * Button to add a word
         */
        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(10, 11, 89, 23);
        btnAdd.addActionListener(new java.awt.event.ActionListener(){
            @Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
            	EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddWordWindow window = new AddWordWindow();
							window.addWordFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddWordWindow window = new AddWordWindow();
							window.addWordFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
        });
        frmKylesEdictionary.getContentPane().add(btnAdd);

        /**
         * Button to remove a word
         */
        JButton btnRemove = new JButton("REMOVE");
        btnRemove.addActionListener(e -> {
            System.out.println("Remove");
//            delWord(wordsToDelete, wordList);
        });
        btnRemove.setBounds(109, 11, 89, 23);
        frmKylesEdictionary.getContentPane().add(btnRemove);

        /**
         * Search box to... well... search
         */
        JTextField searchBox = new JTextField();
        searchBox.setBounds(10, 45, 188, 20);
        frmKylesEdictionary.getContentPane().add(searchBox);
        searchBox.setColumns(10);

        /**
         * Radio button to sort in ascending order
         */
        JRadioButton rdbtnAsc = new JRadioButton("Asc");
        rdbtnAsc.addActionListener(e -> {
        });
        rdbtnAsc.setToolTipText("Sorts in ascending order");
        rdbtnAsc.setSelected(true);
        buttonGroup.add(rdbtnAsc);
        rdbtnAsc.setBounds(36, 70, 63, 23);
        frmKylesEdictionary.getContentPane().add(rdbtnAsc);

        /**
         * Radio button to sort in descending order
         */
        JRadioButton rdbtnDesc = new JRadioButton("Desc");
        rdbtnDesc.addActionListener(e -> {
        });
        rdbtnDesc.setToolTipText("Sorts in descending order");
        buttonGroup.add(rdbtnDesc);
        rdbtnDesc.setBounds(122, 70, 54, 23);
        frmKylesEdictionary.getContentPane().add(rdbtnDesc);
        rdbtnDesc.addItemListener(new ItemListener() {
            /**
             * Changed between sorting in ascended or descended order
             */
            @Override
            public void itemStateChanged(ItemEvent event) {

                int state = event.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    try {
                        searchBox.setText("");
                        list.setModel(reverseOrder(getWordsDLM()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                } else if (state == ItemEvent.DESELECTED) {
                    try {
                        searchBox.setText("");
                        list.setModel(getWordsDLM());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        /**
         * Automatically populates list from the Array in Dictionary.java
         */
        list.addListSelectionListener(new ListSelectionListener() {
            boolean ranOnce = false;
            public void valueChanged(ListSelectionEvent arg0) {
                if(ranOnce) {
                    ranOnce = false;
                }else {
                    ranOnce = true;

                    String selectedWord = list.getSelectedValue();
                    System.out.println("Selected word: " + selectedWord);

                    try {
                        ArrayList<Words> Words = getWordClass();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        wordListSP.setViewportView(list);
        DefaultListModel<String> DLM = getWordsDLM();;
        list.setModel(DLM);

        /**
         * Searches through words based on searchBox's contents
         */
        searchBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searched = searchBox.getText().toLowerCase();
                System.out.println("Searched term: " + searched);
                DefaultListModel<String> words = new DefaultListModel<String>();
                if (!rdbtnAsc.isSelected()) {
                    try {
                        words = reverseOrder(getWordsDLM());
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    try {
                        words = getWordsDLM();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
                DefaultListModel<String> filtered = new DefaultListModel<String>();
                for (int i = 0 ; i < words.size(); i++) {
                    if((words.get(i).startsWith(searched))) {
                        filtered.addElement(words.get(i));
                    }
                }
                list.setModel(filtered);

            }
        });
        searchBox.setToolTipText("Search");
    }

    /**
     * Sorts the DLM of words in ascending order
     */
    public static DefaultListModel<String> sortWordsAsc(DefaultListModel<String> listOfWords) {
        String temp;
        int n = listOfWords.getSize();
        for (int i = 0; i < n; i++)  {
            for (int j = i + 1; j < n; j++) {
                if ((listOfWords.get(i).compareTo(listOfWords.get(j)) > 0)) {
                    temp = listOfWords.get(i);
                    listOfWords.set(i, listOfWords.get(j));
                    listOfWords.set(j, temp);
                }
            }
        }
        return listOfWords;
    }

    /**
     * Reverses the order of a DLM (used when searching in reverse order)
     */
    public static DefaultListModel<String> reverseOrder(DefaultListModel<String> words) {
        DefaultListModel<String> b = new DefaultListModel<String>();
        int n = words.getSize();
        int j = n;
        for (int i = 0; i < n; i++) {
            b.addElement(words.get(j-1));
            j = j - 1;
        }
        return b;
    }

    /**
     * Adds words to listOfWords and returns it
     */
    private static ArrayList<Words> getWordClass() throws FileNotFoundException{
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(".\\JSON\\words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        ArrayList<Words> listOfWords = new ArrayList<Words>();
        for (Words word : words) {
            listOfWords.add(word);
        };
        return listOfWords;
    }
}
