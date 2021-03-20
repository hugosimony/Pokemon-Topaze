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

public class PokemonCenter01 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	public IntTuple toExit;
	
	public PokemonCenter01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.pokemonCenter01 = this;
		
		setWalls();
		toExit = new IntTuple(6496, 2250);
		
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
		
		game.walls.add(new IntTuple(5472, 1354));
		game.walls.add(new IntTuple(5440, 1354));
		game.walls.add(new IntTuple(5408, 1354));
		game.walls.add(new IntTuple(5376, 1354));
		game.walls.add(new IntTuple(5344, 1322));
		game.walls.add(new IntTuple(5344, 1290));
		game.walls.add(new IntTuple(5312, 1354));
		game.walls.add(new IntTuple(5280, 1322));
		game.walls.add(new IntTuple(5280, 1290));
		game.walls.add(new IntTuple(5280, 1258));
		game.walls.add(new IntTuple(5280, 1226));
		game.walls.add(new IntTuple(5312, 1194));
		game.walls.add(new IntTuple(5344, 1194));
		game.walls.add(new IntTuple(5376, 1194));
		game.walls.add(new IntTuple(5376, 1162));
		game.walls.add(new IntTuple(5344, 1162));
		game.walls.add(new IntTuple(5312, 1162));
		game.walls.add(new IntTuple(5280, 1130));
		game.walls.add(new IntTuple(5280, 1098));
		game.walls.add(new IntTuple(5280, 1066));
		game.walls.add(new IntTuple(5280, 1034));
		game.walls.add(new IntTuple(5312, 1002));
		game.walls.add(new IntTuple(5344, 1002));
		game.walls.add(new IntTuple(5376, 1002));
		game.walls.add(new IntTuple(5408, 1002));
		game.walls.add(new IntTuple(5440, 1002));
		game.walls.add(new IntTuple(5472, 1002));
		game.walls.add(new IntTuple(5504, 1002));
		game.walls.add(new IntTuple(5536, 1002));
		game.walls.add(new IntTuple(5568, 1002));
		game.walls.add(new IntTuple(5600, 1034));
		game.walls.add(new IntTuple(5632, 1034));
		game.walls.add(new IntTuple(5664, 1034));
		game.walls.add(new IntTuple(5696, 1034));
		game.walls.add(new IntTuple(5728, 1066));
		game.walls.add(new IntTuple(5728, 1098));
		game.walls.add(new IntTuple(5696, 1130));
		game.walls.add(new IntTuple(5664, 1130));
		game.walls.add(new IntTuple(5632, 1130));
		game.walls.add(new IntTuple(5600, 1130));
		game.walls.add(new IntTuple(5600, 1162));
		game.walls.add(new IntTuple(5600, 1194));
		game.walls.add(new IntTuple(5632, 1194));
		game.walls.add(new IntTuple(5664, 1194));
		game.walls.add(new IntTuple(5696, 1194));
		game.walls.add(new IntTuple(5728, 1226));
		game.walls.add(new IntTuple(5696, 1258));
		game.walls.add(new IntTuple(5664, 1258));
		game.walls.add(new IntTuple(5632, 1258));
		game.walls.add(new IntTuple(5600, 1258));
		game.walls.add(new IntTuple(5600, 1290));
		game.walls.add(new IntTuple(5600, 1322));
		game.walls.add(new IntTuple(5568, 1354));
		game.walls.add(new IntTuple(5536, 1354));
		game.walls.add(new IntTuple(5408, 1098));
		game.walls.add(new IntTuple(5376, 1098));
		game.walls.add(new IntTuple(5376, 1066));
		game.walls.add(new IntTuple(5408, 1066));
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.map.map == 11)
				return VillaubeSpecialHouses.checkMapChangePokemonCenter01();
		}
		return false;
	}
	
	public static void setMap(Game game, PokemonCenter01 pokemonCenter01, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		pokemonCenter01.add(game.map);
		
		game.actualPanel = pokemonCenter01;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
	}

}
