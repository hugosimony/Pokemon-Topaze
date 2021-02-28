package fr.hugosimony.pokemoncancer.pokemon.battle;

import javax.swing.JButton;

public class BattleButtons {
	
	public static class Bag extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Bag() {
			setSize(195, 118);
			setIcon(BattleConst.bagButton);
			setBorderPainted(false);
		}
		
	}
	
	public static class Fight extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Fight() {
			setSize(190, 118);
			setIcon(BattleConst.fightButton);
			setBorderPainted(false);
		}
		
	}
	
	public static class Pokemon extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Pokemon() {
			setSize(195, 118);
			setIcon(BattleConst.pokemonButton);
			setBorderPainted(false);
		}
		
	}
	
	public static class Run extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Run() {
			setSize(190, 118);
			setIcon(BattleConst.runButton);
			setBorderPainted(false);
		}
	}
	
}
