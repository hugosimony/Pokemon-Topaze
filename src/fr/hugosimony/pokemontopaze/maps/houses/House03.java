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
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeHouses;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class House03 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	public IntTuple toExit;
	
	public House03(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		this.game = game;
		game.house03 = this;
		
		setWalls();
		toExit = new IntTuple(5472, 2250);
		
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
		
		game.walls.add(new IntTuple(5440, 2250));
		game.walls.add(new IntTuple(5408, 2250));
		game.walls.add(new IntTuple(5376, 2250));
		game.walls.add(new IntTuple(5344, 2218));
		game.walls.add(new IntTuple(5344, 2186));
		game.walls.add(new IntTuple(5312, 2186));
		game.walls.add(new IntTuple(5312, 2218));
		game.walls.add(new IntTuple(5280, 2250));
		game.walls.add(new IntTuple(5248, 2218));
		game.walls.add(new IntTuple(5248, 2186));
		game.walls.add(new IntTuple(5248, 2154));
		game.walls.add(new IntTuple(5280, 2122));
		game.walls.add(new IntTuple(5312, 2122));
		game.walls.add(new IntTuple(5344, 2122));
		game.walls.add(new IntTuple(5344, 2090));
		game.walls.add(new IntTuple(5312, 2090));
		game.walls.add(new IntTuple(5280, 2090));
		game.walls.add(new IntTuple(5248, 2058));
		game.walls.add(new IntTuple(5248, 2026));
		game.walls.add(new IntTuple(5248, 1994));
		game.walls.add(new IntTuple(5248, 1962));
		game.walls.add(new IntTuple(5280, 1930));
		game.walls.add(new IntTuple(5312, 1930));
		game.walls.add(new IntTuple(5344, 1930));
		game.walls.add(new IntTuple(5376, 1930));
		game.walls.add(new IntTuple(5408, 1898));
		game.walls.add(new IntTuple(5440, 1930));
		game.walls.add(new IntTuple(5440, 1962));
		game.walls.add(new IntTuple(5472, 1898));
		game.walls.add(new IntTuple(5504, 1898));
		game.walls.add(new IntTuple(5536, 1930));
		game.walls.add(new IntTuple(5568, 1930));
		game.walls.add(new IntTuple(5600, 1930));
		game.walls.add(new IntTuple(5632, 1930));
		game.walls.add(new IntTuple(5664, 1930));
		game.walls.add(new IntTuple(5696, 1930));
		game.walls.add(new IntTuple(5728, 1962));
		game.walls.add(new IntTuple(5728, 1994));
		game.walls.add(new IntTuple(5728, 2026));
		game.walls.add(new IntTuple(5696, 2058));
		game.walls.add(new IntTuple(5664, 2058));
		game.walls.add(new IntTuple(5632, 2058));
		game.walls.add(new IntTuple(5632, 2090));
		game.walls.add(new IntTuple(5600, 2122));
		game.walls.add(new IntTuple(5568, 2122));
		game.walls.add(new IntTuple(5568, 2154));
		game.walls.add(new IntTuple(5600, 2154));
		game.walls.add(new IntTuple(5632, 2154));
		game.walls.add(new IntTuple(5664, 2090));
		game.walls.add(new IntTuple(5696, 2090));
		game.walls.add(new IntTuple(5728, 2122));
		game.walls.add(new IntTuple(5728, 2154));
		game.walls.add(new IntTuple(5728, 2186));
		game.walls.add(new IntTuple(5696, 2186));
		game.walls.add(new IntTuple(5696, 2218));
		game.walls.add(new IntTuple(5664, 2250));
		game.walls.add(new IntTuple(5632, 2250));
		game.walls.add(new IntTuple(5600, 2250));
		game.walls.add(new IntTuple(5568, 2250));
		game.walls.add(new IntTuple(5536, 2250));
		game.walls.add(new IntTuple(5504, 2250));
		game.walls.add(new IntTuple(5632, 2122));
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.map.map == 15)
				return VillaubeHouses.checkMapChangeHouse03();
		}
		return false;
	}
	
	public static void setMap(Game game, House03 house03, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		house03.add(game.map);
		
		game.actualPanel = house03;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
	}

}
