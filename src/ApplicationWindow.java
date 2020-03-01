import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.ScrollPane;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;

public class ApplicationWindow {

	private JFrame frmKylesEdictionary;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
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
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKylesEdictionary = new JFrame();
		frmKylesEdictionary.setResizable(false);
		frmKylesEdictionary.setTitle("Kyle's eDictionary");
		frmKylesEdictionary.setBounds(100, 100, 965, 512);
		frmKylesEdictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKylesEdictionary.getContentPane().setLayout(null);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(10, 11, 89, 23);
		frmKylesEdictionary.getContentPane().add(btnAdd);

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(109, 11, 89, 23);
		frmKylesEdictionary.getContentPane().add(btnRemove);

		textField = new JTextField("Search");
		textField.setBounds(10, 45, 188, 20);
		frmKylesEdictionary.getContentPane().add(textField);
		textField.setColumns(10);

		ScrollPane wordList = new ScrollPane();
		wordList.setBounds(10, 99, 188, 364);
		frmKylesEdictionary.getContentPane().add(wordList);

		JRadioButton rdbtnAsc = new JRadioButton("Asc");
		buttonGroup.add(rdbtnAsc);
		rdbtnAsc.setBounds(36, 70, 63, 23);
		frmKylesEdictionary.getContentPane().add(rdbtnAsc);

		JRadioButton rdbtnDesc = new JRadioButton("Desc");
		buttonGroup.add(rdbtnDesc);
		rdbtnDesc.setBounds(122, 70, 54, 23);
		frmKylesEdictionary.getContentPane().add(rdbtnDesc);

		ScrollPane wordInfo = new ScrollPane();
		wordInfo.setBounds(214, 11, 725, 452);
		frmKylesEdictionary.getContentPane().add(wordInfo);
	}
}
