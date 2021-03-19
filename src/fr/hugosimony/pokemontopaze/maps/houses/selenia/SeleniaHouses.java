package fr.hugosimony.pokemontopaze.maps.houses.selenia;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.House01;
import fr.hugosimony.pokemontopaze.maps.houses.House02;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.Selenia;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;

public class SeleniaHouses {

	private static Game game;
	
	public static House01 seleniaHouse01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		SeleniaHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(4, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House01 house01 = new House01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house01.add(game.map);
		Variables.POSITION_Place = Places.SELENIA;
		setPnjsHouse01();
		Musics.startMusic(Const.themeSelenia);
		return house01;
	}
	
	private static void setPnjsHouse01() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangeHouse01() {
		if(game.deplacement.getPosition().equals(game.house01.toExit)) {
			 game.deplacement.hero.setVisible(false);
			 game.house01.setVisible(false);
			 if(game.deplacement.getPosition().equals(game.house01.toExit))
				 Sounds.playSound(Const.soundLeaveHouse);
			 if(game.deplacement.getPosition().equals(game.house01.toExit)){
				 new TransitionSimple(game, game.gamePanel, new Selenia(game, 1248, 1514, Direction.DOWN, -875, -1256));
			 }
			 return true;
		}
		return false;
	}
	
	public static House02 seleniaHouse02(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		SeleniaHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(5, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House02 house02 = new House02(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house02.add(game.map);
		Variables.POSITION_Place = Places.SELENIA;
		setPnjsHouse02();
		Musics.startMusic(Const.themeSelenia);
		return house02;
	}
	
	private static void setPnjsHouse02() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangeHouse02() {
		if(game.deplacement.getPosition().equals(game.house02.toExit)) {
			 game.deplacement.hero.setVisible(false);
			 game.house02.setVisible(false);
			 if(game.deplacement.getPosition().equals(game.house02.toExit))
				 Sounds.playSound(Const.soundLeaveHouse);
			 if(game.deplacement.getPosition().equals(game.house02.toExit)){
				 new TransitionSimple(game, game.gamePanel, new Selenia(game, 1504, 1514, Direction.DOWN, -1131, -1256));
			 }
			 return true;
		}
		return false;
	}
	
}
