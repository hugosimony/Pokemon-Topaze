package fr.hugosimony.pokemontopaze.maps.houses.selenia;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.House01;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class SeleniaHouse01 {

	private static Game game;
	
	public static House01 seleniaHouse01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		SeleniaHouse01.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(4, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House01 house01 = new House01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house01.add(game.map);
		Variables.POSITION_Place = Places.SELENIA;
		setPnjs();
		Musics.startMusic(Const.themeSelenia);
		house01.toExit = new IntTuple(3264, 2794);
		return house01;
	}
	
	private static void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
}
