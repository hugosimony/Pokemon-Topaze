package fr.hugosimony.pokemontopaze.maps.houses.special;

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
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeSpecialHouses;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Mart01 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	public IntTuple toExit;
	
	public Mart01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.mart01 = this;
		
		setWalls();
		toExit = new IntTuple(6432, 1322);
		
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
		
		game.walls.add(new IntTuple(6400, 1322));
		game.walls.add(new IntTuple(6368, 1322));
		game.walls.add(new IntTuple(6336, 1290));
		game.walls.add(new IntTuple(6336, 1258));
		game.walls.add(new IntTuple(6304, 1258));
		game.walls.add(new IntTuple(6272, 1226));
		game.walls.add(new IntTuple(6272, 1194));
		game.walls.add(new IntTuple(6304, 1162));
		game.walls.add(new IntTuple(6336, 1162));
		game.walls.add(new IntTuple(6368, 1162));
		game.walls.add(new IntTuple(6400, 1162));
		game.walls.add(new IntTuple(6304, 1130));
		game.walls.add(new IntTuple(6272, 1098));
		game.walls.add(new IntTuple(6304, 1066));
		game.walls.add(new IntTuple(6336, 1066));
		game.walls.add(new IntTuple(6368, 1066));
		game.walls.add(new IntTuple(6400, 1066));
		game.walls.add(new IntTuple(6432, 1066));
		game.walls.add(new IntTuple(6432, 1034));
		game.walls.add(new IntTuple(6432, 1002));
		game.walls.add(new IntTuple(6432, 970));
		game.walls.add(new IntTuple(6464, 938));
		game.walls.add(new IntTuple(6496, 938));
		game.walls.add(new IntTuple(6528, 938));
		game.walls.add(new IntTuple(6560, 938));
		game.walls.add(new IntTuple(6592, 938));
		game.walls.add(new IntTuple(6624, 938));
		game.walls.add(new IntTuple(6656, 938));
		game.walls.add(new IntTuple(6688, 970));
		game.walls.add(new IntTuple(6688, 1002));
		game.walls.add(new IntTuple(6688, 1034));
		game.walls.add(new IntTuple(6688, 1066));
		game.walls.add(new IntTuple(6688, 1098));
		game.walls.add(new IntTuple(6688, 1130));
		game.walls.add(new IntTuple(6688, 1162));
		game.walls.add(new IntTuple(6688, 1194));
		game.walls.add(new IntTuple(6688, 1226));
		game.walls.add(new IntTuple(6688, 1258));
		game.walls.add(new IntTuple(6688, 1290));
		game.walls.add(new IntTuple(6656, 1322));
		game.walls.add(new IntTuple(6624, 1322));
		game.walls.add(new IntTuple(6592, 1322));
		game.walls.add(new IntTuple(6560, 1290));
		game.walls.add(new IntTuple(6560, 1258));
		game.walls.add(new IntTuple(6560, 1226));
		game.walls.add(new IntTuple(6528, 1322));
		game.walls.add(new IntTuple(6496, 1322));
		game.walls.add(new IntTuple(6464, 1322));
		game.walls.add(new IntTuple(6528, 1130));
		game.walls.add(new IntTuple(6560, 1130));
		game.walls.add(new IntTuple(6592, 1130));
		game.walls.add(new IntTuple(6592, 1098));
		game.walls.add(new IntTuple(6592, 1066));
		game.walls.add(new IntTuple(6592, 1034));
		game.walls.add(new IntTuple(6560, 1066));
		game.walls.add(new IntTuple(6560, 1098));
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.map.map == 12)
				return VillaubeSpecialHouses.checkMapChangeMart01();
		}
		return false;
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 return text;
	}
	
	public static void setMap(Game game, Mart01 mart01, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		mart01.add(game.map);
		
		game.actualPanel = mart01;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
	}

}
