package fr.hugosimony.pokemontopaze.maps.houses;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemontopaze.listeners.InteractDispatcher;
import fr.hugosimony.pokemontopaze.listeners.MenuXDispatcher;
import fr.hugosimony.pokemontopaze.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.towns.Villaube;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class House01 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;

	public IntTuple toExit;
	
	public House01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.house01 = this;
		
		setWalls();
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
		
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
	
	public boolean checkMapChange() {
		
		if(!isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toExit)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toExit))
					 Sounds.playSound(Const.soundLeaveHouse);
				 if(game.deplacement.getLookingTile().equals(toExit)){
					 new TransitionSimple(game, game.gamePanel, new Villaube(game, 1280, 5521, Direction.UP, -878, -5267));
				 }
				 else {
					 
				 }
				 return true;
			}
		}
		return false;
	}

}
