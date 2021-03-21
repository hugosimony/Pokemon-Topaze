package fr.hugosimony.pokemontopaze.maps.houses.villaube;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.special.Mart01;
import fr.hugosimony.pokemontopaze.maps.houses.special.PokemonCenter01;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.Villaube;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;

public class VillaubeSpecialHouses {

	private static Game game;
	
	public static PokemonCenter01 villaubePokemonCenter01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeSpecialHouses.game = game;
		
		PokemonCenter01 pokemonCenter01 = new PokemonCenter01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		setPnjsPokemonCenter01();
		
		Musics.startMusic(Const.themePokemonCenter);
		Variables.POSITION_Place = Places.VILLAUBE;
		
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(11, 0);
		PokemonCenter01.setMap(game, pokemonCenter01, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		return pokemonCenter01;
	}
	
	private static void setPnjsPokemonCenter01() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangePokemonCenter01() {
		if(game.deplacement.getPosition().equals(game.pokemonCenter01.toExit)) {
			game.deplacement.hero.setVisible(false);
			game.pokemonCenter01.setVisible(false);
			Sounds.playSound(Const.soundLeaveHouse);
			if(game.deplacement.getPosition().equals(game.pokemonCenter01.toExit))
				new TransitionSimple(game, game.gamePanel, new Villaube(game, 1440, 5169, Direction.DOWN, -1038, -4915));
			return true;
		}
		return false;
	}
	
	public static Mart01 villaubeMart01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeSpecialHouses.game = game;
		
		Mart01 mart01 = new Mart01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		setPnjsMart01();
		
		Musics.startMusic(Const.themeMart);
		Variables.POSITION_Place = Places.VILLAUBE;
		
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(12, 0);
		Mart01.setMap(game, mart01, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		return mart01;
	}
	
	private static void setPnjsMart01() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangeMart01() {
		if(game.deplacement.getPosition().equals(game.mart01.toExit)) {
			game.deplacement.hero.setVisible(false);
			game.mart01.setVisible(false);
			Sounds.playSound(Const.soundLeaveHouse);
			if(game.deplacement.getPosition().equals(game.mart01.toExit))
				new TransitionSimple(game, game.gamePanel, new Villaube(game, 1504, 4913, Direction.DOWN, -1102, -4659));
			return true;
		}
		return false;
	}
	
}
