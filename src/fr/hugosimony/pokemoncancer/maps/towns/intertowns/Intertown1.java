package fr.hugosimony.pokemoncancer.maps.towns.intertowns;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
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
import fr.hugosimony.pokemoncancer.maps.roads.Road01;
import fr.hugosimony.pokemoncancer.maps.towns.Selenia;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class Intertown1 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	private Clip clipSeleniaTheme;
	
	private IntTuple toRoad1;
	private IntTuple toSelenia;
	
	public Intertown1(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.intertown1 = this;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toRoad1 = new IntTuple(662, 203);
		toSelenia = new IntTuple(662, 587);
		
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
		game.map = new Map(3, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		
		add(game.map);
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
		
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		game.clickableTiles.add(new IntTuple(598, 331)); // HOST
		game.clickableTiles.add(new IntTuple(726, 267)); // SIGN
	}

	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(630, 555));
		game.walls.add(new IntTuple(598, 523));
		game.walls.add(new IntTuple(598, 491));
		game.walls.add(new IntTuple(598, 459));
		game.walls.add(new IntTuple(598, 427));
		game.walls.add(new IntTuple(598, 395));
		game.walls.add(new IntTuple(598, 363));
		game.walls.add(new IntTuple(598, 331));
		game.walls.add(new IntTuple(598, 299));
		game.walls.add(new IntTuple(598, 267));
		game.walls.add(new IntTuple(630, 235));
		game.walls.add(new IntTuple(694, 235));
		game.walls.add(new IntTuple(726, 267));
		game.walls.add(new IntTuple(758, 299));
		game.walls.add(new IntTuple(758, 331));
		game.walls.add(new IntTuple(758, 363));
		game.walls.add(new IntTuple(758, 395));
		game.walls.add(new IntTuple(726, 427));
		game.walls.add(new IntTuple(726, 459));
		game.walls.add(new IntTuple(726, 491));
		game.walls.add(new IntTuple(726, 523));
		game.walls.add(new IntTuple(694, 555));

	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
			 text = "Bonjour != Faites attention car des Pokémons peuvent vous attaquer\n"
			 		+ "sur la Route 1.= Bonne journée !";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
			 text = "Haut : Route 01.=\nBas : Sélénia.";
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toRoad1) || game.deplacement.getLookingTile().equals(toSelenia)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toRoad1) || game.deplacement.getLookingTile().equals(toSelenia))
					 Sounds.playSound(Const.soundLeaveHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toRoad1)){
					 new TransitionSimple(game, game.gamePanel, new Road01(game, 1693, 1644, Direction.UP, -1305, -1316));
				 }
				 else if(game.deplacement.getLookingTile().equals(toSelenia)){
					 new TransitionSimple(game, game.gamePanel, new Selenia(game, 1750, 806, Direction.DOWN, -1344, -493));//-1344, -493
				 }
				 else {
					 
				 }
				 return true;
			}
		}
		return false;
	}
	
	
}
