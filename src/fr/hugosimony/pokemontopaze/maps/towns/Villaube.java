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
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeHouses;
import fr.hugosimony.pokemontopaze.maps.houses.villaube.VillaubeSpecialHouses;
import fr.hugosimony.pokemontopaze.maps.items.GroundItem;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown02;
import fr.hugosimony.pokemontopaze.musics.Musics;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Villaube extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;

	private IntTuple toIntertown02;
	private IntTuple toLabo;
	private IntTuple toPokemonCenter;
	private IntTuple toMart;
	private IntTuple toRadioTower;
	private IntTuple toHouse01;
	private IntTuple toHouse02;
	private IntTuple toHouse03;
	private IntTuple toHouse04;
	private IntTuple toBuilding01;
	private IntTuple toBuilding02;
	private IntTuple toIntertown03;
	// private IntTuple toIntertownXX;
	
	//private Pnj villaubePnj01;
	//private Pnj villaubePnj02;
	
	private GroundItem groundPokeBall1;
	
	public Villaube(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.villaube = this;
		game.actualPanelString = "villaube";
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toIntertown02 = new IntTuple(1280, 5553);
		toLabo = new IntTuple(1440, 5393);
		toPokemonCenter = new IntTuple(1440, 5137);
		toMart = new IntTuple(1504, 4881);
		toRadioTower = new IntTuple(1024, 4977);
		toHouse01 = new IntTuple(1024, 5393);
		toHouse02 = new IntTuple(960, 5169);
		toHouse03 = new IntTuple(1792, 4689);
		toHouse04 = new IntTuple(1376, 4241);
		toBuilding01 = new IntTuple(1632, 5297);
		toBuilding02 = new IntTuple(1728, 5297);
		toIntertown03 = new IntTuple(800, 4561);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		Musics.startMusic(Const.themeVillaube);
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		Variables.POSITION_Place = Places.VILLAUBE;
		if(game.map != null)
			game.map.removeAll();
		game.map = new Map(9, 0);
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
		
		game.clickableTiles.add(new IntTuple(1088, 4977)); // RADIO TOWER
		game.clickableTiles.add(new IntTuple(1216, 5137)); // TOWN SIGN
		game.clickableTiles.add(new IntTuple(1504, 5425)); // LETTER BOX PROF CHEN
		game.clickableTiles.add(new IntTuple(1856, 5009)); // WOODEN SIGN
		game.clickableTiles.add(new IntTuple(1344, 4657)); // STATUE
		game.clickableTiles.add(new IntTuple(1344, 4433)); // ROAD SIGN
		game.clickableTiles.add(new IntTuple(2752, 4273)); // ROAD SIGN 2
		game.clickableTiles.add(new IntTuple(2784, 4273)); // ROAD SIGN 2
		game.clickableTiles.add(new IntTuple(1632, 4241)); // CLOSED HOUSE 1
		game.clickableTiles.add(new IntTuple(960, 4369));  // CLOSED HOUSE 2
		game.clickableTiles.add(new IntTuple(1792, 5297)); // MARTIN'S BOX

		game.clickableTiles.add(new IntTuple(864, 4657)); // GROUND ITEM 1
		groundPokeBall1 = new GroundItem("pokeball");
		groundPokeBall1.setVisible(Variables.GROUND_ITEMS_Villaube.contains("0"));
		groundPokeBall1.setLocation(864, 4657);
		
	}
	
	private void addGroundItems() {
		game.map.add(groundPokeBall1);
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		if(Variables.GROUND_ITEMS_Villaube.contains("0"))
			game.walls.add(new IntTuple(864, 4657));
		
		// Closed Houses
		game.walls.add(new IntTuple(1632, 4241));
		game.walls.add(new IntTuple(960, 4369));
		
		game.walls.add(new IntTuple(2752, 4273));
		game.walls.add(new IntTuple(2784, 4273));
		game.walls.add(new IntTuple(1248, 5553));
		game.walls.add(new IntTuple(1216, 5553));
		game.walls.add(new IntTuple(1184, 5585));
		game.walls.add(new IntTuple(1152, 5585));
		game.walls.add(new IntTuple(1120, 5553));
		game.walls.add(new IntTuple(1088, 5553));
		game.walls.add(new IntTuple(1056, 5521));
		game.walls.add(new IntTuple(1056, 5489));
		game.walls.add(new IntTuple(1056, 5457));
		game.walls.add(new IntTuple(1024, 5457));
		game.walls.add(new IntTuple(992, 5457));
		game.walls.add(new IntTuple(960, 5457));
		game.walls.add(new IntTuple(960, 5425));
		game.walls.add(new IntTuple(992, 5393));
		game.walls.add(new IntTuple(1056, 5393));
		game.walls.add(new IntTuple(1088, 5393));
		game.walls.add(new IntTuple(1088, 5361));
		game.walls.add(new IntTuple(1088, 5329));
		game.walls.add(new IntTuple(1056, 5329));
		game.walls.add(new IntTuple(1024, 5329));
		game.walls.add(new IntTuple(992, 5329));
		game.walls.add(new IntTuple(960, 5329));
		game.walls.add(new IntTuple(928, 5329));
		game.walls.add(new IntTuple(896, 5297));
		game.walls.add(new IntTuple(896, 5265));
		game.walls.add(new IntTuple(864, 5233));
		game.walls.add(new IntTuple(864, 5201));
		game.walls.add(new IntTuple(832, 5169));
		game.walls.add(new IntTuple(832, 5137));
		game.walls.add(new IntTuple(832, 5105));
		game.walls.add(new IntTuple(832, 5073));
		game.walls.add(new IntTuple(832, 5041));
		game.walls.add(new IntTuple(832, 5009));
		game.walls.add(new IntTuple(832, 4977));
		game.walls.add(new IntTuple(832, 4945));
		game.walls.add(new IntTuple(832, 4913));
		game.walls.add(new IntTuple(832, 4881));
		game.walls.add(new IntTuple(832, 4849));
		game.walls.add(new IntTuple(832, 4817));
		game.walls.add(new IntTuple(832, 4785));
		game.walls.add(new IntTuple(832, 4753));
		game.walls.add(new IntTuple(832, 4721));
		game.walls.add(new IntTuple(832, 4689));
		game.walls.add(new IntTuple(832, 4657));
		game.walls.add(new IntTuple(832, 4625));
		game.walls.add(new IntTuple(864, 4625));
		game.walls.add(new IntTuple(896, 4625));
		game.walls.add(new IntTuple(896, 4657));
		game.walls.add(new IntTuple(896, 4689));
		game.walls.add(new IntTuple(896, 4721));
		game.walls.add(new IntTuple(896, 4753));
		game.walls.add(new IntTuple(896, 4785));
		game.walls.add(new IntTuple(896, 4817));
		game.walls.add(new IntTuple(896, 4849));
		game.walls.add(new IntTuple(896, 4881));
		game.walls.add(new IntTuple(896, 4913));
		game.walls.add(new IntTuple(896, 4945));
		game.walls.add(new IntTuple(928, 4945));
		game.walls.add(new IntTuple(960, 4945));
		game.walls.add(new IntTuple(992, 4977));
		game.walls.add(new IntTuple(1056, 4977));
		game.walls.add(new IntTuple(1088, 4977));
		game.walls.add(new IntTuple(1120, 4945));
		game.walls.add(new IntTuple(1152, 4977));
		game.walls.add(new IntTuple(1152, 4945));
		game.walls.add(new IntTuple(1152, 4913));
		game.walls.add(new IntTuple(1152, 4881));
		game.walls.add(new IntTuple(1152, 4849));
		game.walls.add(new IntTuple(1152, 4817));
		game.walls.add(new IntTuple(1152, 4785));
		game.walls.add(new IntTuple(1152, 4753));
		game.walls.add(new IntTuple(1152, 4721));
		game.walls.add(new IntTuple(1152, 4689));
		game.walls.add(new IntTuple(1120, 4689));
		game.walls.add(new IntTuple(1088, 4689));
		game.walls.add(new IntTuple(1056, 4657));
		game.walls.add(new IntTuple(1056, 4625));
		game.walls.add(new IntTuple(1024, 4625));
		game.walls.add(new IntTuple(992, 4625));
		game.walls.add(new IntTuple(960, 4625));
		game.walls.add(new IntTuple(928, 4625));
		game.walls.add(new IntTuple(800, 4593));
		game.walls.add(new IntTuple(832, 4529));
		game.walls.add(new IntTuple(832, 4497));
		game.walls.add(new IntTuple(864, 4465));
		game.walls.add(new IntTuple(896, 4465));
		game.walls.add(new IntTuple(896, 4433));
		game.walls.add(new IntTuple(896, 4401));
		game.walls.add(new IntTuple(896, 4369));
		game.walls.add(new IntTuple(928, 4369));
		game.walls.add(new IntTuple(992, 4369));
		game.walls.add(new IntTuple(1024, 4401));
		game.walls.add(new IntTuple(1056, 4401));
		game.walls.add(new IntTuple(1088, 4433));
		game.walls.add(new IntTuple(1056, 4465));
		game.walls.add(new IntTuple(1088, 4465));
		game.walls.add(new IntTuple(1120, 4465));
		game.walls.add(new IntTuple(1120, 4433));
		game.walls.add(new IntTuple(1152, 4433));
		game.walls.add(new IntTuple(1184, 4433));
		game.walls.add(new IntTuple(1216, 4433));
		game.walls.add(new IntTuple(1248, 4433));
		game.walls.add(new IntTuple(1280, 4433));
		game.walls.add(new IntTuple(1312, 4433));
		game.walls.add(new IntTuple(1344, 4433));
		game.walls.add(new IntTuple(1216, 4465));
		game.walls.add(new IntTuple(1248, 4465));
		game.walls.add(new IntTuple(1280, 4465));
		game.walls.add(new IntTuple(1472, 4433));
		game.walls.add(new IntTuple(1504, 4433));
		game.walls.add(new IntTuple(1536, 4433));
		game.walls.add(new IntTuple(1568, 4433));
		game.walls.add(new IntTuple(1600, 4433));
		game.walls.add(new IntTuple(1632, 4433));
		game.walls.add(new IntTuple(1632, 4465));
		game.walls.add(new IntTuple(1632, 4497));
		game.walls.add(new IntTuple(1632, 4529));
		game.walls.add(new IntTuple(1632, 4561));
		game.walls.add(new IntTuple(1632, 4593));
		game.walls.add(new IntTuple(1664, 4593));
		game.walls.add(new IntTuple(1696, 4593));
		game.walls.add(new IntTuple(1728, 4625));
		game.walls.add(new IntTuple(1728, 4657));
		game.walls.add(new IntTuple(1728, 4689));
		game.walls.add(new IntTuple(1760, 4689));
		game.walls.add(new IntTuple(1824, 4721));
		game.walls.add(new IntTuple(1856, 4721));
		game.walls.add(new IntTuple(1888, 4753));
		game.walls.add(new IntTuple(1888, 4785));
		game.walls.add(new IntTuple(1888, 4817));
		game.walls.add(new IntTuple(1856, 4849));
		game.walls.add(new IntTuple(1824, 4849));
		game.walls.add(new IntTuple(1792, 4849));
		game.walls.add(new IntTuple(1632, 4849));
		game.walls.add(new IntTuple(1632, 4817));
		game.walls.add(new IntTuple(1632, 4785));
		game.walls.add(new IntTuple(1600, 4753));
		game.walls.add(new IntTuple(1568, 4753));
		game.walls.add(new IntTuple(1536, 4753));
		game.walls.add(new IntTuple(1504, 4753));
		game.walls.add(new IntTuple(1472, 4753));
		game.walls.add(new IntTuple(1472, 4785));
		game.walls.add(new IntTuple(1472, 4817));
		game.walls.add(new IntTuple(1472, 4849));
		game.walls.add(new IntTuple(1472, 4881));
		game.walls.add(new IntTuple(1536, 4881));
		game.walls.add(new IntTuple(1568, 4881));
		game.walls.add(new IntTuple(1600, 4881));
		game.walls.add(new IntTuple(1632, 4881));
		game.walls.add(new IntTuple(1664, 4881));
		game.walls.add(new IntTuple(1696, 4881));
		game.walls.add(new IntTuple(1728, 4881));
		game.walls.add(new IntTuple(1760, 4881));
		game.walls.add(new IntTuple(1792, 4881));
		game.walls.add(new IntTuple(1824, 4881));
		game.walls.add(new IntTuple(1856, 4913));
		game.walls.add(new IntTuple(1888, 4945));
		game.walls.add(new IntTuple(1888, 4977));
		game.walls.add(new IntTuple(1888, 5009));
		game.walls.add(new IntTuple(1888, 5041));
		game.walls.add(new IntTuple(1888, 5073));
		game.walls.add(new IntTuple(1888, 5105));
		game.walls.add(new IntTuple(1888, 5137));
		game.walls.add(new IntTuple(1888, 5169));
		game.walls.add(new IntTuple(1888, 5201));
		game.walls.add(new IntTuple(1888, 5233));
		game.walls.add(new IntTuple(1888, 5265));
		game.walls.add(new IntTuple(1888, 5297));
		game.walls.add(new IntTuple(1856, 5297));
		game.walls.add(new IntTuple(1824, 5329));
		game.walls.add(new IntTuple(1792, 5297));
		game.walls.add(new IntTuple(1792, 5233));
		game.walls.add(new IntTuple(1792, 5201));
		game.walls.add(new IntTuple(1824, 5201));
		game.walls.add(new IntTuple(1856, 5009));
		game.walls.add(new IntTuple(1760, 5329));
		game.walls.add(new IntTuple(1760, 5361));
		game.walls.add(new IntTuple(1760, 5393));
		game.walls.add(new IntTuple(1728, 5425));
		game.walls.add(new IntTuple(1696, 5393));
		game.walls.add(new IntTuple(1664, 5425));
		game.walls.add(new IntTuple(1664, 5457));
		game.walls.add(new IntTuple(1664, 5489));
		game.walls.add(new IntTuple(1632, 5521));
		game.walls.add(new IntTuple(1600, 5521));
		game.walls.add(new IntTuple(1568, 5521));
		game.walls.add(new IntTuple(1536, 5553));
		game.walls.add(new IntTuple(1504, 5585));
		game.walls.add(new IntTuple(1472, 5585));
		game.walls.add(new IntTuple(1440, 5585));
		game.walls.add(new IntTuple(1408, 5585));
		game.walls.add(new IntTuple(1376, 5553));
		game.walls.add(new IntTuple(1344, 5553));
		game.walls.add(new IntTuple(1312, 5553));
		game.walls.add(new IntTuple(1024, 5169));
		game.walls.add(new IntTuple(992, 5169));
		game.walls.add(new IntTuple(928, 5169));
		game.walls.add(new IntTuple(928, 5137));
		game.walls.add(new IntTuple(928, 5105));
		game.walls.add(new IntTuple(960, 5105));
		game.walls.add(new IntTuple(992, 5105));
		game.walls.add(new IntTuple(1024, 5105));
		game.walls.add(new IntTuple(1024, 5137));
		game.walls.add(new IntTuple(1216, 5137));
		game.walls.add(new IntTuple(1344, 4657));
		game.walls.add(new IntTuple(1344, 4625));
		game.walls.add(new IntTuple(1536, 4529));
		game.walls.add(new IntTuple(1504, 4561));
		game.walls.add(new IntTuple(1536, 4561));
		game.walls.add(new IntTuple(1568, 4561));
		game.walls.add(new IntTuple(1568, 4593));
		game.walls.add(new IntTuple(1536, 4593));
		game.walls.add(new IntTuple(1504, 4593));
		game.walls.add(new IntTuple(1600, 4465));
		game.walls.add(new IntTuple(1088, 4401));
		game.walls.add(new IntTuple(1088, 4369));
		game.walls.add(new IntTuple(1120, 4337));
		game.walls.add(new IntTuple(1152, 4337));
		game.walls.add(new IntTuple(1184, 4337));
		game.walls.add(new IntTuple(1184, 4305));
		game.walls.add(new IntTuple(1216, 4273));
		game.walls.add(new IntTuple(1248, 4273));
		game.walls.add(new IntTuple(1280, 4273));
		game.walls.add(new IntTuple(1312, 4273));
		game.walls.add(new IntTuple(1344, 4273));
		game.walls.add(new IntTuple(1344, 4241));
		game.walls.add(new IntTuple(1408, 4241));
		game.walls.add(new IntTuple(1408, 4273));
		game.walls.add(new IntTuple(1440, 4273));
		game.walls.add(new IntTuple(1472, 4273));
		game.walls.add(new IntTuple(1504, 4273));
		game.walls.add(new IntTuple(1536, 4273));
		game.walls.add(new IntTuple(1568, 4273));
		game.walls.add(new IntTuple(1600, 4273));
		game.walls.add(new IntTuple(1600, 4241));
		game.walls.add(new IntTuple(1664, 4241));
		game.walls.add(new IntTuple(1664, 4273));
		game.walls.add(new IntTuple(1696, 4273));
		game.walls.add(new IntTuple(1728, 4273));
		game.walls.add(new IntTuple(1760, 4273));
		game.walls.add(new IntTuple(1792, 4273));
		game.walls.add(new IntTuple(1824, 4273));
		game.walls.add(new IntTuple(1856, 4273));
		game.walls.add(new IntTuple(1888, 4273));
		game.walls.add(new IntTuple(1920, 4273));
		game.walls.add(new IntTuple(1952, 4273));
		game.walls.add(new IntTuple(1984, 4305));
		game.walls.add(new IntTuple(1984, 4337));
		game.walls.add(new IntTuple(2016, 4337));
		game.walls.add(new IntTuple(2048, 4337));
		game.walls.add(new IntTuple(2080, 4337));
		game.walls.add(new IntTuple(2080, 4401));
		game.walls.add(new IntTuple(2048, 4433));
		game.walls.add(new IntTuple(2016, 4433));
		game.walls.add(new IntTuple(1984, 4433));
		game.walls.add(new IntTuple(1952, 4433));
		game.walls.add(new IntTuple(1920, 4433));
		game.walls.add(new IntTuple(1888, 4433));
		game.walls.add(new IntTuple(1856, 4433));
		game.walls.add(new IntTuple(1824, 4433));
		game.walls.add(new IntTuple(1792, 4433));
		game.walls.add(new IntTuple(1760, 4433));
		game.walls.add(new IntTuple(1728, 4433));
		game.walls.add(new IntTuple(1696, 4433));
		game.walls.add(new IntTuple(1664, 4433));
		game.walls.add(new IntTuple(1504, 5425));
		game.walls.add(new IntTuple(1504, 5393));
		game.walls.add(new IntTuple(1504, 5361));
		game.walls.add(new IntTuple(1504, 5329));
		game.walls.add(new IntTuple(1504, 5297));
		game.walls.add(new IntTuple(1504, 5265));
		game.walls.add(new IntTuple(1472, 5265));
		game.walls.add(new IntTuple(1440, 5265));
		game.walls.add(new IntTuple(1408, 5265));
		game.walls.add(new IntTuple(1376, 5265));
		game.walls.add(new IntTuple(1376, 5297));
		game.walls.add(new IntTuple(1376, 5329));
		game.walls.add(new IntTuple(1376, 5361));
		game.walls.add(new IntTuple(1376, 5393));
		game.walls.add(new IntTuple(1408, 5393));
		game.walls.add(new IntTuple(1472, 5393));
		game.walls.add(new IntTuple(1600, 5297));
		game.walls.add(new IntTuple(1664, 5297));
		game.walls.add(new IntTuple(1696, 5297));
		game.walls.add(new IntTuple(1760, 5297));
		game.walls.add(new IntTuple(1760, 5265));
		game.walls.add(new IntTuple(1760, 5233));
		game.walls.add(new IntTuple(1760, 5201));
		game.walls.add(new IntTuple(1760, 5169));
		game.walls.add(new IntTuple(1760, 5137));
		game.walls.add(new IntTuple(1760, 5105));
		game.walls.add(new IntTuple(1760, 5073));
		game.walls.add(new IntTuple(1760, 5041));
		game.walls.add(new IntTuple(1760, 5009));
		game.walls.add(new IntTuple(1760, 4977));
		game.walls.add(new IntTuple(1760, 4945));
		game.walls.add(new IntTuple(1728, 4945));
		game.walls.add(new IntTuple(1696, 4945));
		game.walls.add(new IntTuple(1664, 4945));
		game.walls.add(new IntTuple(1632, 4945));
		game.walls.add(new IntTuple(1600, 4945));
		game.walls.add(new IntTuple(1600, 4977));
		game.walls.add(new IntTuple(1600, 5009));
		game.walls.add(new IntTuple(1600, 5041));
		game.walls.add(new IntTuple(1600, 5073));
		game.walls.add(new IntTuple(1600, 5105));
		game.walls.add(new IntTuple(1600, 5137));
		game.walls.add(new IntTuple(1600, 5169));
		game.walls.add(new IntTuple(1600, 5201));
		game.walls.add(new IntTuple(1600, 5233));
		game.walls.add(new IntTuple(1600, 5265));
		game.walls.add(new IntTuple(1504, 5137));
		game.walls.add(new IntTuple(1472, 5137));
		game.walls.add(new IntTuple(1408, 5137));
		game.walls.add(new IntTuple(1376, 5137));
		game.walls.add(new IntTuple(1376, 5105));
		game.walls.add(new IntTuple(1376, 5073));
		game.walls.add(new IntTuple(1376, 5041));
		game.walls.add(new IntTuple(1376, 5009));
		game.walls.add(new IntTuple(1408, 5009));
		game.walls.add(new IntTuple(1440, 5009));
		game.walls.add(new IntTuple(1472, 5009));
		game.walls.add(new IntTuple(1504, 5009));
		game.walls.add(new IntTuple(1504, 5041));
		game.walls.add(new IntTuple(1504, 5073));
		game.walls.add(new IntTuple(1504, 5105));
		game.walls.add(new IntTuple(2080, 4305));
		game.walls.add(new IntTuple(2112, 4273));
		game.walls.add(new IntTuple(2144, 4273));
		game.walls.add(new IntTuple(2176, 4273));
		game.walls.add(new IntTuple(2208, 4273));
		game.walls.add(new IntTuple(2240, 4273));
		game.walls.add(new IntTuple(2272, 4273));
		game.walls.add(new IntTuple(2304, 4273));
		game.walls.add(new IntTuple(2336, 4273));
		game.walls.add(new IntTuple(2368, 4273));
		game.walls.add(new IntTuple(2400, 4273));
		game.walls.add(new IntTuple(2432, 4273));
		game.walls.add(new IntTuple(2464, 4273));
		game.walls.add(new IntTuple(2496, 4273));
		game.walls.add(new IntTuple(2528, 4273));
		game.walls.add(new IntTuple(2560, 4273));
		game.walls.add(new IntTuple(2592, 4273));
		game.walls.add(new IntTuple(2624, 4273));
		game.walls.add(new IntTuple(2656, 4273));
		game.walls.add(new IntTuple(2688, 4273));
		game.walls.add(new IntTuple(2720, 4273));
		game.walls.add(new IntTuple(2816, 4273));
		game.walls.add(new IntTuple(2848, 4305));
		game.walls.add(new IntTuple(2848, 4337));
		game.walls.add(new IntTuple(2848, 4369));
		game.walls.add(new IntTuple(2848, 4401));
		game.walls.add(new IntTuple(2816, 4433));
		game.walls.add(new IntTuple(2784, 4433));
		game.walls.add(new IntTuple(2752, 4433));
		game.walls.add(new IntTuple(2720, 4433));
		game.walls.add(new IntTuple(2688, 4433));
		game.walls.add(new IntTuple(2656, 4433));
		game.walls.add(new IntTuple(2624, 4433));
		game.walls.add(new IntTuple(2624, 4465));
		game.walls.add(new IntTuple(2656, 4465));
		game.walls.add(new IntTuple(2656, 4497));
		game.walls.add(new IntTuple(2688, 4561));
		game.walls.add(new IntTuple(2656, 4593));
		game.walls.add(new IntTuple(2624, 4593));
		game.walls.add(new IntTuple(2592, 4593));
		game.walls.add(new IntTuple(2560, 4593));
		game.walls.add(new IntTuple(2528, 4561));
		game.walls.add(new IntTuple(2528, 4529));
		game.walls.add(new IntTuple(2528, 4497));
		game.walls.add(new IntTuple(2496, 4465));
		game.walls.add(new IntTuple(2496, 4433));
		game.walls.add(new IntTuple(2464, 4433));
		game.walls.add(new IntTuple(2432, 4433));
		game.walls.add(new IntTuple(2400, 4433));
		game.walls.add(new IntTuple(2368, 4433));
		game.walls.add(new IntTuple(2336, 4433));
		game.walls.add(new IntTuple(2304, 4433));
		game.walls.add(new IntTuple(2272, 4433));
		game.walls.add(new IntTuple(2240, 4433));
		game.walls.add(new IntTuple(2208, 4433));
		game.walls.add(new IntTuple(2176, 4433));
		game.walls.add(new IntTuple(2144, 4433));
		game.walls.add(new IntTuple(2112, 4433));
	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 int position = IntTuple.getPosition(game.clickableTiles, tuple);
		 if(position == 1)
			 text = "Tour Radio.";
		 else if(position == 2)
			 text = "Villaube.= Une ville fière, à l'aube de la recherche.";
		 else if(position == 3)
			 text = "Laboratoire du Professeur Chen.";
		 else if(position == 4)
			 text = "Territoire de Martin.= Ne pas déranger !";
		 else if(position == 5)
			 text = "Statue de Villaube.= On dit qu'un Pokemon a autrefois créé cette\n"
			 		+ "ville.= Des Pokemon rares viennent souvent ici pour se ressourcer.";
		 else if(position == 6)
			 text = "Route commerciale de Villaube.= Faites attention avant de traverser.";
		 else if(position == 7 || position == 8)
			 text = "Route fermée aux piétons.";
		 else if(position == 9 || position == 10)
			 text = "C'est fermé.";
		 else if(position == 11 && Variables.GROUND_ITEMS_Villaube.contains("1")) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Villaube.remove("1");
			 groundPokeBall1.setVisible(false);
			 IntTuple.removeTuple(game.walls, new IntTuple(864, 4657));
			 // Ajouter un mouchoir soie au sac.
			 text = "Vous avez ramassé un Mouchoir Soie !";
		 }
		 else if(position == 12 && Variables.GROUND_ITEMS_Villaube.contains("0")) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Villaube.remove("0");
			 groundPokeBall1.setVisible(false);
			 IntTuple.removeTuple(game.walls, new IntTuple(864, 4657));
			 // Ajouter une poké ball au sac.
			 text = "Vous avez ramassé une Poké Ball !";
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			if(game.deplacement.getPosition().equals(toIntertown02) || game.deplacement.getPosition().equals(toIntertown03)
					|| game.deplacement.getPosition().equals(toLabo) || game.deplacement.getPosition().equals(toPokemonCenter)
					|| game.deplacement.getPosition().equals(toMart) || game.deplacement.getPosition().equals(toRadioTower)
					|| game.deplacement.getPosition().equals(toHouse01) || game.deplacement.getPosition().equals(toHouse02)
					|| game.deplacement.getPosition().equals(toHouse03) || game.deplacement.getPosition().equals(toHouse04)
					|| game.deplacement.getPosition().equals(toBuilding01) || game.deplacement.getPosition().equals(toBuilding02)) {
				game.deplacement.hero.setVisible(false);
				setVisible(false);
				Sounds.playSound(Const.soundEnterHouse);
				if(game.deplacement.getPosition().equals(toIntertown02))
					new TransitionSimple(game, game.gamePanel, new Intertown02(game, 3264, 2858, Direction.DOWN, -2891, -2600));
				else if(game.deplacement.getPosition().equals(toLabo))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toPokemonCenter))
					new TransitionSimple(game, game.gamePanel, VillaubeSpecialHouses.villaubePokemonCenter01(game, 6496, 2218, Direction.UP, -6123, -1960));
				else if(game.deplacement.getPosition().equals(toMart))
					new TransitionSimple(game, game.gamePanel, VillaubeSpecialHouses.villaubeMart01(game, 6432, 1290, Direction.UP, -6059, -1032));
				else if(game.deplacement.getPosition().equals(toRadioTower))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toHouse01))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toHouse02))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse02(game, 6464, 3114, Direction.UP, -6091, -2856));
				else if(game.deplacement.getPosition().equals(toHouse03))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse03(game, 5472, 2218, Direction.UP, -5099, -1960));
				else if(game.deplacement.getPosition().equals(toHouse04))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse04(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toBuilding01))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toBuilding02))
					new TransitionSimple(game, game.gamePanel, VillaubeHouses.villaubeHouse01(game, 5504, 1322, Direction.UP, -5131, -1064));
				else if(game.deplacement.getPosition().equals(toIntertown03))
					new TransitionSimple(game, game.gamePanel, new Intertown02(game, 3264, 2858, Direction.DOWN, -2891, -2600));
				return true;
			}
		}
		return false;
	}

}
