package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;
import fr.hugosimony.pokemontopaze.utils.Utils;

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
		
		Pokemon pokemon1 = new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, "");
		Pokemon pokemon2= new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, "");
		try {
			PokemonSprite sprite1 = new PokemonSprite(BattleConst.getAnimatedSprite(pokemon1, false));
			sprite1.setLocation(575, 75);
			sprite1.setSize(100, 100);
			add(sprite1);
			PokemonSprite sprite2 = new PokemonSprite(BattleConst.getAnimatedSprite(pokemon2, true));
			sprite2.setLocation(75, 275);
			sprite2.setSize(100, 100);
			add(sprite2);
		} catch (IOException e) {System.out.println("coucou");}
		

		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BattleConst.getBackground(background).getImage(), 0, 0, null);
	}
}
