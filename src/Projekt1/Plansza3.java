package Projekt1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Plansza3 extends JFrame {

	private List<Card> karty;
	static LocalDateTime czasPo;
	static LocalDateTime czasPrzed;
	static long srednia;
	private Card wybrana;
	private Card pierwsza;
	private Card druga;
	private Timer t;
	private long punkty;

	public Plansza3() {
		czasPrzed = LocalDateTime.now();
		int pary = 8;
		List<Card> cardlist = new ArrayList<Card>();
		List<Integer> cardVals = new ArrayList<Integer>();

		for (int i = 0; i < pary; i++) {
			cardVals.add(i);
			cardVals.add(i);
		}
		Collections.shuffle(cardVals);
		for (int val : cardVals) {
			Card c = new Card();

			c.setID(val);
			c.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wybrana = c;
					doTurn();
				}
			});
			cardlist.add(c);
		}
		this.karty = cardlist;
		t = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chceckCards();
			}
		});

		t.setRepeats(false);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 4));
		for (Card c : karty) {
			pane.add(c);
		}
	}

	public void doTurn() {
		if (pierwsza == null && druga == null) {
			pierwsza = wybrana;
			pierwsza.setText(String.valueOf(pierwsza.getID()));
		}
		if (pierwsza != null && pierwsza != wybrana && druga == null) {
			druga = wybrana;

			druga.setText(String.valueOf(druga.getID()));
			t.start();
		}
	}

	public void chceckCards() {
		if (pierwsza.getID() == druga.getID()) {
			pierwsza.setEnabled(false);
			druga.setEnabled(false);
			pierwsza.setPasuje(true);
			druga.setPasuje(true);
			if (this.isGameWon()) {
				JOptionPane.showMessageDialog(this, "Wygrales");
				czasPo = LocalDateTime.now();
				srednia = ChronoUnit.SECONDS.between(czasPrzed, czasPo);
				punkty = (long) (srednia * Math.PI * 2342);
				String DialogWindow = JOptionPane.showInputDialog("twoj czas to " + srednia + " Podaj swoje imie:");
				if(DialogWindow.isEmpty()) {
					System.exit(0);
				}
				String s = punkty + "<-Punkty " +  " Nick : " + DialogWindow + " Czas : " + srednia  + "\n";
				ArrayList<String> lista = new ArrayList<>();
				lista.add(s);
				Collections.sort(lista);
				File log = new File("/Users/wojciechgorzkos-bukowski/Desktop/test.txt");
				
				try {
					if (!log.exists()) {
						System.out.println("Nie bylo pliku to fo stworzylem");
						log.createNewFile();
					}

					FileWriter fileWriter = new FileWriter(log, true);

					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(s);
					bufferedWriter.close();

				} catch (IOException e) {
					System.out.println("IOIOIOIOIOIOIO!!");
				}

				System.exit(0);

			}
		} else {
			pierwsza.setText("");
			druga.setText("");
		}
		pierwsza = null;
		druga = null;
	}

	public boolean isGameWon() {
		for (Card c : this.karty) {
			if (c.getPasuje() == false) {
				return false;
			}
		}
		return true;
	}
}
