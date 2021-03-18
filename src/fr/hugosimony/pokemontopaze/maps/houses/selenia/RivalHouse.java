package fr.hugosimony.pokemontopaze.maps.houses.selenia;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemontopaze.listeners.InteractDispatcher;
import fr.hugosimony.pokemontopaze.listeners.MenuXDispatcher;
import fr.hugosimony.pokemontopaze.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.Selenia;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class RivalHouse extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private boolean up;
	private IntTuple toDownStairs;
	private IntTuple toUpStairs;
	private IntTuple toExit;
	
	public Pnj mom;
	
	public RivalHouse(Game game, boolean up, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.rivalHouse = this;
		this.up = up;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toDownStairs = new IntTuple(5216, 2865);
		toUpStairs = new IntTuple(4480, 2865);
		toExit = new IntTuple(4256, 3217);
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		Musics.startMusic(Const.themeSelenia);
		
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
		if(game.map != null)
			game.map.removeAll();
		if(up) {
			game.map = new Map(3, 1);
			game.map.setLocation(mapLocationX, mapLocationY);
			game.map.setSize(1000000, 1000000);
		}
		else {
			game.map = new Map(3, 0);
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
			game.clickableTiles.add(new IntTuple(5312, 2833)); // SIGN
			game.clickableTiles.add(new IntTuple(5536, 2865)); // TRASH
		}
		else {
			game.clickableTiles.add(new IntTuple(4480, 3153)); // TRASH
		}
		
	}
	
	private void setWalls() {
		game.walls.clear();
		game.walls = new ArrayList<IntTuple>();
		
		if(up) {
			game.walls.add(new IntTuple(5280, 2833));
			game.walls.add(new IntTuple(5312, 2833));
			game.walls.add(new IntTuple(5344, 2833));
			game.walls.add(new IntTuple(5376, 2833));
			game.walls.add(new IntTuple(5408, 2833));
			game.walls.add(new IntTuple(5440, 2833));
			game.walls.add(new IntTuple(5472, 2833));
			game.walls.add(new IntTuple(5504, 2833));
			game.walls.add(new IntTuple(5536, 2833));
			game.walls.add(new IntTuple(5536, 2865));
			game.walls.add(new IntTuple(5568, 2897));
			game.walls.add(new IntTuple(5536, 2929));
			game.walls.add(new IntTuple(5504, 2929));
			game.walls.add(new IntTuple(5472, 2929));
			game.walls.add(new IntTuple(5472, 2961));
			game.walls.add(new IntTuple(5568, 2993));
			game.walls.add(new IntTuple(5536, 3025));
			game.walls.add(new IntTuple(5536, 3057));
			game.walls.add(new IntTuple(5536, 3089));
			game.walls.add(new IntTuple(5504, 3121));
			game.walls.add(new IntTuple(5472, 3121));
			game.walls.add(new IntTuple(5440, 3121));
			game.walls.add(new IntTuple(5408, 3121));
			game.walls.add(new IntTuple(5376, 3121));
			game.walls.add(new IntTuple(5344, 3121));
			game.walls.add(new IntTuple(5312, 3121));
			game.walls.add(new IntTuple(5280, 3121));
			game.walls.add(new IntTuple(5248, 3089));
			game.walls.add(new IntTuple(5248, 3057));
			game.walls.add(new IntTuple(5216, 3089));
			game.walls.add(new IntTuple(5184, 3057));
			game.walls.add(new IntTuple(5184, 3025));
			game.walls.add(new IntTuple(5216, 2993));
			game.walls.add(new IntTuple(5184, 2961));
			game.walls.add(new IntTuple(5216, 2929));
			game.walls.add(new IntTuple(5248, 2929));
			game.walls.add(new IntTuple(5248, 2897));
			game.walls.add(new IntTuple(5504, 2961));
			game.walls.add(new IntTuple(5536, 2961));
		}
		else {
			game.walls.add(new IntTuple(4224, 3185));
			game.walls.add(new IntTuple(4192, 3185));
			game.walls.add(new IntTuple(4160, 3185));
			game.walls.add(new IntTuple(4128, 3185));
			game.walls.add(new IntTuple(4096, 3185));
			game.walls.add(new IntTuple(4064, 3185));
			game.walls.add(new IntTuple(4032, 3185));
			game.walls.add(new IntTuple(4000, 3153));
			game.walls.add(new IntTuple(4000, 3121));
			game.walls.add(new IntTuple(4032, 3089));
			game.walls.add(new IntTuple(4064, 3121));
			game.walls.add(new IntTuple(4096, 3121));
			game.walls.add(new IntTuple(4096, 3089));
			game.walls.add(new IntTuple(4128, 3057));
			game.walls.add(new IntTuple(4128, 3025));
			game.walls.add(new IntTuple(4128, 2993));
			game.walls.add(new IntTuple(4096, 2993));
			game.walls.add(new IntTuple(4064, 2993));
			game.walls.add(new IntTuple(4032, 2961));
			game.walls.add(new IntTuple(4064, 2929));
			game.walls.add(new IntTuple(4096, 2929));
			game.walls.add(new IntTuple(4128, 2929));
			game.walls.add(new IntTuple(4160, 2929));
			game.walls.add(new IntTuple(4192, 2929));
			game.walls.add(new IntTuple(4192, 2897));
			game.walls.add(new IntTuple(4224, 2865));
			game.walls.add(new IntTuple(4256, 2865));
			game.walls.add(new IntTuple(4288, 2865));
			game.walls.add(new IntTuple(4320, 2865));
			game.walls.add(new IntTuple(4352, 2833));
			game.walls.add(new IntTuple(4384, 2833));
			game.walls.add(new IntTuple(4416, 2833));
			game.walls.add(new IntTuple(4448, 2897));
			game.walls.add(new IntTuple(4480, 2929));
			game.walls.add(new IntTuple(4480, 2961));
			game.walls.add(new IntTuple(4448, 2961));
			game.walls.add(new IntTuple(4416, 2961));
			game.walls.add(new IntTuple(4384, 2961));
			game.walls.add(new IntTuple(4384, 2993));
			game.walls.add(new IntTuple(4384, 3025));
			game.walls.add(new IntTuple(4416, 3025));
			game.walls.add(new IntTuple(4448, 3025));
			game.walls.add(new IntTuple(4480, 3025));
			game.walls.add(new IntTuple(4512, 3057));
			game.walls.add(new IntTuple(4480, 3089));
			game.walls.add(new IntTuple(4480, 3121));
			game.walls.add(new IntTuple(4480, 3153));
			game.walls.add(new IntTuple(4448, 3185));
			game.walls.add(new IntTuple(4416, 3185));
			game.walls.add(new IntTuple(4384, 3185));
			game.walls.add(new IntTuple(4352, 3185));
			game.walls.add(new IntTuple(4320, 3185));
			game.walls.add(new IntTuple(4288, 3185));
		}
	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		if(!up) {
			if(Variables.ADVENTURE_Step == 0) {
				mom = new Pnj(game, "mom", Direction.DOWN, 0, 2368, 3025, false, false, null, null, false, false);
				mom.setLocation(2368, 3025);
			}
			else {
				mom = new Pnj(game, "mom", Direction.DOWN, 0, 2368, 2897, false, false, null, null, false, false);
				mom.setLocation(2368, 2897);
			}
			mom.setSize(35, 50);
			game.pnjs.add(mom);
		}
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(up) {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "Note := Pour capturer des Pokémons,= il faut des Poké Balls.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
				 text = "C'est vide.";
			 }
		 }
		 else {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "C'est vide.";
			 }
		 }
		 return text;
	}
	
	public boolean checkAnimations() {
		return false;
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
				 if(game.deplacement.getLookingTile().equals(toDownStairs)){
					 new TransitionSimple(game, game.gamePanel, new RivalHouse(game, false, 4416, 2865, Direction.LEFT, -4014, -2611));
				 }
				 else if(game.deplacement.getLookingTile().equals(toUpStairs)){
					 new TransitionSimple(game, game.gamePanel, new RivalHouse(game, true, 5280, 2865, Direction.RIGHT, -4878, -2611));
				 }
				 else {
					 new TransitionSimple(game, game.gamePanel, new Selenia(game, 1536, 1226, Direction.DOWN, -1163, -968));
				 }
				 return true;
			}
		}
		return false;
	}
}