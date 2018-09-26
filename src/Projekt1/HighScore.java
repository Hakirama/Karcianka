package Projekt1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

@SuppressWarnings("serial")
public class HighScore extends JFrame {

	public HighScore() {
		setSize(800, 600);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 600));
		JTextArea text = new JTextArea();
		add(text);
		text.setEditable(false);
		try {
			text.setText(sort());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pack();
		setVisible(true);
	}

	public String sort() throws IOException {

		ArrayList<String> rows = new ArrayList<String>();
		FileReader fr = new FileReader("/Users/wojciechgorzkos-bukowski/Desktop/test.txt");
		BufferedReader reader = new BufferedReader(fr);
		String s;
		while ((s = reader.readLine()) != null) {
			rows.add(s);
		}
		Collections.sort(rows);
		Collections.reverse(rows);
		reader.close();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows.size(); i++) {

			sb.append(rows.get(i) + "\n");
		}

		return sb.toString();
	}

}
