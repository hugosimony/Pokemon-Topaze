package fr.hugosimony.pokemontopaze.maps.houses;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemontopaze.listeners.InteractDispatcher;
import fr.hugosimony.pokemontopaze.listeners.MenuXDispatcher;
import fr.hugosimony.pokemontopaze.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.SeleniaHouses;
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeHouses;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class House02 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;

	public IntTuple toExit;
	
	public House02(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.house02 = this;
		
		setWalls();
		toExit = new IntTuple(6464, 3146);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
	}

	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(6432, 3146));
		game.walls.add(new IntTuple(6400, 3146));
		game.walls.add(new IntTuple(6368, 3146));
		game.walls.add(new IntTuple(6336, 3146));
		game.walls.add(new IntTuple(6304, 3114));
		game.walls.add(new IntTuple(6304, 3082));
		game.walls.add(new IntTuple(6272, 3146));
		game.walls.add(new IntTuple(6240, 3114));
		game.walls.add(new IntTuple(6240, 3082));
		game.walls.add(new IntTuple(6240, 3050));
		game.walls.add(new IntTuple(6240, 3018));
		game.walls.add(new IntTuple(6272, 2986));
		game.walls.add(new IntTuple(6304, 2986));
		game.walls.add(new IntTuple(6336, 2986));
		game.walls.add(new IntTuple(6336, 2954));
		game.walls.add(new IntTuple(6304, 2954));
		game.walls.add(new IntTuple(6272, 2954));
		game.walls.add(new IntTuple(6240, 2922));
		game.walls.add(new IntTuple(6240, 2890));
		game.walls.add(new IntTuple(6240, 2858));
		game.walls.add(new IntTuple(6240, 2826));
		game.walls.add(new IntTuple(6272, 2794));
		game.walls.add(new IntTuple(6304, 2794));
		game.walls.add(new IntTuple(6336, 2794));
		game.walls.add(new IntTuple(6368, 2794));
		game.walls.add(new IntTuple(6400, 2794));
		game.walls.add(new IntTuple(6432, 2794));
		game.walls.add(new IntTuple(6464, 2794));
		game.walls.add(new IntTuple(6496, 2794));
		game.walls.add(new IntTuple(6528, 2794));
		game.walls.add(new IntTuple(6560, 2826));
		game.walls.add(new IntTuple(6592, 2826));
		game.walls.add(new IntTuple(6624, 2826));
		game.walls.add(new IntTuple(6656, 2826));
		game.walls.add(new IntTuple(6688, 2858));
		game.walls.add(new IntTuple(6688, 2890));
		game.walls.add(new IntTuple(6656, 2922));
		game.walls.add(new IntTuple(6624, 2922));
		game.walls.add(new IntTuple(6592, 2922));
		game.walls.add(new IntTuple(6560, 2922));
		game.walls.add(new IntTuple(6560, 2954));
		game.walls.add(new IntTuple(6560, 2986));
		game.walls.add(new IntTuple(6592, 2986));
		game.walls.add(new IntTuple(6624, 2986));
		game.walls.add(new IntTuple(6656, 2986));
		game.walls.add(new IntTuple(6688, 3018));
		game.walls.add(new IntTuple(6656, 3050));
		game.walls.add(new IntTuple(6624, 3050));
		game.walls.add(new IntTuple(6592, 3050));
		game.walls.add(new IntTuple(6560, 3050));
		game.walls.add(new IntTuple(6560, 3082));
		game.walls.add(new IntTuple(6560, 3114));
		game.walls.add(new IntTuple(6528, 3146));
		game.walls.add(new IntTuple(6496, 3146));
		game.walls.add(new IntTuple(6368, 2890));
		game.walls.add(new IntTuple(6336, 2890));
		game.walls.add(new IntTuple(6336, 2858));
		game.walls.add(new IntTuple(6368, 2858));
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.map.map == 5)
				return SeleniaHouses.checkMapChangeHouse02();
			if(game.map.map == 14)
				return VillaubeHouses.checkMapChangeHouse02();
		}
		return false;
	}

	public static void setMap(Game game, House02 house02, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		house02.add(game.map);
		
		game.actualPanel = house02;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
	}
	
}
