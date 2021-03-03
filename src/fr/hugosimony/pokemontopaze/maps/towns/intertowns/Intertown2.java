package fr.hugosimony.pokemontopaze.maps.towns.intertowns;

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

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemontopaze.listeners.InteractDispatcher;
import fr.hugosimony.pokemontopaze.listeners.MenuXDispatcher;
import fr.hugosimony.pokemontopaze.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.MyHouse;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.roads.Road01;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Intertown2 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	private Clip clipSeleniaTheme;

	private IntTuple toTown2;
	private IntTuple toRoad1;

	private Pnj intertownPnj01;
	private Pnj intertownPnj02;
	
	public Intertown2(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.intertown2 = this;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toTown2 = new IntTuple(3264, 2794);
		toRoad1 = new IntTuple(3264, 3178);
		
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
		game.map = new Map(5, 0);
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
		
		game.clickableTiles.add(new IntTuple(3200, 2922)); // HOST
		game.clickableTiles.add(new IntTuple(3328, 2858)); // SIGN
	}

	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(3232, 3146));
		game.walls.add(new IntTuple(3200, 3114));
		game.walls.add(new IntTuple(3200, 3082));
		game.walls.add(new IntTuple(3200, 3050));
		game.walls.add(new IntTuple(3200, 3018));
		game.walls.add(new IntTuple(3200, 2986));
		game.walls.add(new IntTuple(3200, 2954));
		game.walls.add(new IntTuple(3200, 2922));
		game.walls.add(new IntTuple(3200, 2890));
		game.walls.add(new IntTuple(3200, 2858));
		game.walls.add(new IntTuple(3232, 2826));
		game.walls.add(new IntTuple(3296, 2826));
		game.walls.add(new IntTuple(3328, 2858));
		game.walls.add(new IntTuple(3360, 2890));
		game.walls.add(new IntTuple(3360, 2922));
		game.walls.add(new IntTuple(3360, 2954));
		game.walls.add(new IntTuple(3360, 2986));
		game.walls.add(new IntTuple(3360, 3018));
		game.walls.add(new IntTuple(3328, 3018));
		game.walls.add(new IntTuple(3328, 3050));
		game.walls.add(new IntTuple(3328, 3082));
		game.walls.add(new IntTuple(3328, 3114));
		game.walls.add(new IntTuple(3296, 3146));

	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		intertownPnj01 = new Pnj(game, "police", Direction.RIGHT, 0, 3168, 2922, false, false, null, null, false, false);
		intertownPnj01.setVisible(true);
		intertownPnj01.setSize(35, 50);
		intertownPnj01.setLocation(3168, 2922);
		game.pnjs.add(intertownPnj01);
		
		intertownPnj02 = new Pnj(game, "sellerboy", Direction.RIGHT, 0, 3136, 3018, false, false, null, null, false, false);
		intertownPnj02.setVisible(true);
		intertownPnj02.setSize(35, 50);
		intertownPnj02.setLocation(3136, 3018);
		game.pnjs.add(intertownPnj02);
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
			 text = "Bonjour != En allant au nord, vous arriverez à .= Bonne journée !";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
			 text = "Haut : Ville 2.=\nBas : Route 01.";
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toRoad1) || game.deplacement.getLookingTile().equals(toTown2)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toRoad1) || game.deplacement.getLookingTile().equals(toTown2))
					 Sounds.playSound(Const.soundLeaveHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toTown2)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, true, 1024, 3050, Direction.DOWN, -654, -2788));
				 }
				 else if(game.deplacement.getLookingTile().equals(toRoad1)){
					 new TransitionSimple(game, game.gamePanel, new Road01(game, 3232, 810, Direction.DOWN, -2859, -552));
				 }
				 else {
					 
				 }
				 return true;
			}
		}
		return false;
	}
	
	
}
