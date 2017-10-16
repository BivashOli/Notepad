package com.notepad.options;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Save {

	private PrintWriter printWriter;

	public Save(String path, String data) {
		try {
			printWriter = new PrintWriter(new File(path));
			printWriter.write(data);
			printWriter.close();
		} catch (IOException e) {
		}
	}

}
