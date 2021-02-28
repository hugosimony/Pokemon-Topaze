package fr.hugosimony.pokemoncancer.pokemon.battle;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.pokemon.PKM;
import fr.hugosimony.pokemoncancer.pokemon.Pokemon;

public class Battle extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private String opponent;
	private String background;
	private String weather;
	
	private JPanel savedMap;
	
	public Battle(Game game, String opponent, String background, String weather, JPanel savedMap) {
		
		this.game = game;
		
		this.opponent = opponent;
		this.background = background;
		this.weather = weather;
		
		this.savedMap = savedMap;
		
		setLayout(null);
		
		game.inBattle = true;
		game.actualPanel = this;
		
		JButton fightButton = new BattleButtons.Fight();
		JButton bagButton = new BattleButtons.Bag();
		JButton pokemonButton = new BattleButtons.Pokemon();
		JButton runButton = new BattleButtons.Run();
		
		fightButton.setLocation(5, 450);
		bagButton.setLocation(200, 450);
		pokemonButton.setLocation(400, 450);
		runButton.setLocation(600, 450);
		
		add(fightButton);
		add(bagButton);
		add(pokemonButton);
		add(runButton);
		
		Pokemon pokemon = new Pokemon(PKM.DRACAUFEU, "yes", null, 1, null, 10, 10, false, 10, 10, 10, 10, 10, 10, 10, null, null, null, null, null, null, "test", false);
		PokemonSprite sprite = new PokemonSprite(pokemon, false);
		add(sprite);
		sprite.setLocation(50, 50);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BattleConst.getBackground(background).getImage(), 0, 0, null);
	}
	
	private class PokemonSprite extends JLabel {
		private static final long serialVersionUID = 1L;
		
		PokemonSprite pkm;
		Pokemon pokemon;
		boolean back;
		
		public PokemonSprite(Pokemon pokemon, boolean back) {
			pkm = this;
			this.pokemon = pokemon;
			this.back = back;
			//setSize(1000, 1000);
			//setOpaque(false);
			//setVisible(true);
			setIcon(BattleConst.getAnimatedSprite(pokemon, back));
		}
		
		/*@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(BattleConst.getAnimatedSprite(pokemon, back).getImage(), 0, 0, this);
		}*/
		
	}
	
}
