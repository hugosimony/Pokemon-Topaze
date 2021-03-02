package fr.hugosimony.pokemoncancer.maps.houses;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemoncancer.listeners.InteractDispatcher;
import fr.hugosimony.pokemoncancer.listeners.MenuXDispatcher;
import fr.hugosimony.pokemoncancer.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemoncancer.maps.Deplacement;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.Map;
import fr.hugosimony.pokemoncancer.maps.Places;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.maps.towns.Selenia;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class MyHouse extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private Clip clipSeleniaTheme;
	
	private boolean up;
	private IntTuple toDownStairs;
	private IntTuple toUpStairs;
	private IntTuple toExit;
	
	private Pnj mom;
	
	public MyHouse(Game game, boolean up, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.myHouse = this;
		this.up = up;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toDownStairs = new IntTuple(1184, 2922);
		toUpStairs = new IntTuple(1984, 2865);
		toExit = new IntTuple(2176, 3217);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Const.themeSelenia);
			clipSeleniaTheme = AudioSystem.getClip();
			clipSeleniaTheme.open(audioInput);
			Main.actualClip = clipSeleniaTheme;
			Main.refreshVolume();
			clipSeleniaTheme.start();
			clipSeleniaTheme.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		Variables.POSITION_Place = Places.SELENIA;
		if(up) {
			game.map = new Map(1, 1);
			game.map.setLocation(mapLocationX, mapLocationY);
			game.map.setSize(1000000, 1000000);
		}
		else {
			game.map = new Map(1, 0);
			game.map.setLocation(mapLocationX, mapLocationY);
			game.map.setSize(1000000, 1000000);
			game.map.add(mom);
		}
		add(game.map);
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		if(up) {
			game.clickableTiles.add(new IntTuple(1088, 2890)); // SIGN
			game.clickableTiles.add(new IntTuple(992, 2922)); // CONSOLE
			game.clickableTiles.add(new IntTuple(960, 2922)); // TV
			game.clickableTiles.add(new IntTuple(928, 2922)); // TRASH
			game.clickableTiles.add(new IntTuple(864, 2922)); // BOOK
			game.clickableTiles.add(new IntTuple(1184, 3082)); // COMPUTER
		}
		else {
			game.clickableTiles.add(new IntTuple(2272, 2961)); // TV
			game.clickableTiles.add(new IntTuple(2432, 2865)); // TRASH
			game.clickableTiles.add(new IntTuple(2432, 2961)); // FOOD
		}
		
	}
	
	private void setWalls() {
		game.walls.clear();
		game.walls = new ArrayList<IntTuple>();
		
		if(up) {
			game.walls.add(new IntTuple(1184, 2890));
			game.walls.add(new IntTuple(1152, 2890));
			game.walls.add(new IntTuple(1120, 2890));
			game.walls.add(new IntTuple(1088, 2890));
			game.walls.add(new IntTuple(1056, 2890));
			game.walls.add(new IntTuple(1024, 2890));
			game.walls.add(new IntTuple(992, 2922));
			game.walls.add(new IntTuple(960, 2922));
			game.walls.add(new IntTuple(928, 2922));
			game.walls.add(new IntTuple(896, 2922));
			game.walls.add(new IntTuple(864, 2922));
			game.walls.add(new IntTuple(832, 2954));
			game.walls.add(new IntTuple(832, 2986));
			game.walls.add(new IntTuple(864, 3018));
			game.walls.add(new IntTuple(896, 3018));
			game.walls.add(new IntTuple(928, 3018));
			game.walls.add(new IntTuple(928, 3050));
			game.walls.add(new IntTuple(896, 3050));
			game.walls.add(new IntTuple(864, 3050));
			game.walls.add(new IntTuple(832, 3050));
			game.walls.add(new IntTuple(832, 3082));
			game.walls.add(new IntTuple(864, 3114));
			game.walls.add(new IntTuple(864, 3146));
			game.walls.add(new IntTuple(896, 3178));
			game.walls.add(new IntTuple(928, 3178));
			game.walls.add(new IntTuple(960, 3178));
			game.walls.add(new IntTuple(992, 3178));
			game.walls.add(new IntTuple(1024, 3178));
			game.walls.add(new IntTuple(1056, 3178));
			game.walls.add(new IntTuple(1088, 3178));
			game.walls.add(new IntTuple(1120, 3178));
			game.walls.add(new IntTuple(1152, 3146));
			game.walls.add(new IntTuple(1152, 3114));
			game.walls.add(new IntTuple(1152, 3082));
			game.walls.add(new IntTuple(1184, 3082));
			game.walls.add(new IntTuple(1216, 3050));
			game.walls.add(new IntTuple(1216, 3018));
			game.walls.add(new IntTuple(1184, 2986));
			game.walls.add(new IntTuple(1152, 2954));
		}
		else {
			game.walls.add(new IntTuple(2272, 2961));
			game.walls.add(new IntTuple(2432, 2865));
			game.walls.add(new IntTuple(2432, 2961));
			game.walls.add(new IntTuple(2048, 2833));
			game.walls.add(new IntTuple(2080, 2833));
			game.walls.add(new IntTuple(2112, 2833));
			game.walls.add(new IntTuple(2144, 2833));
			game.walls.add(new IntTuple(2176, 2833));
			game.walls.add(new IntTuple(2208, 2833));
			game.walls.add(new IntTuple(2240, 2833));
			game.walls.add(new IntTuple(2272, 2833));
			game.walls.add(new IntTuple(2304, 2865));
			game.walls.add(new IntTuple(2304, 2897));
			game.walls.add(new IntTuple(2304, 2929));
			game.walls.add(new IntTuple(2304, 2961));
			game.walls.add(new IntTuple(2304, 2993));
			game.walls.add(new IntTuple(2304, 3025));
			game.walls.add(new IntTuple(2208, 2897));
			game.walls.add(new IntTuple(2208, 2929));
			game.walls.add(new IntTuple(2208, 2961));
			game.walls.add(new IntTuple(2208, 2993));
			game.walls.add(new IntTuple(2272, 2929));
			game.walls.add(new IntTuple(2016, 2897));
			game.walls.add(new IntTuple(1984, 2897));
			game.walls.add(new IntTuple(1952, 2929));
			game.walls.add(new IntTuple(1952, 2961));
			game.walls.add(new IntTuple(1984, 2993));
			game.walls.add(new IntTuple(2016, 2993));
			game.walls.add(new IntTuple(2048, 2993));
			game.walls.add(new IntTuple(2080, 2993));
			game.walls.add(new IntTuple(2080, 3025));
			game.walls.add(new IntTuple(2048, 3025));
			game.walls.add(new IntTuple(2016, 3025));
			game.walls.add(new IntTuple(1984, 3025));
			game.walls.add(new IntTuple(1952, 3057));
			game.walls.add(new IntTuple(1952, 3089));
			game.walls.add(new IntTuple(1952, 3121));
			game.walls.add(new IntTuple(1952, 3153));
			game.walls.add(new IntTuple(1984, 3185));
			game.walls.add(new IntTuple(2048, 3185));
			game.walls.add(new IntTuple(2080, 3153));
			game.walls.add(new IntTuple(2080, 3121));
			game.walls.add(new IntTuple(2080, 3089));
			game.walls.add(new IntTuple(2016, 3121));
			game.walls.add(new IntTuple(2016, 3153));
			game.walls.add(new IntTuple(2112, 3185));
			game.walls.add(new IntTuple(2144, 3185));
			game.walls.add(new IntTuple(2208, 3185));
			game.walls.add(new IntTuple(2240, 3185));
			game.walls.add(new IntTuple(2272, 3185));
			game.walls.add(new IntTuple(2304, 3185));
			game.walls.add(new IntTuple(2336, 3185));
			game.walls.add(new IntTuple(2368, 3185));
			game.walls.add(new IntTuple(2400, 3185));
			game.walls.add(new IntTuple(2432, 3185));
			game.walls.add(new IntTuple(2464, 3153));
			game.walls.add(new IntTuple(2464, 3121));
			game.walls.add(new IntTuple(2464, 3089));
			game.walls.add(new IntTuple(2464, 3057));
			game.walls.add(new IntTuple(2464, 3025));
			game.walls.add(new IntTuple(2432, 2993));
			game.walls.add(new IntTuple(2432, 2929));
			game.walls.add(new IntTuple(2432, 2897));
			game.walls.add(new IntTuple(2400, 2833));
			game.walls.add(new IntTuple(2368, 2833));
			game.walls.add(new IntTuple(2336, 2833));
			game.walls.add(new IntTuple(2272, 3121));
			game.walls.add(new IntTuple(2304, 3121));
			game.walls.add(new IntTuple(2336, 3121));
			game.walls.add(new IntTuple(2368, 3121));
			game.walls.add(new IntTuple(2400, 3121));
			game.walls.add(new IntTuple(2368, 3089));
			game.walls.add(new IntTuple(2336, 3089));
			game.walls.add(new IntTuple(2304, 3089));

		}
	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		
		if(!up) {
			mom = new Pnj(game, "mom", Direction.DOWN, 0, 2368, 2897, false, false, null, null, false, false);
			mom.setLocation(2368, 2897);
			mom.setSize(35, 50);
			game.pnjs.add(mom);
		}
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(up) {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "Note : Appuyer sur " + KeyEvent.getKeyText(Variables.CONTROLS_MenuX) + " pour ouvrir le menu.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
				 text = "C'est la console qui appartenait à Papa.= Elle est plus vielle que moi...=\n"
						+ "Pfff, il y a que des jeux nuls.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
				 text = "Trop bien ! Touche pas à mon Pokémon != Mais bon... =le Prof Chen\n"
						 + " m'attends.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 4) {
				 text = "Merde j'ai oublié de vider ma poubelle.= Faudra vraiment que je le\n"
						 + "fasse...= J'ai pas envie d'être puni" + Variables.LANG_Feminin + " pendant un mois.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 5) {
				 text = "J'ai pas trop compris pourquoi, mais...= je vais avoir mon premier\n"
						 + "Pokémon != Par contre, le Prof est un peu bizarre avec ma mère...";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 6) {
				 text = "Le film d'hier soir était vraiment nul.";
			 }
		 }
		 else {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "Poké-Achat...= Maman c'est vraiment nul sérieux.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
				 text = "C'est vide.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
				 text = "Sah quel plaisir != Un bon Katsu Curry.";
			 }
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if((game.deplacement.getLookingTile().equals(toDownStairs) && up) || (game.deplacement.getLookingTile().equals(toUpStairs) && !up) || (game.deplacement.getLookingTile().equals(toExit) && !up)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toDownStairs) || game.deplacement.getLookingTile().equals(toUpStairs))
					 Sounds.playSound(Const.soundEnterHouse);
				 else
					 Sounds.playSound(Const.soundLeaveHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toDownStairs)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, false, 2048, 2865, Direction.RIGHT, -1646, -2611));
				 }
				 else if(game.deplacement.getLookingTile().equals(toUpStairs)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, true, 1120, 2922, Direction.LEFT, -747, -2664));
				 }
				 else {
					 new TransitionSimple(game, game.gamePanel, new Selenia(game, 1248, 1226, Direction.DOWN, -875, -968));
				 }
				 return true;
			}
		}
		return false;
	}
	
	
	
}
