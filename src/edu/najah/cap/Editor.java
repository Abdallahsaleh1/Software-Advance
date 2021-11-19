package edu.najah.cap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener, DocumentListener {

	public static  void main(String[] args) {
		new Editor();
	}

	public JEditorPane TP;
	private JMenuBar menu;
	public boolean changed = false;
	private File file;
	public void setTextPanel(JEditorPane textPanel) {
		this.TP = textPanel ;
	}
	
	public JEditorPane getTextPanel() {
		return TP;
	}
	
	public void setMenu(JMenuBar menu) {
		this.menu = menu ;
	}
	
	public JMenuBar getMenu() {
		return menu;
	}
	
	public void setChangeStatus(boolean changeStatus) {
		this.changed = changeStatus ;
	}
	
	public boolean getChangeStatus() {
		return changed;
	}
	
	public void setFile(File file) {
		this.file = file ;
	}
	
	public File getFile() {
		return file;
	}

	public Editor() {
		super("Editor");
		TP = new JEditorPane();
		add(new JScrollPane(TP), "Center");
		TP.getDocument().addDocumentListener(this);

		menu = new JMenuBar();
		setJMenuBar(menu);
		BuildMenu();
		int width = 500 ;
		int height = 500 ;
		setSize(width, height);
		
		boolean visible = true ;
		setVisible(visible);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void BuildMenu() {
		MenuBuilder builder = new MenuBuilder();
		builder.buildFileMenu(this);
		builder.buildEditMenu(this);
	}
	

	public void saveFile() {
		int choosenOption = 0;
		if (changed) {
			choosenOption = JOptionPane.showConfirmDialog(null, "The file has changed. You want to save it?", "Save file", 0, 2);
		}
		if (choosenOption != 1 && file == null) {
				saveAs("Save");
		} else if(choosenOption != 1){
				String text = TP.getText();
				System.out.println(text);
				try (PrintWriter writer = new PrintWriter(file);){
					if (!file.canWrite())
						throw new Exception("Cannot write file!");
					writer.write(text);
					changed = false;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	}
	
	
	public void newFile() {
		if (changed) {
			int choosenOption = JOptionPane.showConfirmDialog(null, "The file has changed. You want to save it?", "Save file",0, 2);
			if (choosenOption == 1) {
				return;
			}
			
			if (file == null) {
				saveAs("Save");
				return;
			}
			
			String text = TP.getText();
			System.out.println(text);
			try (PrintWriter writer = new PrintWriter(file);){
				if (!file.canWrite())
					throw new Exception("Cannot write file!");
				writer.write(text);
				changed = false;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		file = null;
		TP.setText("");
		changed = false;
		setTitle("Editor");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		
		if (action.equals("Quit")) {
			System.exit(0);
		} else if (action.equals("Open")) {
			loadFile();
		} else if (action.equals("Save")) {
			saveFile();
		} else if (action.equals("New")) {
			newFile();
		} else if (action.equals("Save as...")) {
			saveAs("Save as...");
		} else if (action.equals("Select All")) {
			TP.selectAll();
		} else if (action.equals("Copy")) {
			TP.copy();
		} else if (action.equals("Cut")) {
			TP.cut();
		} else if (action.equals("Paste")) {
			TP.paste();
		} else if (action.equals("Find")) {
			FindDialog find = new FindDialog(this, true);
			find.showDialog();
		}
	}


	private void loadFile() {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setMultiSelectionEnabled(false);
		try {
			int choosenOption = dialog.showOpenDialog(this);
			
			if (choosenOption == 1)
				return;
			if (choosenOption == 0) {
                newFile();
				file = dialog.getSelectedFile();
				StringBuilder readString = new StringBuilder();
				try (FileReader fileReader = new FileReader(file);		
						BufferedReader reader = new BufferedReader(fileReader);) {
					String line;
					while ((line = reader.readLine()) != null) {
						readString.append(line + "\n");
					}
				} catch (IOException exception) {
					exception.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot read file !", "Error !", 0);
				}
				
				TP.setText(readString.toString());
				changed = false;
				setTitle("Editor - " + file.getName());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception, "Error", 0);
		}
	}

	
	private void saveAs(String dialogTitle) {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
		dialog.setDialogTitle(dialogTitle);
		int choosenOption = dialog.showSaveDialog(this);
		if (choosenOption != 0)
			return;
		file = dialog.getSelectedFile();
		try (PrintWriter writer = new PrintWriter(file);){
			writer.write(TP.getText());
			changed = false;
			setTitle("Editor - " + file.getName());
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}


	@Override
	public void insertUpdate(DocumentEvent e) {
		changed = true;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changed = true;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		changed = true;
	}

}