package fr.hugosimony.pokemontopaze.menus;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.timer.GlobalTimer;

public class SaveMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	public static Game game;
	private static SaveMenu saveMenu;
	
	private Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
	
	public static String saveText = "Voulez vous sauvegarder la partie ?£";
	public static String savingText = "Partie en cours de sauvegarde...";
	public static String savedText = "Partie sauvegardée.";
	
	private JLabel placeLabel;
	private NamePanel namePanel;
	private JLabel timeLabel;
	private Badges badgesPanel;
	private JLabel badgesLabel;
	private JLabel pokedexLabel;
	
	public SaveMenu() {
		setLayout(null);
		setVisible(true);
		setOpaque(false);
		
		placeLabel = new JLabel();
		placeLabel.setText(Places.getGoodName(Variables.POSITION_Place));
		placeLabel.setLocation(20,10);
		placeLabel.setSize(600,40);
		placeLabel.setFont(Const.placeSaveFont);
		placeLabel.setForeground(Const.placeSaveColor);
		add(placeLabel);
		
		namePanel = new NamePanel();
		namePanel.setLocation(15,40);
		namePanel.setSize(600,600);
		add(namePanel);
		
		timeLabel = new JLabel();
		timeLabel.setText(GlobalTimer.getGoodPrintedTimer());
		timeLabel.setLocation(120,88);
		timeLabel.setSize(600,40);
		timeLabel.setFont(textFont);
		add(timeLabel);
		
		badgesLabel = new JLabel();
		badgesLabel.setText(Variables.BADGES_NumberOfBadges + "");
		badgesLabel.setLocation(95,130);
		badgesLabel.setSize(600,40);
		badgesLabel.setFont(textFont);
		add(badgesLabel);
		
		badgesPanel = new Badges();
		badgesPanel.setLocation(20,165);
		badgesPanel.setSize(600,600);
		add(badgesPanel);
		
		pokedexLabel = new JLabel();
		pokedexLabel.setText(Variables.POKEDEX_NumberOfSeen + "");
		pokedexLabel.setLocation(110,196);
		pokedexLabel.setSize(600,40);
		pokedexLabel.setFont(textFont);
		add(pokedexLabel);
		
	}
	
	public static void printSaveMenu() {
		saveMenu = new SaveMenu();
		saveMenu.setVisible(false);
		saveMenu.setLocation(25, 25);
		saveMenu.setSize(325,250);
		saveMenu.setVisible(true);
		game.gamePanel.add(saveMenu);
		saveMenu.setVisible(false);
		saveMenu.setLocation(25, 25);
		saveMenu.setSize(325,250);
		saveMenu.setVisible(true);
		game.gamePanel.add(saveMenu);
		game.inSaveMenu = true;
	}
	
	public static void unprintSaveMenu() {
		Sounds.playSound(Const.soundOpenMenu);
		saveMenu.setVisible(false);
		game.inSaveMenu = false;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.saveMenu.getImage(), 0, 0, null);
	}
	
	private class NamePanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private JLabel nameLabel;
		
		public NamePanel() {
			setLayout(null);
			setVisible(true);
			setOpaque(false);
			nameLabel = new JLabel();
			nameLabel.setText(Variables.PERSO_Name);
			nameLabel.setLocation(55,5);
			nameLabel.setSize(400,50);
			nameLabel.setFont(textFont);
			add(nameLabel);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(Variables.PERSO_Sex.equals("boy"))
				g.drawImage(Const.boyFront.getImage(), 0, 0, null);
			else 
				g.drawImage(Const.boyFront.getImage(), 0, 0, null);
		}
	}
	
	private class Badges extends JPanel {
		private static final long serialVersionUID = 1L;

		public Badges() {
			setLayout(null);
			setVisible(true);
			setOpaque(false);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int space = 35;
			if(Variables.BADGES_NumberOfBadges > 0)
				g.drawImage(Const.badge1.getImage(), space*0, 0, null);
			if(Variables.BADGES_NumberOfBadges > 1)
			g.drawImage(Const.badge2.getImage(), space*1, 0, null);
			if(Variables.BADGES_NumberOfBadges > 2)
			g.drawImage(Const.badge3.getImage(), space*2, 0, null);
			if(Variables.BADGES_NumberOfBadges > 3)
			g.drawImage(Const.badge4.getImage(), space*3, 0, null);
			if(Variables.BADGES_NumberOfBadges > 4)
			g.drawImage(Const.badge5.getImage(), space*4, 0, null);
			if(Variables.BADGES_NumberOfBadges > 5)
			g.drawImage(Const.badge6.getImage(), space*5, 0, null);
			if(Variables.BADGES_NumberOfBadges > 6)
			g.drawImage(Const.badge7.getImage(), space*6, 0, null);
			if(Variables.BADGES_NumberOfBadges > 7)
			g.drawImage(Const.badge8.getImage(), space*7, 0, null);
		}
	}
	
}
