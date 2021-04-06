package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;
import fr.hugosimony.pokemontopaze.pokemon.items.Items;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.Utils;

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
	
	public BattlePokemon battlePokemon1;
	public BattlePokemon battlePokemon2;
	
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
		Musics.startMusic(BattleMusics.getGoodMusic(opponent));
		
		Databox databox1 = new Databox(1);
		Databox databox2 = new Databox(2);
		
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
		
		
		Pokemon pokemon1 = new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, Items.NONE);
		Pokemon pokemon2= new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, Items.NONE);
		//Pokemon pokemon1 = new Pokemon(PKM.values()[x], 50, Items.NONE);
		//Pokemon pokemon2 = new Pokemon(PKM.values()[x], 50, Items.NONE);
		try {
			sprite1 = new PokemonSprite(pokemon1, false);
			add(sprite1);
			sprite2 = new PokemonSprite(pokemon2, true);
			add(sprite2);
		} catch (IOException e) {}
		
		battlePokemon1 = new BattlePokemon(pokemon1);
		battlePokemon2 = new BattlePokemon(pokemon2);
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BattleConst.getBackground(background).getImage(), 0, 0, null);
	}
	
	public void startMoves(Move playerMove) {
		//TODO
		// Get the moves in order
		
		// https://github.com/smogon/pokemon-showdown/blob/af8b286d2cfcacfef3d1b799fea611b09ab3ea74/sim/pokemon.ts#L478
		// https://github.com/smogon/pokemon-showdown/blob/af8b286d2cfcacfef3d1b799fea611b09ab3ea74/sim/battle.ts#L2496
		// https://github.com/smogon/pokemon-showdown/blob/af8b286d2cfcacfef3d1b799fea611b09ab3ea74/sim/pokemon.ts#L560
		
		// https://www.pokepedia.fr/Vive_Griffe
	}
	
	public void endBattle(boolean savage, boolean run) {
		setVisible(false);
		game.remove(this);
		Game.battleWin = true; // TODO
		game.actualPanel = savedMap;
		Map.setVisible(game, true);
		new TransitionSimple(game, game.gamePanel, savedMap);
		Musics.startMusic(savedMusic);
		String text = BattlerText.getText(game, opponent, -1);
		if(!text.equals("")) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.inBattle = false;
					game.textZone = new TextZone(game.actualPanel, text);
					TextZone.printTextZone(game.textZone, game);	
				}
			}, 750);
		}
		else
			game.inBattle = false;
	}

	private class Databox extends JPanel{
		private static final long serialVersionUID = 1L;

		int databox;
		
		public Databox(int databox) {
			this.databox = databox;
			setOpaque(false);
			setLayout(null);
			setVisible(true);
		}	

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(databox == 1) // TODO set the coordinates
				g.drawImage(BattleConst.databoxTarget1.getImage(), 0, 0, null);
			else if(databox == 2) // TODO set the coordinates
				g.drawImage(BattleConst.databoxHero1.getImage(), 0, 0, null);
		}
	}
}
