package fr.hugosimony.pokemontopaze.maps;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.files.adventure.FileAdventureReaderWriter;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.MyHouse;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.RivalHouse;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.SeleniaHouses;
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeHouses;
import fr.hugosimony.pokemontopaze.maps.roads.Road01;
import fr.hugosimony.pokemontopaze.maps.towns.Selenia;
import fr.hugosimony.pokemontopaze.maps.towns.Villaube;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown01;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown02;

public class Map extends JPanel {
	private static final long serialVersionUID = 1L;

	public int map;
	public int floor;
	
	public Map(int map, int floor) {
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		this.map = map;
		this.floor = floor;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.mainMap.getImage(), 0, 0, null);
	}
	
	/*
	 * To do when creating a new map
	 * Ville.java
	 * Game (create the global variable)
	 * InteractDispatcher (check)
	 * Deplacement (checkMapChange)
	 * Deplacement (checkAnimations)
	 * Places
	 * Variables (GroundItems)
	 * Change map and place in the .java
	 * Map (change the spawn location)
	 * Add the trainers if needed
	 * Music
	 */
	
	public static void setMap(Game game, int save) {
		if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 1) {
			game.myHouse = new MyHouse(game, (FileAdventureReaderWriter.getMapFloor(save) == 1), FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.myHouse);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 2) {
			game.selenia = new Selenia(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.selenia);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 3) {
			game.rivalHouse = new RivalHouse(game, (FileAdventureReaderWriter.getMapFloor(save) == 1), FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.rivalHouse);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 4) {
			game.house01 = SeleniaHouses.seleniaHouse01(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house01);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 5) {
			game.house02 = SeleniaHouses.seleniaHouse02(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house02);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 6) {
			game.intertown01 = new Intertown01(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.intertown01);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 7) {
			game.road01 = new Road01(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.road01);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 8) {
			game.intertown02 = new Intertown02(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.intertown02);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 9) {
			game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.villaube);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 10) {
			// labo prof chen
			//game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			//game.add(game.villaube);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 11) {
			// centre poké
			//game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			//game.add(game.villaube);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 12) {
			// pokemart
			//game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			//game.add(game.villaube);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 13) {
			game.house01 = VillaubeHouses.villaubeHouse01(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house01);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 14) {
			game.house02 = VillaubeHouses.villaubeHouse02(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house02);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 15) {
			game.house03 = VillaubeHouses.villaubeHouse03(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house03);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 16) {
			game.house01 = VillaubeHouses.villaubeHouse04(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			game.add(game.house01);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 17) {
			// tour radio
			//game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			//game.add(game.villaube);
		}
		else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 18) {
			// immeuble
			//game.villaube = new Villaube(game, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
			//game.add(game.villaube);
		}
	}
}
