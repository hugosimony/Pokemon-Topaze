package fr.hugosimony.pokemontopaze.maps.towns;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemontopaze.listeners.InteractDispatcher;
import fr.hugosimony.pokemontopaze.listeners.MenuXDispatcher;
import fr.hugosimony.pokemontopaze.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.MyHouse;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.RivalHouse;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.SeleniaHouses;
import fr.hugosimony.pokemontopaze.maps.items.GroundItem;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown01;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Selenia extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	private IntTuple toMyHouse;
	private IntTuple toRivalHouse;
	private IntTuple toHouse01;
	private IntTuple toHouse02;
	private IntTuple toIntertown01;

	private Pnj police001;
	
	private Pnj seleniaPnj01;
	private Pnj seleniaPnj02;
	
	private GroundItem groundPokeBall1;
	
	public Selenia(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.selenia = this;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toMyHouse = new IntTuple(1248, 1194);
		toRivalHouse = new IntTuple(1536, 1194);
		toHouse01 = new IntTuple(1248, 1482);
		toHouse02 = new IntTuple(1504, 1482);
		toIntertown01 = new IntTuple(2016, 1290);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		Musics.startMusic(Const.themeSelenia);
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		Variables.POSITION_Place = Places.SELENIA;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(2, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		
		add(game.map);
		
		addGroundItems();
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
		
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		game.clickableTiles.add(new IntTuple(1344, 1194)); // LETTER BOX 1 (hero)
		game.clickableTiles.add(new IntTuple(1440, 1194)); // LETTER BOX 2 (friend)
		game.clickableTiles.add(new IntTuple(1408, 1290)); // SIGN
		game.clickableTiles.add(new IntTuple(1344, 1162)); // POT

		game.clickableTiles.add(new IntTuple(1024, 1290)); // GROUND ITEM 1
		groundPokeBall1 = new GroundItem("pokeball");
		groundPokeBall1.setVisible(Variables.GROUND_ITEMS_Selenia.contains("1"));
		groundPokeBall1.setLocation(1024, 1290);
	}
	
	private void addGroundItems() {
		game.map.add(groundPokeBall1);
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		if(Variables.GROUND_ITEMS_Selenia.contains("1"))
			game.walls.add(new IntTuple(1024, 1290));
		
		game.walls.add(new IntTuple(1216, 1194));
		game.walls.add(new IntTuple(1184, 1194));
		game.walls.add(new IntTuple(1184, 1162));
		game.walls.add(new IntTuple(1184, 1130));
		game.walls.add(new IntTuple(1184, 1098));
		game.walls.add(new IntTuple(1152, 1066));
		game.walls.add(new IntTuple(1120, 1066));
		game.walls.add(new IntTuple(1088, 1066));
		game.walls.add(new IntTuple(1056, 1098));
		game.walls.add(new IntTuple(1056, 1130));
		game.walls.add(new IntTuple(1024, 1130));
		game.walls.add(new IntTuple(992, 1162));
		game.walls.add(new IntTuple(992, 1194));
		game.walls.add(new IntTuple(992, 1226));
		game.walls.add(new IntTuple(1024, 1258));
		game.walls.add(new IntTuple(992, 1290));
		game.walls.add(new IntTuple(992, 1322));
		game.walls.add(new IntTuple(1024, 1354));
		game.walls.add(new IntTuple(992, 1386));
		game.walls.add(new IntTuple(992, 1418));
		game.walls.add(new IntTuple(992, 1450));
		game.walls.add(new IntTuple(960, 1482));
		game.walls.add(new IntTuple(960, 1514));
		game.walls.add(new IntTuple(928, 1514));
		game.walls.add(new IntTuple(896, 1514));
		game.walls.add(new IntTuple(896, 1482));
		game.walls.add(new IntTuple(800, 1482));
		game.walls.add(new IntTuple(800, 1514));
		game.walls.add(new IntTuple(800, 1546));
		game.walls.add(new IntTuple(832, 1578));
		game.walls.add(new IntTuple(864, 1578));
		game.walls.add(new IntTuple(896, 1578));
		game.walls.add(new IntTuple(928, 1578));
		game.walls.add(new IntTuple(960, 1578));
		game.walls.add(new IntTuple(992, 1578));
		game.walls.add(new IntTuple(1024, 1578));
		game.walls.add(new IntTuple(1056, 1578));
		game.walls.add(new IntTuple(1088, 1578));
		game.walls.add(new IntTuple(1120, 1578));
		game.walls.add(new IntTuple(1152, 1578));
		game.walls.add(new IntTuple(1184, 1578));
		game.walls.add(new IntTuple(1216, 1578));
		game.walls.add(new IntTuple(1248, 1578));
		game.walls.add(new IntTuple(1280, 1578));
		game.walls.add(new IntTuple(1312, 1578));
		game.walls.add(new IntTuple(1344, 1578));
		game.walls.add(new IntTuple(1376, 1578));
		game.walls.add(new IntTuple(1408, 1578));
		game.walls.add(new IntTuple(1440, 1578));
		game.walls.add(new IntTuple(1472, 1578));
		game.walls.add(new IntTuple(1504, 1578));
		game.walls.add(new IntTuple(1536, 1578));
		game.walls.add(new IntTuple(1568, 1578));
		game.walls.add(new IntTuple(1600, 1578));
		game.walls.add(new IntTuple(1632, 1578));
		game.walls.add(new IntTuple(1664, 1578));
		game.walls.add(new IntTuple(1696, 1578));
		game.walls.add(new IntTuple(1728, 1578));
		game.walls.add(new IntTuple(1760, 1578));
		game.walls.add(new IntTuple(1792, 1546));
		game.walls.add(new IntTuple(1760, 1514));
		game.walls.add(new IntTuple(1728, 1514));
		game.walls.add(new IntTuple(1728, 1482));
		game.walls.add(new IntTuple(1728, 1450));
		game.walls.add(new IntTuple(1760, 1450));
		game.walls.add(new IntTuple(1792, 1450));
		game.walls.add(new IntTuple(1824, 1482));
		game.walls.add(new IntTuple(1856, 1450));
		game.walls.add(new IntTuple(1856, 1418));
		game.walls.add(new IntTuple(1856, 1386));
		game.walls.add(new IntTuple(1888, 1386));
		game.walls.add(new IntTuple(1920, 1386));
		game.walls.add(new IntTuple(1952, 1386));
		game.walls.add(new IntTuple(1984, 1386));
		game.walls.add(new IntTuple(2016, 1386));
		game.walls.add(new IntTuple(2048, 1386));
		game.walls.add(new IntTuple(2080, 1386));
		game.walls.add(new IntTuple(2112, 1354));
		game.walls.add(new IntTuple(2112, 1322));
		game.walls.add(new IntTuple(2080, 1290));
		game.walls.add(new IntTuple(2048, 1290));
		game.walls.add(new IntTuple(1984, 1290));
		game.walls.add(new IntTuple(1952, 1290));
		game.walls.add(new IntTuple(1920, 1290));
		game.walls.add(new IntTuple(1888, 1290));
		game.walls.add(new IntTuple(1856, 1290));
		game.walls.add(new IntTuple(1824, 1290));
		game.walls.add(new IntTuple(1792, 1290));
		game.walls.add(new IntTuple(1760, 1290));
		game.walls.add(new IntTuple(1728, 1290));
		game.walls.add(new IntTuple(1728, 1258));
		game.walls.add(new IntTuple(1728, 1226));
		game.walls.add(new IntTuple(1728, 1194));
		game.walls.add(new IntTuple(1728, 1162));
		game.walls.add(new IntTuple(1696, 1130));
		game.walls.add(new IntTuple(1664, 1130));
		game.walls.add(new IntTuple(1664, 1098));
		game.walls.add(new IntTuple(1632, 1066));
		game.walls.add(new IntTuple(1600, 1098));
		game.walls.add(new IntTuple(1600, 1130));
		game.walls.add(new IntTuple(1600, 1162));
		game.walls.add(new IntTuple(1600, 1194));
		game.walls.add(new IntTuple(1568, 1194));
		game.walls.add(new IntTuple(1504, 1194));
		game.walls.add(new IntTuple(1472, 1194));
		game.walls.add(new IntTuple(1440, 1194));
		game.walls.add(new IntTuple(1440, 1162));
		game.walls.add(new IntTuple(1440, 1130));
		game.walls.add(new IntTuple(1440, 1098));
		game.walls.add(new IntTuple(1408, 1066));
		game.walls.add(new IntTuple(1376, 1098));
		game.walls.add(new IntTuple(1344, 1130));
		game.walls.add(new IntTuple(1344, 1162));
		game.walls.add(new IntTuple(1344, 1194));
		game.walls.add(new IntTuple(1312, 1194));
		game.walls.add(new IntTuple(1280, 1194));
		game.walls.add(new IntTuple(1408, 1290));
		game.walls.add(new IntTuple(1632, 1258));
		game.walls.add(new IntTuple(1664, 1258));
		game.walls.add(new IntTuple(1120, 1450));
		game.walls.add(new IntTuple(1088, 1450));
		game.walls.add(new IntTuple(1216, 1418));
		game.walls.add(new IntTuple(1248, 1418));
		game.walls.add(new IntTuple(1280, 1418));
		game.walls.add(new IntTuple(1312, 1418));
		game.walls.add(new IntTuple(1312, 1450));
		game.walls.add(new IntTuple(1312, 1482));
		game.walls.add(new IntTuple(1280, 1482));
		game.walls.add(new IntTuple(1216, 1482));
		game.walls.add(new IntTuple(1216, 1450));
		game.walls.add(new IntTuple(1472, 1418));
		game.walls.add(new IntTuple(1504, 1418));
		game.walls.add(new IntTuple(1536, 1418));
		game.walls.add(new IntTuple(1568, 1418));
		game.walls.add(new IntTuple(1568, 1450));
		game.walls.add(new IntTuple(1568, 1482));
		game.walls.add(new IntTuple(1536, 1482));
		game.walls.add(new IntTuple(1472, 1482));
		game.walls.add(new IntTuple(1472, 1450));
		
		// Water :
		
		game.walls.add(new IntTuple(1120, 1258));
		game.walls.add(new IntTuple(1088, 1258));
		game.walls.add(new IntTuple(1056, 1258));
		game.walls.add(new IntTuple(1056, 1290));
		game.walls.add(new IntTuple(1088, 1290));
		game.walls.add(new IntTuple(1120, 1290));
		game.walls.add(new IntTuple(1152, 1290));
		game.walls.add(new IntTuple(1152, 1322));
		game.walls.add(new IntTuple(1120, 1322));
		game.walls.add(new IntTuple(1088, 1322));
		game.walls.add(new IntTuple(1056, 1322));
		game.walls.add(new IntTuple(1056, 1354));
		game.walls.add(new IntTuple(1088, 1354));
		game.walls.add(new IntTuple(1120, 1354));
		game.walls.add(new IntTuple(1152, 1354));
	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		police001 = new Pnj(game, "police001", Direction.RIGHT, 0, 896, 1546, false, false, null, null, false, false);
		police001.setVisible(true);
		police001.setSize(35, 50);
		police001.setLocation(896, 1546);
		game.pnjs.add(police001);
		
		int[][] directionsPnj01 = {
				{1, 1, 0},
				{0, 2, 0},
				{0, 1, 1}
		};
		seleniaPnj01 = new Pnj(game, "brownboy001", Direction.DOWN, 0, 1664, 1386, true, true, directionsPnj01, null, false, false);
		seleniaPnj01.setVisible(true);
		seleniaPnj01.setSize(35, 50);
		seleniaPnj01.setLocation(1664, 1386);
		game.pnjs.add(seleniaPnj01);
		
		int[][] directionsPnj02 = {
				{0, 0, 1, 1, 0},
				{0, 0, 1, 0, 0},
				{1, 1, 2, 1, 1}
		};
		seleniaPnj02 = new Pnj(game, "browngirl001", Direction.UP, 0, 1376, 1546, true, true, directionsPnj02, null, false, false);
		seleniaPnj02.setVisible(true);
		seleniaPnj02.setSize(35, 50);
		seleniaPnj02.setLocation(1376, 1546);
		game.pnjs.add(seleniaPnj02);
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 int position = IntTuple.getPosition(game.clickableTiles, tuple);
		 if(position == 1)
			 text = "Chez " + Variables.PERSO_Name + ".";
		 else if(position == 2)
			 text = "Chez " + Variables.RIVAL_Name + ".";
		 else if(position == 3)
			 text = "Sélénia.= Une ville calme et symbole de sérénité.";
		 else if(position == 4 && Variables.GROUND_ITEMS_Selenia.contains("0")) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Selenia.remove("0");
			 // Ajouter une potion au sac.
			 text = "Vous avez ramassé une Potion !";
		 }
		 else if(position == 5 && Variables.GROUND_ITEMS_Selenia.contains("1")) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Selenia.remove("1");
			 groundPokeBall1.setVisible(false);
			 IntTuple.removeTuple(game.walls, new IntTuple(1024, 1290));
			 // Ajouter une Hyper Ball au sac.
			 text = "Vous avez ramassé une Hyper Ball !";
		 }
		 //****************************
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.deplacement.getPosition().equals(toMyHouse) || game.deplacement.getPosition().equals(toRivalHouse)
					|| game.deplacement.getPosition().equals(toHouse01) || game.deplacement.getPosition().equals(toHouse02)
					|| game.deplacement.getPosition().equals(toIntertown01)) {
				game.deplacement.hero.setVisible(false);
				setVisible(false);
				Sounds.playSound(Const.soundEnterHouse);
				if(game.deplacement.getPosition().equals(toMyHouse))
					new TransitionSimple(game, game.gamePanel, new MyHouse(game, false, 2176, 3153, Direction.UP, -1774, -2899));
				else if(game.deplacement.getPosition().equals(toRivalHouse))
					new TransitionSimple(game, game.gamePanel, new RivalHouse(game, false, 4256, 3153, Direction.UP, -3854, -2899));
				else if(game.deplacement.getPosition().equals(toHouse01))
					new TransitionSimple(game, game.gamePanel, SeleniaHouses.seleniaHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toHouse02))
					new TransitionSimple(game, game.gamePanel, SeleniaHouses.seleniaHouse02(game, 6464, 3114, Direction.UP, -6091, -2856));
				else if(game.deplacement.getPosition().equals(toIntertown01))
					new TransitionSimple(game, game.gamePanel, new Intertown01(game, 3264, 3114, Direction.UP, -2891, -2856));
				return true;
			}
		}
		return false;
	}
	
}
