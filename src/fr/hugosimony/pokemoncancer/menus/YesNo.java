package fr.hugosimony.pokemoncancer.menus;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.sounds.Sounds;

public class YesNo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static Game game;
	public static YesNo yesNo;
	public static boolean yes;
	
	public YesNo(boolean yes) {
		setLayout(null);
		setVisible(true);
		setOpaque(false);
		YesNo.yes = yes;
	}

	public static void printYesNoMenu() {
		yesNo.setVisible(false);
		yesNo.setLocation(500, 295);
		yesNo.setSize(325,250);
		yesNo.setVisible(true);
		game.gamePanel.add(yesNo);
		yesNo.setVisible(false);
		yesNo.setLocation(605, 295);
		yesNo.setSize(325,250);
		yesNo.setVisible(true);
		game.gamePanel.add(yesNo);
		game.inYesNoMenu = true;
	}
	
	public static void unprintYesNoMenu() {
		yesNo.setVisible(false);
		game.inYesNoMenu = false;
	}
	
	public static void changeYesNoMenu() {
		Sounds.playSound(Const.soundSelectionMenu);
		yesNo.setVisible(false);
		yesNo = new YesNo(!yes);
		yesNo.setVisible(false);
		yesNo.setLocation(500, 295);
		yesNo.setSize(325,250);
		yesNo.setVisible(true);
		game.gamePanel.add(yesNo);
		yesNo.setVisible(false);
		yesNo.setLocation(605, 295);
		yesNo.setSize(325,250);
		yesNo.setVisible(true);
		game.gamePanel.add(yesNo);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(yes)
			g.drawImage(Const.yesNo1.getImage(), 0, 0, null);
		else
			g.drawImage(Const.yesNo2.getImage(), 0, 0, null);
	}
	
}
