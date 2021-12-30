package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	
	public static BattlePresets presets;
	
	private String opponent;
	private String background;
	private String weather;
	private String ground;
	
	private JPanel savedMap;
	private URL savedMusic;
	
	public PokemonSprite sprite1;
	public PokemonSprite sprite2;
	
	public BattlePokemon battlePokemon1; // Opponent
	public BattlePokemon battlePokemon2; // Player
	
	public BattleButtons.Fight fightButton;
	public BattleButtons.Bag bagButton;
	public BattleButtons.Pokemon pokemonButton;
	public BattleButtons.Run runButton;
	
	public BattleButtons.MovePanel move1;
	public BattleButtons.MovePanel move2;
	public BattleButtons.MovePanel move3;
	public BattleButtons.MovePanel move4;
	
	public Databox playerBox;
	public Databox opponentBox;
	
	public int x = 0;
	
	public Battle(Game game, boolean savage, JPanel savedMap) {
	
		Pokemon pokemon1 = new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, Items.NONE);
		Pokemon pokemon2 = new Pokemon(PKM.values()[Utils.randomNumber(150)], 50, Items.NONE);
		//Pokemon pokemon1 = new Pokemon(PKM.values()[x], 50, Items.NONE);
		//Pokemon pokemon2 = new Pokemon(PKM.values()[x], 50, Items.NONE);
		
		battlePokemon1 = new BattlePokemon(this, pokemon1);
		battlePokemon2 = new BattlePokemon(this, pokemon2);
		
		this.game = game;
		game.battle = this;
		setBackground(new Color(0, 0, 0));
		
		this.opponent = presets.opponent;
		this.weather = presets.weather;
		this.background = presets.background;
		this.ground = presets.ground;
		
		this.savedMap = savedMap;
		this.savedMusic = Main.actualClipURL;
		
		setLayout(null);
		
		game.inBattle = true;
		game.actualPanel = this;
		Musics.startMusic(BattleMusics.getGoodMusic(opponent));
		
		fightButton = new BattleButtons.Fight(this);
		bagButton = new BattleButtons.Bag(this);
		pokemonButton = new BattleButtons.Pokemon(this);
		runButton = new BattleButtons.Run(this);
		
		fightButton.setLocation(2, 446);
		bagButton.setLocation(195, 446);
		pokemonButton.setLocation(394, 446);
		runButton.setLocation(592, 446);
		
		add(fightButton);
		add(bagButton);
		add(pokemonButton);
		add(runButton);
		
		move1 = new BattleButtons.MovePanel(this, battlePokemon2.move1, 1);
		move2 = new BattleButtons.MovePanel(this, battlePokemon2.move2, 2);
		move3 = new BattleButtons.MovePanel(this, battlePokemon2.move3, 3);
		move4 = new BattleButtons.MovePanel(this, battlePokemon2.move4, 4);
		
		move1.setVisible(false);
		move2.setVisible(false);
		move3.setVisible(false);
		move4.setVisible(false);
		
		move1.setLocation(1, 446);
		move2.setLocation(197, 446);
		move3.setLocation(393, 446);
		move4.setLocation(589, 446);
		
		add(move1);
		add(move2);
		add(move3);
		add(move4);
		
		playerBox = new Databox(true);
		opponentBox = new Databox(false);
		
		playerBox.setLocation(485, 300);
		opponentBox.setLocation(0, 30);
		
		playerBox.setSize(400, 200);
		opponentBox.setSize(400, 200);
		
		add(playerBox);
		add(opponentBox);
		
		try {
			sprite1 = new PokemonSprite(pokemon1, false);
			add(sprite1);
			sprite2 = new PokemonSprite(pokemon2, true);
			add(sprite2);
		} catch (IOException e) {}
		
		battlePokemon1 = new BattlePokemon(this, pokemon1);
		battlePokemon2 = new BattlePokemon(this, pokemon2);
		
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
		
		// Player move
		new BattleMove(this, battlePokemon2, battlePokemon1, playerMove, false, 0, false, true);
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
	
	public void updateData() {
		opponentBox.updateData();
		playerBox.updateData();
	}

	public class Databox extends JPanel{
		private static final long serialVersionUID = 1L;

		private Font nameFont = new Font("Power Clear", Font.BOLD, 27);
		private Font levelFont = new Font("Power Clear", Font.PLAIN, 24);
		private Font hpFont = new Font("Power Clear", Font.BOLD, 22);
		
		boolean player;
		JLabel name;
		JLabel gender;
		JLabel level;
		JLabel hpBar;
		JLabel hp;
		
		public Databox(boolean player) {
			this.player = player;
			
			setOpaque(false);
			setLayout(null);
			
			name = new JLabel();
			name.setFont(nameFont);
			name.setVerticalAlignment(JLabel.CENTER);
			name.setSize(150, 50);
			if(player)
				name.setLocation(45, 0);
			else
				name.setLocation(15, 0);
			
			gender = new JLabel();
			
			level = new JLabel();
			level.setFont(levelFont);
			level.setVerticalAlignment(JLabel.CENTER);
			level.setSize(200, 50);
			if(player)
				level.setLocation(250, 0);
			else
				level.setLocation(220, 0);
			
			hpBar = new JLabel();
			if(player)
				hpBar.setLocation(135, 55);
			else
				hpBar.setLocation(104, 55);
			
			if(player) {
				hp = new JLabel();
				hp.setFont(hpFont);
				hp.setVerticalAlignment(JLabel.CENTER);
				hp.setHorizontalAlignment(JLabel.CENTER);
				hp.setSize(105, 20);
				hp.setLocation(130, 63);
			}
			
			
			updateData();
			initHP(player ? battlePokemon2 : battlePokemon1);
			
			add(name);
			add(gender);
			add(level);
			add(hpBar);
			if(player)
				add(hp);
			
			repaint();
		}	

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(player)
				g.drawImage(BattleConst.databoxHero1.getImage(), 0, 0, null);
			else 
				g.drawImage(BattleConst.databoxTarget1.getImage(), 0, 0, null);
		}
		
		public void updateData() {
			BattlePokemon bp = player ? battlePokemon2 : battlePokemon1;
			name.setText(bp.name);
			level.setText("N." + bp.level);
			updateHp(bp);
		}
		
		public void initHP(BattlePokemon bp) {
			if(player)
				hp.setText(bp.currentHP + "/" + bp.HP);
			float ladder = (float) ((float) bp.currentHP / (float) bp.HP);
			hpBar.setSize((int) (154 * ladder), 6);
			if(bp.currentHP > (int) (bp.HP / 2)) {
				if(hpBar.getIcon() != BattleConst.greenLife)
					hpBar.setIcon(BattleConst.greenLife);
			}
			else if(bp.currentHP > (int) (bp.HP/5)) {
				if(hpBar.getIcon() != BattleConst.orangeLife)
					hpBar.setIcon(BattleConst.orangeLife);
			}
			else {
				if(hpBar.getIcon() != BattleConst.redLife) {
					hpBar.setIcon(BattleConst.redLife);
					// TODO Critical life sound
				}
			}
		}
		
		public void updateHp(BattlePokemon bp) {
			 new Timer().scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					if(bp.oldCurrentHP == bp.currentHP)
						this.cancel();
					else {
						if(bp.oldCurrentHP > bp.currentHP)
							bp.oldCurrentHP--;
						else
							bp.oldCurrentHP++;
						if(player)
							hp.setText(bp.oldCurrentHP + "/" + bp.HP);
						float ladder = (float) ((float) bp.oldCurrentHP / (float) bp.HP);
						hpBar.setSize((int) (154 * ladder), 6);
						if(bp.oldCurrentHP > (int) (bp.HP / 2)) {
							if(hpBar.getIcon() != BattleConst.greenLife)
								hpBar.setIcon(BattleConst.greenLife);
						}
						else if(bp.oldCurrentHP > (int) (bp.HP/5)) {
							if(hpBar.getIcon() != BattleConst.orangeLife)
								hpBar.setIcon(BattleConst.orangeLife);
						}
						else {
							if(hpBar.getIcon() != BattleConst.redLife) {
								hpBar.setIcon(BattleConst.redLife);
								// TODO Critical life sound
							}
						}
					}
				}
			}, 0, 20);
		}
		
	}
	
	public void printAbility(BattlePokemon bp) {
		// TODO
	}
	
	public void printItem(BattlePokemon bp) {
		// TODO
	}
	
	public static class BattlePresets {

		public String opponent;
		public String weather;
		public String background;
		public String ground;
		
		public BattlePresets(String opponent, String weather, String background, String ground) {
			this.opponent = opponent;
			this.weather = weather;
			this.background = background;
			this.ground = ground;
		}
	}
}
