package com.notepad.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.notepad.options.Open;
import com.notepad.options.Save;

public class Display {

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem itemOpen, itemSave, itemExit;
	private JTextArea textArea;

	public Display() {
		init();
		window();
		listener();
	}

	private void init() {
		frame = new JFrame();
		panel = new JPanel();
		menuBar = new JMenuBar();
		
		menuFile = new JMenu("File");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		
		textArea = new JTextArea();

		frame.setJMenuBar(menuBar);
		menuBar.add(menuFile);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);

		textArea.setBounds(32, 30, 730, 370);
		textArea.setLineWrap(true);

		panel.setLayout(null);
		panel.add(textArea);

		textArea.setFont(new Font("Ariel", Font.PLAIN, 16));
	}

	private void window() {
		frame.add(panel);
		frame.setTitle("Notepad");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void listener() {
		itemOpen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String path = (String) JOptionPane.showInputDialog("Enter file path");

				new Open(path, textArea);
			}
		});
		
		itemSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String path = (String) JOptionPane.showInputDialog("Enter file path");

				new Save(path, textArea.getText());
			}
		});
		
		itemExit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(1); 
			}});
	}
}
