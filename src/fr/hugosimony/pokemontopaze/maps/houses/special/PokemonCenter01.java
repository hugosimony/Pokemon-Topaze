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
		game.actualPanelString = "pokemonCenter01";
		
		setClickableTiles();
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
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();

		game.clickableTiles.add(new IntTuple(6496, 1962)); // HEAL
		game.clickableTiles.add(new IntTuple(6720, 1962)); // PC
	}

	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(6720, 1962));
		game.walls.add(new IntTuple(6464, 2250));
		game.walls.add(new IntTuple(6432, 2250));
		game.walls.add(new IntTuple(6400, 2250));
		game.walls.add(new IntTuple(6368, 2250));
		game.walls.add(new IntTuple(6336, 2250));
		game.walls.add(new IntTuple(6304, 2218));
		game.walls.add(new IntTuple(6304, 2186));
		game.walls.add(new IntTuple(6272, 2186));
		game.walls.add(new IntTuple(6240, 2154));
		game.walls.add(new IntTuple(6240, 2122));
		game.walls.add(new IntTuple(6240, 2090));
		game.walls.add(new IntTuple(6240, 2058));
		game.walls.add(new IntTuple(6240, 2026));
		game.walls.add(new IntTuple(6240, 1994));
		game.walls.add(new IntTuple(6272, 1962));
		game.walls.add(new IntTuple(6304, 1962));
		game.walls.add(new IntTuple(6336, 1962));
		game.walls.add(new IntTuple(6368, 1962));
		game.walls.add(new IntTuple(6400, 1962));
		game.walls.add(new IntTuple(6432, 1962));
		game.walls.add(new IntTuple(6464, 1962));
		game.walls.add(new IntTuple(6496, 1962));
		game.walls.add(new IntTuple(6528, 1962));
		game.walls.add(new IntTuple(6560, 1962));
		game.walls.add(new IntTuple(6592, 1962));
		game.walls.add(new IntTuple(6624, 1962));
		game.walls.add(new IntTuple(6656, 1962));
		game.walls.add(new IntTuple(6688, 1962));
		game.walls.add(new IntTuple(6752, 1994));
		game.walls.add(new IntTuple(6752, 2026));
		game.walls.add(new IntTuple(6752, 2058));
		game.walls.add(new IntTuple(6720, 2090));
		game.walls.add(new IntTuple(6688, 2090));
		game.walls.add(new IntTuple(6656, 2090));
		game.walls.add(new IntTuple(6752, 2122));
		game.walls.add(new IntTuple(6752, 2154));
		game.walls.add(new IntTuple(6720, 2186));
		game.walls.add(new IntTuple(6688, 2186));
		game.walls.add(new IntTuple(6656, 2186));
		game.walls.add(new IntTuple(6656, 2218));
		game.walls.add(new IntTuple(6624, 2250));
		game.walls.add(new IntTuple(6592, 2218));
		game.walls.add(new IntTuple(6592, 2186));
		game.walls.add(new IntTuple(6592, 2154));
		game.walls.add(new IntTuple(6560, 2250));
		game.walls.add(new IntTuple(6528, 2250));
		game.walls.add(new IntTuple(6336, 2122));
		game.walls.add(new IntTuple(6304, 2122));
		game.walls.add(new IntTuple(6304, 2090));
		game.walls.add(new IntTuple(6336, 2090));
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.map.map == 11)
				return VillaubeSpecialHouses.checkMapChangePokemonCenter01();
		}
		return false;
	}
	
	public String getInteractMessage(IntTuple tuple) {
		String text = "";
		int position = IntTuple.getPosition(game.clickableTiles, tuple);
		if(position == 1)
			text = "Bonjour,= bienvenue au Centre Pokémon.= Voulez-vous soigner\n"
					+ "vos Pokémons ¤";
		else if(position == 2)
			text = "Ouverture du PC.";
		return text;
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
