package Projekt1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	public MainWindow() {
		setPreferredSize(new Dimension(800, 600));
		setLayout(new BorderLayout());
		buttonStart();
		pack();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buttonStart() {
		JPanel panel = new JPanel();
		JButton start = new JButton("Start");
		start.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		JButton hs = new JButton("High Score");
		hs.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		JButton exit = new JButton("Exit");
		exit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(start);
		panel.add(hs);
		panel.add(exit);
		add(panel);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		hs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new HighScore();

			}
		});

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GameSize();
			}
		});

	}

}
