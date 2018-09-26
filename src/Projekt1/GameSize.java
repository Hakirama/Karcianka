package Projekt1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameSize extends JFrame {

	public GameSize() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 600));
		bordSize();
		pack();
		setVisible(true);
	}

	private void bordSize() {

		JPanel panel = new JPanel();
		JButton select = new JButton("Dalej");
		JRadioButton pierwszaOpcja = new JRadioButton("2x2");
		pierwszaOpcja.setSelected(true);
		JRadioButton drugaOpcja = new JRadioButton("3x4");
		JRadioButton trzeciaOpcja = new JRadioButton("4x4");
		{
			ButtonGroup wielkosc = new ButtonGroup();
			wielkosc.add(pierwszaOpcja);
			wielkosc.add(drugaOpcja);
			wielkosc.add(trzeciaOpcja);
		}
		add(panel, BorderLayout.CENTER);
		panel.add(select);
		panel.add(pierwszaOpcja);
		panel.add(drugaOpcja);
		panel.add(trzeciaOpcja);
		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pierwszaOpcja.isSelected()) {
					Plansza1 p = new Plansza1();
					p.setPreferredSize(new Dimension(800, 600));
					p.pack();
					p.setVisible(true);

				} else if (drugaOpcja.isSelected()) {
					Plansza2 p = new Plansza2();
					p.setPreferredSize(new Dimension(800, 600));
					p.pack();
					p.setVisible(true);
				} else {
					Plansza3 p = new Plansza3();
					p.setPreferredSize(new Dimension(800, 600));
					p.pack();
					p.setVisible(true);
				}
			}
		});
	}

}
