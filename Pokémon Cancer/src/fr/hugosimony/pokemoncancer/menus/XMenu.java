package fr.hugosimony.pokemoncancer.menus;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.sounds.Sounds;

public class XMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	public static Game game;
	private static XMenu XMenu;
	private static Selection selection = new Selection();
	public static int position = 1;
	
	public XMenu() {
		setLayout(null);
		setVisible(true);
		setOpaque(false);
	}
	
	public static void printXMenu() {
		Sounds.playSound(Const.soundOpenMenu);
		XMenu = new XMenu();
		XMenu.setVisible(false);
		XMenu.setLocation(470, 30);
		XMenu.setSize(300,540);
		XMenu.setVisible(true);
		game.gamePanel.add(XMenu);
		XMenu.setVisible(false);
		XMenu.setLocation(470, 30);
		XMenu.setSize(300,540);
		XMenu.setVisible(true);
		game.gamePanel.add(XMenu);
		placeSelection();
		placeSelection();
		game.inXMenu = true;
	}
	
	public static void unprintXMenu() {
		Sounds.playSound(Const.soundOpenMenu);
		XMenu.setVisible(false);
		game.inXMenu = false;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.XMenu.getImage(), 0, 0, null);
	}
	
	public static void changePosition(boolean up) {
		Sounds.playSound(Const.soundSelectionMenu);
		if(!up) {
			if(position == 7)
				position = 1;
			else
				position++;
		}
		else {
			if(position == 1)
				position = 7;
			else
				position--;
		}
		placeSelection();
	}
	
	public static void placeSelection() {
		selection.setVisible(false);
		selection.setLocation(15, 15 + 66 * (position-1));
		selection.setSize(500,500);
		selection.setVisible(true);
		XMenu.add(selection);
	}
	
	private static class Selection extends JPanel {
		private static final long serialVersionUID = 1L;

		public Selection() {
			setLayout(null);
			setVisible(true);
			setOpaque(false);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(Const.XMenuSelection.getImage(), 0, 0, null);
		}
	}
}
