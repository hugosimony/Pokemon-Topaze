package fr.hugosimony.pokemoncancer.maps.roads;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemoncancer.listeners.InteractDispatcher;
import fr.hugosimony.pokemoncancer.listeners.MenuXDispatcher;
import fr.hugosimony.pokemoncancer.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemoncancer.maps.Deplacement;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.Map;
import fr.hugosimony.pokemoncancer.maps.Places;
import fr.hugosimony.pokemoncancer.maps.items.GroundItem;
import fr.hugosimony.pokemoncancer.maps.pnj.Pnj;
import fr.hugosimony.pokemoncancer.maps.towns.intertowns.Intertown1;
import fr.hugosimony.pokemoncancer.maps.towns.intertowns.Intertown2;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTriple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class Road01 extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private Clip clipRoad01Theme;
	
	private IntTuple toIntertown1;
	private IntTuple toIntertown2;
	
	private GroundItem groundPokeBall1;
	
	public Road01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.road01 = this;
		
		setClickableTiles();
		setWalls();
		setWallJumps();
		setPnjs();
		setHerbs();
		toIntertown1 = new IntTuple(4064, 1866);
		toIntertown2 = new IntTuple(3232, 746);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Const.themeRoad01);
			clipRoad01Theme = AudioSystem.getClip();
			clipRoad01Theme.open(audioInput);
			Main.actualClip = clipRoad01Theme;
			Main.refreshVolume();
			clipRoad01Theme.start();
			clipRoad01Theme.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		Variables.POSITION_Place = Places.ROAD01;
		game.map = new Map(4, 0);
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
		
		game.clickableTiles.add(new IntTuple(3744, 1642)); // SIGN 1
		game.clickableTiles.add(new IntTuple(4000, 1514)); // SIGN 2
		game.clickableTiles.add(new IntTuple(3872, 906)); // SIGN 3
		game.clickableTiles.add(new IntTuple(3296, 810)); // SIGN 4
		
		game.clickableTiles.add(new IntTuple(4128, 1546)); // GROUND ITEM 1
		groundPokeBall1 = new GroundItem("pokeball");
		groundPokeBall1.setVisible(Variables.GROUND_ITEMS_Road1.contains("0"));
		groundPokeBall1.setLocation(4128, 1546);
	}
	
	private void addGroundItems() {
		game.map.add(groundPokeBall1);
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();

		if(Variables.GROUND_ITEMS_Road1.contains("0"))
			game.walls.add(new IntTuple(4128, 1546));
		
		game.walls.add(new IntTuple(3744, 1642));
		game.walls.add(new IntTuple(4000, 1514));
		game.walls.add(new IntTuple(3872, 906));
		game.walls.add(new IntTuple(3296, 810));
		game.walls.add(new IntTuple(4128, 1834));
		game.walls.add(new IntTuple(4096, 1834));
		game.walls.add(new IntTuple(4032, 1834));
		game.walls.add(new IntTuple(4000, 1834));
		game.walls.add(new IntTuple(3968, 1834));
		game.walls.add(new IntTuple(3936, 1834));
		game.walls.add(new IntTuple(3904, 1834));
		game.walls.add(new IntTuple(3872, 1834));
		game.walls.add(new IntTuple(3840, 1834));
		game.walls.add(new IntTuple(3808, 1834));
		game.walls.add(new IntTuple(3776, 1834));
		game.walls.add(new IntTuple(3744, 1834));
		game.walls.add(new IntTuple(3712, 1834));
		game.walls.add(new IntTuple(3680, 1834));
		game.walls.add(new IntTuple(3648, 1834));
		game.walls.add(new IntTuple(3616, 1834));
		game.walls.add(new IntTuple(3584, 1834));
		game.walls.add(new IntTuple(3552, 1834));
		game.walls.add(new IntTuple(3520, 1834));
		game.walls.add(new IntTuple(3488, 1834));
		game.walls.add(new IntTuple(3456, 1834));
		game.walls.add(new IntTuple(3424, 1834));
		game.walls.add(new IntTuple(3392, 1834));
		game.walls.add(new IntTuple(3360, 1834));
		game.walls.add(new IntTuple(3328, 1834));
		game.walls.add(new IntTuple(3296, 1834));
		game.walls.add(new IntTuple(3264, 1834));
		game.walls.add(new IntTuple(3264, 1802));
		game.walls.add(new IntTuple(3264, 1770));
		game.walls.add(new IntTuple(3264, 1738));
		game.walls.add(new IntTuple(3232, 1834));
		game.walls.add(new IntTuple(3200, 1834));
		game.walls.add(new IntTuple(3168, 1834));
		game.walls.add(new IntTuple(3136, 1834));
		game.walls.add(new IntTuple(3104, 1802));
		game.walls.add(new IntTuple(3104, 1770));
		game.walls.add(new IntTuple(3072, 1770));
		game.walls.add(new IntTuple(3040, 1738));
		game.walls.add(new IntTuple(3040, 1706));
		game.walls.add(new IntTuple(3072, 1674));
		game.walls.add(new IntTuple(3104, 1674));
		game.walls.add(new IntTuple(3136, 1674));
		game.walls.add(new IntTuple(3104, 1642));
		game.walls.add(new IntTuple(3104, 1610));
		game.walls.add(new IntTuple(3104, 1578));
		game.walls.add(new IntTuple(3104, 1546));
		game.walls.add(new IntTuple(3104, 1514));
		game.walls.add(new IntTuple(3104, 1482));
		game.walls.add(new IntTuple(3104, 1450));
		game.walls.add(new IntTuple(3104, 1418));
		game.walls.add(new IntTuple(3104, 1386));
		game.walls.add(new IntTuple(3104, 1354));
		game.walls.add(new IntTuple(3104, 1322));
		game.walls.add(new IntTuple(3104, 1290));
		game.walls.add(new IntTuple(3104, 1258));
		game.walls.add(new IntTuple(3104, 1226));
		game.walls.add(new IntTuple(3104, 1194));
		game.walls.add(new IntTuple(3104, 1162));
		game.walls.add(new IntTuple(3104, 1130));
		game.walls.add(new IntTuple(3104, 1098));
		game.walls.add(new IntTuple(3104, 1066));
		game.walls.add(new IntTuple(3104, 1034));
		game.walls.add(new IntTuple(3104, 1002));
		game.walls.add(new IntTuple(3104, 970));
		game.walls.add(new IntTuple(3104, 938));
		game.walls.add(new IntTuple(3104, 906));
		game.walls.add(new IntTuple(3104, 874));
		game.walls.add(new IntTuple(3136, 842));
		game.walls.add(new IntTuple(3168, 810));
		game.walls.add(new IntTuple(3200, 778));
		game.walls.add(new IntTuple(3264, 778));
		game.walls.add(new IntTuple(3328, 810));
		game.walls.add(new IntTuple(3360, 810));
		game.walls.add(new IntTuple(3392, 810));
		game.walls.add(new IntTuple(3424, 810));
		game.walls.add(new IntTuple(3456, 810));
		game.walls.add(new IntTuple(3488, 810));
		game.walls.add(new IntTuple(3520, 810));
		game.walls.add(new IntTuple(3552, 810));
		game.walls.add(new IntTuple(3584, 810));
		game.walls.add(new IntTuple(3616, 810));
		game.walls.add(new IntTuple(3648, 810));
		game.walls.add(new IntTuple(3680, 810));
		game.walls.add(new IntTuple(3712, 810));
		game.walls.add(new IntTuple(3744, 810));
		game.walls.add(new IntTuple(3776, 842));
		game.walls.add(new IntTuple(3808, 842));
		game.walls.add(new IntTuple(3840, 874));
		game.walls.add(new IntTuple(3904, 938));
		game.walls.add(new IntTuple(3904, 970));
		game.walls.add(new IntTuple(3904, 1002));
		game.walls.add(new IntTuple(3904, 1034));
		game.walls.add(new IntTuple(3904, 1066));
		game.walls.add(new IntTuple(3904, 1098));
		game.walls.add(new IntTuple(3904, 1130));
		game.walls.add(new IntTuple(3936, 1162));
		game.walls.add(new IntTuple(3968, 1162));
		game.walls.add(new IntTuple(4000, 1162));
		game.walls.add(new IntTuple(4032, 1194));
		game.walls.add(new IntTuple(4032, 1226));
		game.walls.add(new IntTuple(4032, 1258));
		game.walls.add(new IntTuple(4032, 1290));
		game.walls.add(new IntTuple(4032, 1322));
		game.walls.add(new IntTuple(4032, 1354));
		game.walls.add(new IntTuple(4032, 1386));
		game.walls.add(new IntTuple(4032, 1418));
		game.walls.add(new IntTuple(4032, 1450));
		game.walls.add(new IntTuple(4032, 1482));
		game.walls.add(new IntTuple(4032, 1514));
		game.walls.add(new IntTuple(4064, 1514));
		game.walls.add(new IntTuple(4096, 1514));
		game.walls.add(new IntTuple(4128, 1514));
		game.walls.add(new IntTuple(4160, 1546));
		game.walls.add(new IntTuple(4128, 1578));
		game.walls.add(new IntTuple(4096, 1578));
		game.walls.add(new IntTuple(4064, 1578));
		game.walls.add(new IntTuple(4032, 1578));
		game.walls.add(new IntTuple(4000, 1578));
		game.walls.add(new IntTuple(4000, 1610));
		game.walls.add(new IntTuple(4064, 1610));
		game.walls.add(new IntTuple(4096, 1642));
		game.walls.add(new IntTuple(4128, 1674));
		game.walls.add(new IntTuple(4160, 1706));
		game.walls.add(new IntTuple(4160, 1738));
		game.walls.add(new IntTuple(4160, 1770));
		game.walls.add(new IntTuple(4160, 1802));
		game.walls.add(new IntTuple(3904, 1610));
		game.walls.add(new IntTuple(3904, 1578));
		game.walls.add(new IntTuple(3872, 1578));
		game.walls.add(new IntTuple(3840, 1578));
		game.walls.add(new IntTuple(3808, 1578));
		game.walls.add(new IntTuple(3776, 1578));
		game.walls.add(new IntTuple(3744, 1578));
		game.walls.add(new IntTuple(3712, 1578));
		game.walls.add(new IntTuple(3680, 1578));
		game.walls.add(new IntTuple(3648, 1578));
		game.walls.add(new IntTuple(3616, 1578));
		game.walls.add(new IntTuple(3584, 1578));
		game.walls.add(new IntTuple(3552, 1578));
		game.walls.add(new IntTuple(3520, 1578));
		game.walls.add(new IntTuple(3488, 1578));
		game.walls.add(new IntTuple(3456, 1578));
		game.walls.add(new IntTuple(3424, 1578));
		game.walls.add(new IntTuple(3392, 1578));
		game.walls.add(new IntTuple(3360, 1578));
		game.walls.add(new IntTuple(3328, 1578));
		game.walls.add(new IntTuple(3296, 1578));
		game.walls.add(new IntTuple(3264, 1578));
		game.walls.add(new IntTuple(3264, 1610));
		game.walls.add(new IntTuple(3264, 1642));
		game.walls.add(new IntTuple(3264, 1546));
		game.walls.add(new IntTuple(3264, 1514));
		game.walls.add(new IntTuple(3264, 1482));
		game.walls.add(new IntTuple(3264, 1450));
		game.walls.add(new IntTuple(3264, 1418));
		game.walls.add(new IntTuple(3264, 1386));
		game.walls.add(new IntTuple(3264, 1354));
		game.walls.add(new IntTuple(3296, 1354));
		game.walls.add(new IntTuple(3328, 1354));
		game.walls.add(new IntTuple(3360, 1354));
		game.walls.add(new IntTuple(3392, 1354));
		game.walls.add(new IntTuple(3424, 1354));
		game.walls.add(new IntTuple(3456, 1354));
		game.walls.add(new IntTuple(3488, 1354));
		game.walls.add(new IntTuple(3520, 1354));
		game.walls.add(new IntTuple(3552, 1354));
		game.walls.add(new IntTuple(3552, 1386));
		game.walls.add(new IntTuple(3552, 1418));
		game.walls.add(new IntTuple(3584, 1450));
		game.walls.add(new IntTuple(3616, 1482));
		game.walls.add(new IntTuple(3648, 1482));
		game.walls.add(new IntTuple(3680, 1482));
		game.walls.add(new IntTuple(3680, 1514));
		game.walls.add(new IntTuple(3680, 1546));
		game.walls.add(new IntTuple(3776, 1162));
		game.walls.add(new IntTuple(3744, 1162));
		game.walls.add(new IntTuple(3712, 1162));
		game.walls.add(new IntTuple(3680, 1162));
		game.walls.add(new IntTuple(3680, 1130));
		game.walls.add(new IntTuple(3680, 1098));
		game.walls.add(new IntTuple(3680, 1066));
		game.walls.add(new IntTuple(3680, 1034));
		game.walls.add(new IntTuple(3680, 1002));
		game.walls.add(new IntTuple(3680, 970));
		game.walls.add(new IntTuple(3648, 1098));
		game.walls.add(new IntTuple(3616, 1130));
		game.walls.add(new IntTuple(3648, 1162));
		game.walls.add(new IntTuple(3616, 1162));
		game.walls.add(new IntTuple(3584, 1162));
		game.walls.add(new IntTuple(3552, 1162));
		game.walls.add(new IntTuple(3520, 1162));
		game.walls.add(new IntTuple(3488, 1162));
		game.walls.add(new IntTuple(3456, 1162));
		game.walls.add(new IntTuple(3424, 1162));
		game.walls.add(new IntTuple(3392, 1162));
		game.walls.add(new IntTuple(3360, 1162));
		game.walls.add(new IntTuple(3328, 1162));
		game.walls.add(new IntTuple(3296, 1162));
		game.walls.add(new IntTuple(3264, 1162));
		game.walls.add(new IntTuple(3264, 1194));
		
		
		// Water :
		
		game.walls.add(new IntTuple(3104, 1706));
		game.walls.add(new IntTuple(3072, 1706));
		game.walls.add(new IntTuple(3072, 1738));
		game.walls.add(new IntTuple(3104, 1738));

		game.walls.add(new IntTuple(4000, 1418));
		game.walls.add(new IntTuple(3968, 1418));
		game.walls.add(new IntTuple(3936, 1418));
		game.walls.add(new IntTuple(3936, 1386));
		game.walls.add(new IntTuple(3968, 1386));
		game.walls.add(new IntTuple(4000, 1386));
		game.walls.add(new IntTuple(4000, 1354));
		game.walls.add(new IntTuple(3968, 1354));
		game.walls.add(new IntTuple(3936, 1354));
		game.walls.add(new IntTuple(3936, 1322));
		game.walls.add(new IntTuple(3968, 1322));
		game.walls.add(new IntTuple(4000, 1322));
		game.walls.add(new IntTuple(4000, 1290));
		game.walls.add(new IntTuple(3968, 1290));
		game.walls.add(new IntTuple(3936, 1290));

	}
	
	private void setWallJumps() {
		game.jumpWalls = new ArrayList<IntTriple>();
		
		game.jumpWalls.add(new IntTriple(3936, 1578, 1));
		game.jumpWalls.add(new IntTriple(3968, 1578, 1));
		
		game.jumpWalls.add(new IntTriple(3232, 1162, 1));
		game.jumpWalls.add(new IntTriple(3200, 1162, 1));
		game.jumpWalls.add(new IntTriple(3168, 1162, 1));
		game.jumpWalls.add(new IntTriple(3136, 1162, 1));

	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
	}
	
	private void setHerbs() {
		game.herbs = new ArrayList<IntTriple>();
		
		//***************************************************
		// Herbs 1
		
		game.herbs.add(new IntTriple(3616, 1674, 1));
		game.herbs.add(new IntTriple(3584, 1642, 1));
		game.herbs.add(new IntTriple(3584, 1674, 1));
		game.herbs.add(new IntTriple(3584, 1706, 1));
		game.herbs.add(new IntTriple(3584, 1738, 1));
		game.herbs.add(new IntTriple(3552, 1770, 1));
		game.herbs.add(new IntTriple(3552, 1738, 1));
		game.herbs.add(new IntTriple(3552, 1706, 1));
		game.herbs.add(new IntTriple(3552, 1674, 1));
		game.herbs.add(new IntTriple(3552, 1642, 1));
		game.herbs.add(new IntTriple(3520, 1642, 1));
		game.herbs.add(new IntTriple(3520, 1674, 1));
		game.herbs.add(new IntTriple(3520, 1706, 1));
		game.herbs.add(new IntTriple(3520, 1738, 1));
		game.herbs.add(new IntTriple(3520, 1770, 1));
		game.herbs.add(new IntTriple(3488, 1770, 1));
		game.herbs.add(new IntTriple(3488, 1738, 1));
		game.herbs.add(new IntTriple(3488, 1706, 1));
		game.herbs.add(new IntTriple(3488, 1674, 1));
		game.herbs.add(new IntTriple(3488, 1642, 1));
		game.herbs.add(new IntTriple(3456, 1642, 1));
		game.herbs.add(new IntTriple(3456, 1674, 1));
		game.herbs.add(new IntTriple(3456, 1706, 1));
		game.herbs.add(new IntTriple(3456, 1738, 1));
		game.herbs.add(new IntTriple(3424, 1738, 1));
		game.herbs.add(new IntTriple(3424, 1706, 1));
		game.herbs.add(new IntTriple(3424, 1674, 1));
		game.herbs.add(new IntTriple(3424, 1642, 1));
		game.herbs.add(new IntTriple(3424, 1610, 1));
		game.herbs.add(new IntTriple(3392, 1642, 1));
		game.herbs.add(new IntTriple(3392, 1674, 1));
		game.herbs.add(new IntTriple(3392, 1706, 1));
		game.herbs.add(new IntTriple(3392, 1738, 1));
		game.herbs.add(new IntTriple(3360, 1738, 1));
		game.herbs.add(new IntTriple(3360, 1706, 1));
		game.herbs.add(new IntTriple(3360, 1674, 1));
		game.herbs.add(new IntTriple(3360, 1642, 1));
		game.herbs.add(new IntTriple(3328, 1674, 1));
		game.herbs.add(new IntTriple(3328, 1706, 1));
		
		game.herbs.add(new IntTriple(3232, 1578, 1));
		game.herbs.add(new IntTriple(3232, 1546, 1));
		game.herbs.add(new IntTriple(3200, 1546, 1));
		game.herbs.add(new IntTriple(3200, 1514, 1));
		game.herbs.add(new IntTriple(3232, 1514, 1));
		game.herbs.add(new IntTriple(3232, 1482, 1));
		game.herbs.add(new IntTriple(3200, 1482, 1));
		game.herbs.add(new IntTriple(3168, 1482, 1));
		game.herbs.add(new IntTriple(3232, 1450, 1));
		game.herbs.add(new IntTriple(3200, 1450, 1));
		game.herbs.add(new IntTriple(3168, 1450, 1));
		game.herbs.add(new IntTriple(3136, 1450, 1));
		game.herbs.add(new IntTriple(3136, 1418, 1));
		game.herbs.add(new IntTriple(3168, 1418, 1));
		game.herbs.add(new IntTriple(3200, 1418, 1));
		game.herbs.add(new IntTriple(3232, 1418, 1));
		game.herbs.add(new IntTriple(3200, 1386, 1));
		game.herbs.add(new IntTriple(3168, 1386, 1));
		game.herbs.add(new IntTriple(3136, 1386, 1));
		game.herbs.add(new IntTriple(3136, 1354, 1));
		game.herbs.add(new IntTriple(3168, 1354, 1));
		game.herbs.add(new IntTriple(3136, 1322, 1));
		
		game.herbs.add(new IntTriple(3680, 1322, 1));
		game.herbs.add(new IntTriple(3712, 1322, 1));
		game.herbs.add(new IntTriple(3744, 1354, 1));
		game.herbs.add(new IntTriple(3712, 1354, 1));
		game.herbs.add(new IntTriple(3680, 1354, 1));
		game.herbs.add(new IntTriple(3648, 1354, 1));
		game.herbs.add(new IntTriple(3680, 1386, 1));
		game.herbs.add(new IntTriple(3712, 1386, 1));
		game.herbs.add(new IntTriple(3744, 1386, 1));
		game.herbs.add(new IntTriple(3776, 1386, 1));
		game.herbs.add(new IntTriple(3808, 1386, 1));
		game.herbs.add(new IntTriple(3840, 1386, 1));
		game.herbs.add(new IntTriple(3840, 1354, 1));
		game.herbs.add(new IntTriple(3872, 1418, 1));
		game.herbs.add(new IntTriple(3840, 1418, 1));
		game.herbs.add(new IntTriple(3808, 1418, 1));
		game.herbs.add(new IntTriple(3776, 1418, 1));
		game.herbs.add(new IntTriple(3744, 1418, 1));
		game.herbs.add(new IntTriple(3712, 1418, 1));
		game.herbs.add(new IntTriple(3744, 1450, 1));
		game.herbs.add(new IntTriple(3776, 1450, 1));
		game.herbs.add(new IntTriple(3808, 1450, 1));
		game.herbs.add(new IntTriple(3840, 1450, 1));
		game.herbs.add(new IntTriple(3808, 1482, 1));
		
		//***************************************************
		// Herbs 2
		
		game.herbs.add(new IntTriple(3872, 1226, 2));
		game.herbs.add(new IntTriple(3840, 1226, 2));
		game.herbs.add(new IntTriple(3808, 1194, 2));
		game.herbs.add(new IntTriple(3840, 1194, 2));
		game.herbs.add(new IntTriple(3872, 1194, 2));
		game.herbs.add(new IntTriple(3904, 1194, 2));
		game.herbs.add(new IntTriple(3904, 1162, 2));
		game.herbs.add(new IntTriple(3872, 1162, 2));
		game.herbs.add(new IntTriple(3840, 1162, 2));
		game.herbs.add(new IntTriple(3808, 1162, 2));
		game.herbs.add(new IntTriple(3872, 1130, 2));
		game.herbs.add(new IntTriple(3840, 1130, 2));
		game.herbs.add(new IntTriple(3808, 1130, 2));
		game.herbs.add(new IntTriple(3776, 1130, 2));
		game.herbs.add(new IntTriple(3744, 1130, 2));
		game.herbs.add(new IntTriple(3872, 1098, 2));
		game.herbs.add(new IntTriple(3840, 1098, 2));
		game.herbs.add(new IntTriple(3808, 1098, 2));
		game.herbs.add(new IntTriple(3776, 1098, 2));
		game.herbs.add(new IntTriple(3744, 1098, 2));
		game.herbs.add(new IntTriple(3712, 1098, 2));
		game.herbs.add(new IntTriple(3712, 1066, 2));
		game.herbs.add(new IntTriple(3744, 1066, 2));
		game.herbs.add(new IntTriple(3776, 1066, 2));
		game.herbs.add(new IntTriple(3808, 1066, 2));
		game.herbs.add(new IntTriple(3840, 1066, 2));
		game.herbs.add(new IntTriple(3776, 1034, 2));
		
		game.herbs.add(new IntTriple(3616, 906, 2));
		game.herbs.add(new IntTriple(3616, 938, 2));
		game.herbs.add(new IntTriple(3616, 970, 2));
		game.herbs.add(new IntTriple(3616, 1002, 2));
		game.herbs.add(new IntTriple(3584, 1034, 2));
		game.herbs.add(new IntTriple(3584, 1002, 2));
		game.herbs.add(new IntTriple(3584, 970, 2));
		game.herbs.add(new IntTriple(3584, 938, 2));
		game.herbs.add(new IntTriple(3584, 906, 2));
		game.herbs.add(new IntTriple(3584, 874, 2));
		game.herbs.add(new IntTriple(3552, 842, 2));
		game.herbs.add(new IntTriple(3552, 874, 2));
		game.herbs.add(new IntTriple(3552, 906, 2));
		game.herbs.add(new IntTriple(3552, 938, 2));
		game.herbs.add(new IntTriple(3552, 970, 2));
		game.herbs.add(new IntTriple(3552, 1002, 2));
		game.herbs.add(new IntTriple(3552, 1034, 2));
		game.herbs.add(new IntTriple(3520, 1066, 2));
		game.herbs.add(new IntTriple(3520, 1034, 2));
		game.herbs.add(new IntTriple(3520, 1002, 2));
		game.herbs.add(new IntTriple(3520, 970, 2));
		game.herbs.add(new IntTriple(3520, 938, 2));
		game.herbs.add(new IntTriple(3520, 906, 2));
		game.herbs.add(new IntTriple(3520, 874, 2));
		game.herbs.add(new IntTriple(3520, 842, 2));
		game.herbs.add(new IntTriple(3488, 874, 2));
		game.herbs.add(new IntTriple(3488, 906, 2));
		game.herbs.add(new IntTriple(3488, 938, 2));
		game.herbs.add(new IntTriple(3488, 970, 2));
		game.herbs.add(new IntTriple(3488, 1002, 2));
		game.herbs.add(new IntTriple(3488, 1034, 2));
		game.herbs.add(new IntTriple(3488, 1066, 2));
		game.herbs.add(new IntTriple(3456, 1098, 2));
		game.herbs.add(new IntTriple(3456, 1066, 2));
		game.herbs.add(new IntTriple(3456, 1034, 2));
		game.herbs.add(new IntTriple(3456, 1002, 2));
		game.herbs.add(new IntTriple(3456, 970, 2));
		game.herbs.add(new IntTriple(3456, 938, 2));
		game.herbs.add(new IntTriple(3424, 970, 2));
		game.herbs.add(new IntTriple(3424, 1002, 2));
		game.herbs.add(new IntTriple(3424, 1034, 2));
		game.herbs.add(new IntTriple(3424, 1066, 2));
		game.herbs.add(new IntTriple(3392, 1034, 2));
		game.herbs.add(new IntTriple(3392, 1002, 2));
		
	}
	
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
			 text = "Route 01.=\nLe début du cycle.";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
			 text = "Vous pouvez passer au dessus de cette barrière.=\nC'est un bon raccourci.";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
			 text = "Conseil aux dresseurs := Les PVs de vos pokémons doivent rester\nhauts si vous voulez avoir plus de chance de gagner un combat.=\nN'oubliez pas d'avoir toujours des potions sur vous.";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 4) {
			 text = "Vers Ville 2.";
		 } else if(IntTuple.getPosition(game.clickableTiles, tuple) == 5 && Variables.GROUND_ITEMS_Road1.contains("0")) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Road1.remove("0");
			 groundPokeBall1.setVisible(false);
			 IntTuple.removeTuple(game.walls, new IntTuple(4128, 1546));
			 // Ajouter une potion au sac.
			 text = "Vous avez ramassé une Potion !";
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toIntertown1) || game.deplacement.getLookingTile().equals(toIntertown2)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toIntertown1) || game.deplacement.getLookingTile().equals(toIntertown2))
					 Sounds.playSound(Const.soundEnterHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toIntertown1)){
					 new TransitionSimple(game, game.gamePanel, new Intertown1(game, 3264, 2858, Direction.DOWN, -2891, -2600));
				 }
				 else if(game.deplacement.getLookingTile().equals(toIntertown2)){
					 new TransitionSimple(game, game.gamePanel, new Intertown2(game, 3264, 3114, Direction.UP, -2891, -2856));
				 }
				 return true;
			}
		}
		return false;
	}
	
}
