package edu.najah.cap;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JMenuBar;


public class MenuBuilder {
	
private JMenuItem buildMenuItems(String itemName , char mnemonicType , JMenu menuItem,Editor editObject) {
		
		JMenuItem newItem = new JMenuItem(itemName);
		newItem.setMnemonic(mnemonicType);
		newItem.addActionListener(editObject);
		menuItem.add(newItem);
		
		return newItem ;
	}



	public void buildEditMenu(Editor editorObject) {
		
		JMenuBar menu = editorObject.getMenu();
		JMenu edit = new JMenu("Edit");
		menu.add(edit);
		edit.setMnemonic('E');
		
		JMenuItem newItem ; 
		// cut
		newItem = buildMenuItems("Cut" , 'X' , edit, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		// copy
		newItem = buildMenuItems("Copy" , 'C' , edit, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		// paste
		newItem = buildMenuItems("Paste" , 'P' , edit, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		// find
		newItem = buildMenuItems("Find" , 'F' , edit, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
		// select all
		newItem = buildMenuItems("Select All" , 'A' , edit, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
	}
	public void buildFileMenu(Editor editorObject) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuBar menu = editorObject.getMenu();
		menu.add(file);
		editorObject.setMenu(menu);
		
		JMenuItem newItem ; 
		
		newItem = buildMenuItems("New" , 'N' , file, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		
		newItem = buildMenuItems("Open" , 'O' , file, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		
		newItem = buildMenuItems("Save" , 'S' , file, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		newItem = buildMenuItems("Save as..." , 'S' , file, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		newItem = buildMenuItems("Quit" , 'Q' , file, editorObject);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
	}

}
