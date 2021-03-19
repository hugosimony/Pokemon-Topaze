package fr.hugosimony.pokemontopaze.maps.houses.villaube;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.House01;
import fr.hugosimony.pokemontopaze.maps.houses.House02;
import fr.hugosimony.pokemontopaze.maps.houses.House03;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.Villaube;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;

public class VillaubeHouses {
	
	private static Game game;
	
	public static House01 villaubeHouse01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(13, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House01 house01 = new House01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house01.add(game.map);
		Variables.POSITION_Place = Places.VILLAUBE;
		setPnjsHouse01();
		Musics.startMusic(Const.themeVillaube);
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
				 new TransitionSimple(game, game.gamePanel, new Villaube(game, 1024, 5425, Direction.DOWN, -622, -5171));
			 }
			 return true;
		}
		return false;
	}
	
	public static House02 villaubeHouse02(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(14, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House02 house02 = new House02(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house02.add(game.map);
		Variables.POSITION_Place = Places.VILLAUBE;
		setPnjsHouse02();
		Musics.startMusic(Const.themeVillaube);
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
				 new TransitionSimple(game, game.gamePanel, new Villaube(game, 960, 5201, Direction.DOWN, -558, -4947));
			 }
			 return true;
		}
		return false;
	}
	
	public static House03 villaubeHouse03(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(15, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House03 house03 = new House03(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house03.add(game.map);
		Variables.POSITION_Place = Places.VILLAUBE;
		setPnjsHouse03();
		Musics.startMusic(Const.themeVillaube);
		return house03;
	}
	
	private static void setPnjsHouse03() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangeHouse03() {
		if(game.deplacement.getPosition().equals(game.house03.toExit)) {
			 game.deplacement.hero.setVisible(false);
			 game.house03.setVisible(false);
			 if(game.deplacement.getPosition().equals(game.house03.toExit))
				 Sounds.playSound(Const.soundLeaveHouse);
			 if(game.deplacement.getPosition().equals(game.house03.toExit)){
				 new TransitionSimple(game, game.gamePanel, new Villaube(game, 1792, 4721, Direction.DOWN, -1390, -4467));
			 }
			 return true;
		}
		return false;
	}
	
	public static House01 villaubeHouse04(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		VillaubeHouses.game = game;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(16, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		House01 house04 = new House01(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		house04.add(game.map);
		Variables.POSITION_Place = Places.VILLAUBE;
		setPnjsHouse04();
		Musics.startMusic(Const.themeVillaube);
		return house04;
	}
	
	private static void setPnjsHouse04() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	public static boolean checkMapChangeHouse04() {
		if(game.deplacement.getPosition().equals(game.house01.toExit)) {
			 game.deplacement.hero.setVisible(false);
			 game.house01.setVisible(false);
			 if(game.deplacement.getPosition().equals(game.house01.toExit))
				 Sounds.playSound(Const.soundLeaveHouse);
			 if(game.deplacement.getPosition().equals(game.house01.toExit)){
				 new TransitionSimple(game, game.gamePanel, new Villaube(game, 1376, 4273, Direction.DOWN, -974, -4019));
			 }
			 return true;
		}
		return false;
	}
	
}
