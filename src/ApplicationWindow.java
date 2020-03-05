import java.awt.EventQueue;

import javax.swing.*;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frmKylesEdictionary;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action addAction = new SwingAction();
	private final Action removeAction = new SwingAction_1();
	private final Action ascAction = new SwingSortAction();
	private final Action descAction = new SwingSortAction_1();

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

		/**
		 * Button to add word
		 */
		JButton btnAdd = new JButton("ADD");
		btnAdd.setAction(addAction);
		btnAdd.setBounds(10, 11, 89, 23);
		frmKylesEdictionary.getContentPane().add(btnAdd);

		/**
		 * Button to remove word
		 */
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setAction(removeAction);
		btnRemove.setBounds(109, 11, 89, 23);
		frmKylesEdictionary.getContentPane().add(btnRemove);


		ScrollPane wordList = new ScrollPane();
		wordList.setBounds(10, 99, 188, 364);
		frmKylesEdictionary.getContentPane().add(wordList);
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
		rdbtnAsc.setAction(ascAction);
		rdbtnAsc.setToolTipText("Sorts in ascending order");
		buttonGroup.add(rdbtnAsc);
		rdbtnAsc.setBounds(36, 70, 63, 23);
		frmKylesEdictionary.getContentPane().add(rdbtnAsc);

		/**
		 * Radio button to sort in descending order
		 */
		JRadioButton rdbtnDesc = new JRadioButton("Desc");
		rdbtnDesc.setAction(descAction);
		rdbtnDesc.setToolTipText("Sorts in descending order");
		buttonGroup.add(rdbtnDesc);
		rdbtnDesc.setBounds(122, 70, 54, 23);
		frmKylesEdictionary.getContentPane().add(rdbtnDesc);

		ScrollPane wordInfo = new ScrollPane();
		wordInfo.setBounds(214, 11, 725, 452);
		frmKylesEdictionary.getContentPane().add(wordInfo);
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Opens dialogue to add a word");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	/**
	 * Action for Aemove button
	 */
	private class SwingAction_1 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Remove");
			putValue(SHORT_DESCRIPTION, "Opens dialogue to remove a word");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	/**
	 * Action for Ascending sort option
	 */
	private class SwingSortAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingSortAction() {
			putValue(NAME, "Asc");
			putValue(SHORT_DESCRIPTION, "Sorts words in ascending alphabetical order");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	/**
	 * Action for Descending sort option
	 */
	private class SwingSortAction_1 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingSortAction_1() {
			putValue(NAME, "Desc");
			putValue(SHORT_DESCRIPTION, "Sorts words in descending alphabetical order");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
