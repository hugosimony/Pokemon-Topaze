package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Color;

import javax.swing.JButton;

public class BattleButtons {
	
	public static class Bag extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Bag() {
			setSize(195, 118);
			setBackground(Color.black);
			setIcon(BattleConst.bagButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
		
	}
	
	public static class Fight extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Fight() {
			setSize(190, 118);
			setBackground(Color.black);
			setIcon(BattleConst.fightButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
		
	}
	
	public static class Pokemon extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Pokemon() {
			setSize(195, 118);
			setBackground(Color.black);
			setIcon(BattleConst.pokemonButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
		
	}
	
	public static class Run extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Run() {
			setSize(190, 118);
			setBackground(Color.black);
			setIcon(BattleConst.runButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
	}
	
}
