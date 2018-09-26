package Projekt1;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Card extends JButton {
	private int id;
	private boolean matched = false;

	public Card() {
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setPasuje(boolean matched) {
		this.matched = matched;
	}

	public boolean getPasuje() {
		return this.matched;
	}

}
