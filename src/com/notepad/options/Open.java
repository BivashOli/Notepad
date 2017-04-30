package com.notepad.options;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class Open {

	private BufferedReader bufferedReader;

	public Open(String path, JTextArea textArea) {
		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			try {
				textArea.setText(bufferedReader.readLine());
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {
		}
	}
}
