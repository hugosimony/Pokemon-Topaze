package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;

@SuppressWarnings("unused")
public class Battle extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private String opponent;
	private String background;
	private String weather;
	
	private JPanel savedMap;
	private URL savedMusic;
	
	public PokemonSprite sprite1;
	public PokemonSprite sprite2;
	public int x = 0;
	
	public Battle(Game game, boolean savage, String opponent, String background, String weather, JPanel savedMap) {
		
		this.game = game;
		game.battle = this;
		setBackground(new Color(0, 0, 0));
		
		this.opponent = opponent;
		this.background = background;
		this.weather = weather;
		
		this.savedMap = savedMap;
		this.savedMusic = Main.actualClipURL;
		
		setLayout(null);
		
		game.inBattle = true;
		game.actualPanel = this;
		
		JButton fightButton = new BattleButtons.Fight(this);
		JButton bagButton = new BattleButtons.Bag(this);
		JButton pokemonButton = new BattleButtons.Pokemon(this);
		JButton runButton = new BattleButtons.Run(this);
		
		fightButton.setLocation(2, 447);
		bagButton.setLocation(195, 447);
		pokemonButton.setLocation(394, 447);
		runButton.setLocation(592, 447);
		
		add(fightButton);
		add(bagButton);
		add(pokemonButton);
		add(runButton);
		
		
		//Pokemon pokemon1 = new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, "");
		//Pokemon pokemon2= new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, "");
		Pokemon pokemon1 = new Pokemon(PKM.values()[x], 50, "");
		Pokemon pokemon2 = new Pokemon(PKM.values()[x], 50, "");
		try {
			sprite1 = new PokemonSprite(pokemon1, false);
			add(sprite1);
			sprite2 = new PokemonSprite(pokemon2, true);
			add(sprite2);
		} catch (IOException e) {}
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BattleConst.getBackground(background).getImage(), 0, 0, null);
	}
	
	public void endBattle(boolean savage, boolean run) {
		setVisible(false);
		game.remove(this);
		game.inBattle = false;
		game.actualPanel = savedMap;
		new TransitionSimple(game, game.gamePanel, savedMap);
		Main.actualClip.close();
		Musics.startMusic(savedMusic);
	}
}
