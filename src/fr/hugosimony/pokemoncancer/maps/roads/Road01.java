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
import fr.hugosimony.pokemoncancer.maps.houses.MyHouse;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.maps.towns.intertowns.Intertown1;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTriple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class Road01 extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private Clip clipRoad01Theme;
	
	private IntTuple toIntertown1;
	private IntTuple toTown2;
	
	public Road01(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.road01 = this;
		
		setClickableTiles();
		setWalls();
		setWallJumps();
		setPnjs();
		setHerbs();
		toIntertown1 = new IntTuple(1693, 1708);
		toTown2 = new IntTuple(861, 588);
		
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
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
				
		
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		game.clickableTiles.add(new IntTuple(1373, 1484)); // SIGN 1
		game.clickableTiles.add(new IntTuple(1629, 1356)); // SIGN 2
		game.clickableTiles.add(new IntTuple(1501, 748)); // SIGN 3
		game.clickableTiles.add(new IntTuple(925, 652)); // SIGN 4
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(1661, 1676));
		game.walls.add(new IntTuple(1629, 1676));
		game.walls.add(new IntTuple(1597, 1676));
		game.walls.add(new IntTuple(1565, 1676));
		game.walls.add(new IntTuple(1533, 1676));
		game.walls.add(new IntTuple(1501, 1676));
		game.walls.add(new IntTuple(1469, 1676));
		game.walls.add(new IntTuple(1437, 1676));
		game.walls.add(new IntTuple(1405, 1676));
		game.walls.add(new IntTuple(1373, 1676));
		game.walls.add(new IntTuple(1341, 1676));
		game.walls.add(new IntTuple(1309, 1676));
		game.walls.add(new IntTuple(1277, 1676));
		game.walls.add(new IntTuple(1245, 1676));
		game.walls.add(new IntTuple(1213, 1676));
		game.walls.add(new IntTuple(1181, 1676));
		game.walls.add(new IntTuple(1149, 1676));
		game.walls.add(new IntTuple(1117, 1676));
		game.walls.add(new IntTuple(1085, 1676));
		game.walls.add(new IntTuple(1053, 1676));
		game.walls.add(new IntTuple(1021, 1676));
		game.walls.add(new IntTuple(989, 1676));
		game.walls.add(new IntTuple(957, 1676));
		game.walls.add(new IntTuple(925, 1676));
		game.walls.add(new IntTuple(893, 1644));
		game.walls.add(new IntTuple(893, 1612));
		game.walls.add(new IntTuple(893, 1580));
		game.walls.add(new IntTuple(861, 1676));
		game.walls.add(new IntTuple(829, 1676));
		game.walls.add(new IntTuple(797, 1676));
		game.walls.add(new IntTuple(765, 1676));
		game.walls.add(new IntTuple(733, 1644));
		game.walls.add(new IntTuple(733, 1612));
		game.walls.add(new IntTuple(765, 1516));
		game.walls.add(new IntTuple(733, 1484));
		game.walls.add(new IntTuple(733, 1452));
		game.walls.add(new IntTuple(733, 1420));
		game.walls.add(new IntTuple(733, 1388));
		game.walls.add(new IntTuple(733, 1356));
		game.walls.add(new IntTuple(733, 1324));
		game.walls.add(new IntTuple(733, 1292));
		game.walls.add(new IntTuple(733, 1260));
		game.walls.add(new IntTuple(733, 1228));
		game.walls.add(new IntTuple(733, 1196));
		game.walls.add(new IntTuple(733, 1164));
		game.walls.add(new IntTuple(733, 1132));
		game.walls.add(new IntTuple(733, 1100));
		game.walls.add(new IntTuple(733, 1068));
		game.walls.add(new IntTuple(733, 1036));
		game.walls.add(new IntTuple(733, 1004));
		game.walls.add(new IntTuple(733, 972));
		game.walls.add(new IntTuple(733, 940));
		game.walls.add(new IntTuple(733, 908));
		game.walls.add(new IntTuple(733, 876));
		game.walls.add(new IntTuple(733, 844));
		game.walls.add(new IntTuple(733, 812));
		game.walls.add(new IntTuple(733, 780));
		game.walls.add(new IntTuple(733, 748));
		game.walls.add(new IntTuple(733, 716));
		game.walls.add(new IntTuple(765, 684));
		game.walls.add(new IntTuple(797, 652));
		game.walls.add(new IntTuple(829, 620));
		game.walls.add(new IntTuple(893, 620));
		game.walls.add(new IntTuple(925, 652));
		game.walls.add(new IntTuple(957, 652));
		game.walls.add(new IntTuple(989, 652));
		game.walls.add(new IntTuple(1021, 652));
		game.walls.add(new IntTuple(1053, 652));
		game.walls.add(new IntTuple(1085, 652));
		game.walls.add(new IntTuple(1117, 652));
		game.walls.add(new IntTuple(1149, 652));
		game.walls.add(new IntTuple(1181, 652));
		game.walls.add(new IntTuple(1213, 652));
		game.walls.add(new IntTuple(1245, 652));
		game.walls.add(new IntTuple(1277, 652));
		game.walls.add(new IntTuple(1309, 652));
		game.walls.add(new IntTuple(1341, 652));
		game.walls.add(new IntTuple(1373, 652));
		game.walls.add(new IntTuple(1405, 684));
		game.walls.add(new IntTuple(1437, 684));
		game.walls.add(new IntTuple(1469, 716));
		game.walls.add(new IntTuple(1501, 748));
		game.walls.add(new IntTuple(1533, 780));
		game.walls.add(new IntTuple(1533, 812));
		game.walls.add(new IntTuple(1533, 844));
		game.walls.add(new IntTuple(1533, 876));
		game.walls.add(new IntTuple(1533, 908));
		game.walls.add(new IntTuple(1533, 940));
		game.walls.add(new IntTuple(1533, 972));
		game.walls.add(new IntTuple(1565, 1004));
		game.walls.add(new IntTuple(1597, 1004));
		game.walls.add(new IntTuple(1629, 1004));
		game.walls.add(new IntTuple(1661, 1036));
		game.walls.add(new IntTuple(1661, 1068));
		game.walls.add(new IntTuple(1661, 1100));
		game.walls.add(new IntTuple(1661, 1132));
		game.walls.add(new IntTuple(1661, 1164));
		game.walls.add(new IntTuple(1661, 1196));
		game.walls.add(new IntTuple(1661, 1228));
		game.walls.add(new IntTuple(1661, 1260));
		game.walls.add(new IntTuple(1661, 1292));
		game.walls.add(new IntTuple(1661, 1324));
		game.walls.add(new IntTuple(1629, 1356));
		game.walls.add(new IntTuple(1661, 1356));
		game.walls.add(new IntTuple(1693, 1356));
		game.walls.add(new IntTuple(1725, 1356));
		game.walls.add(new IntTuple(1757, 1356));
		game.walls.add(new IntTuple(1789, 1388));
		game.walls.add(new IntTuple(1757, 1420));
		game.walls.add(new IntTuple(1725, 1420));
		game.walls.add(new IntTuple(1693, 1420));
		game.walls.add(new IntTuple(1661, 1420));
		game.walls.add(new IntTuple(1629, 1420));
		game.walls.add(new IntTuple(1629, 1452));
		game.walls.add(new IntTuple(1693, 1452));
		game.walls.add(new IntTuple(1725, 1484));
		game.walls.add(new IntTuple(1757, 1516));
		game.walls.add(new IntTuple(1789, 1548));
		game.walls.add(new IntTuple(1789, 1580));
		game.walls.add(new IntTuple(1789, 1612));
		game.walls.add(new IntTuple(1789, 1644));
		game.walls.add(new IntTuple(1757, 1676));
		game.walls.add(new IntTuple(1725, 1676));
		game.walls.add(new IntTuple(701, 1612));
		game.walls.add(new IntTuple(669, 1580));
		game.walls.add(new IntTuple(669, 1548));
		game.walls.add(new IntTuple(701, 1516));
		game.walls.add(new IntTuple(733, 1516));
		game.walls.add(new IntTuple(1533, 1452));
		game.walls.add(new IntTuple(1533, 1420));
		game.walls.add(new IntTuple(1501, 1420));
		game.walls.add(new IntTuple(1469, 1420));
		game.walls.add(new IntTuple(1437, 1420));
		game.walls.add(new IntTuple(1405, 1420));
		game.walls.add(new IntTuple(1373, 1420));
		game.walls.add(new IntTuple(1341, 1420));
		game.walls.add(new IntTuple(1309, 1420));
		game.walls.add(new IntTuple(1309, 1388));
		game.walls.add(new IntTuple(1309, 1356));
		game.walls.add(new IntTuple(1309, 1324));
		game.walls.add(new IntTuple(1277, 1324));
		game.walls.add(new IntTuple(1245, 1324));
		game.walls.add(new IntTuple(1213, 1292));
		game.walls.add(new IntTuple(1181, 1260));
		game.walls.add(new IntTuple(1181, 1228));
		game.walls.add(new IntTuple(1181, 1196));
		game.walls.add(new IntTuple(1149, 1196));
		game.walls.add(new IntTuple(1117, 1196));
		game.walls.add(new IntTuple(1085, 1196));
		game.walls.add(new IntTuple(1053, 1196));
		game.walls.add(new IntTuple(1021, 1196));
		game.walls.add(new IntTuple(989, 1196));
		game.walls.add(new IntTuple(957, 1196));
		game.walls.add(new IntTuple(925, 1196));
		game.walls.add(new IntTuple(893, 1196));
		game.walls.add(new IntTuple(893, 1228));
		game.walls.add(new IntTuple(893, 1260));
		game.walls.add(new IntTuple(893, 1292));
		game.walls.add(new IntTuple(893, 1324));
		game.walls.add(new IntTuple(893, 1356));
		game.walls.add(new IntTuple(893, 1388));
		game.walls.add(new IntTuple(893, 1420));
		game.walls.add(new IntTuple(893, 1452));
		game.walls.add(new IntTuple(893, 1484));
		game.walls.add(new IntTuple(925, 1420));
		game.walls.add(new IntTuple(957, 1420));
		game.walls.add(new IntTuple(989, 1420));
		game.walls.add(new IntTuple(1021, 1420));
		game.walls.add(new IntTuple(1053, 1420));
		game.walls.add(new IntTuple(1085, 1420));
		game.walls.add(new IntTuple(1117, 1420));
		game.walls.add(new IntTuple(1149, 1420));
		game.walls.add(new IntTuple(1181, 1420));
		game.walls.add(new IntTuple(1213, 1420));
		game.walls.add(new IntTuple(1245, 1420));
		game.walls.add(new IntTuple(1277, 1420));
		game.walls.add(new IntTuple(1405, 1004));
		game.walls.add(new IntTuple(1373, 1004));
		game.walls.add(new IntTuple(1341, 1004));
		game.walls.add(new IntTuple(1309, 1004));
		game.walls.add(new IntTuple(1309, 972));
		game.walls.add(new IntTuple(1309, 940));
		game.walls.add(new IntTuple(1309, 908));
		game.walls.add(new IntTuple(1309, 876));
		game.walls.add(new IntTuple(1309, 844));
		game.walls.add(new IntTuple(1309, 812));
		game.walls.add(new IntTuple(1277, 940));
		game.walls.add(new IntTuple(1245, 972));
		game.walls.add(new IntTuple(1277, 1004));
		game.walls.add(new IntTuple(1245, 1004));
		game.walls.add(new IntTuple(1213, 1004));
		game.walls.add(new IntTuple(1181, 1004));
		game.walls.add(new IntTuple(1149, 1004));
		game.walls.add(new IntTuple(1117, 1004));
		game.walls.add(new IntTuple(1085, 1004));
		game.walls.add(new IntTuple(1053, 1004));
		game.walls.add(new IntTuple(1021, 1004));
		game.walls.add(new IntTuple(989, 1004));
		game.walls.add(new IntTuple(957, 1004));
		game.walls.add(new IntTuple(925, 1004));
		game.walls.add(new IntTuple(893, 1004));
		game.walls.add(new IntTuple(893, 1036));
		game.walls.add(new IntTuple(1373, 1484));
		
		
		// Water :
		
		game.walls.add(new IntTuple(733, 1548));
		game.walls.add(new IntTuple(701, 1548));
		game.walls.add(new IntTuple(701, 1580));
		game.walls.add(new IntTuple(733, 1580));

		game.walls.add(new IntTuple(1565, 1132));
		game.walls.add(new IntTuple(1597, 1132));
		game.walls.add(new IntTuple(1629, 1132));
		game.walls.add(new IntTuple(1629, 1164));
		game.walls.add(new IntTuple(1597, 1164));
		game.walls.add(new IntTuple(1565, 1164));
		game.walls.add(new IntTuple(1565, 1196));
		game.walls.add(new IntTuple(1597, 1196));
		game.walls.add(new IntTuple(1629, 1196));
		game.walls.add(new IntTuple(1629, 1228));
		game.walls.add(new IntTuple(1597, 1228));
		game.walls.add(new IntTuple(1565, 1228));
		game.walls.add(new IntTuple(1565, 1260));
		game.walls.add(new IntTuple(1597, 1260));
		game.walls.add(new IntTuple(1629, 1260));

	}
	
	private void setWallJumps() {
		game.jumpWalls = new ArrayList<IntTriple>();
		
		game.jumpWalls.add(new IntTriple(1565, 1420, 1));
		game.jumpWalls.add(new IntTriple(1597, 1420, 1));
		
		game.jumpWalls.add(new IntTriple(861, 1004, 1));
		game.jumpWalls.add(new IntTriple(829, 1004, 1));
		game.jumpWalls.add(new IntTriple(797, 1004, 1));
		game.jumpWalls.add(new IntTriple(765, 1004, 1));
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
		
		game.herbs.add(new IntTriple(1181, 1612, 1));
		game.herbs.add(new IntTriple(1149, 1612, 1));
		game.herbs.add(new IntTriple(1117, 1612, 1));
		game.herbs.add(new IntTriple(1213, 1580, 1));
		game.herbs.add(new IntTriple(1181, 1580, 1));
		game.herbs.add(new IntTriple(1149, 1580, 1));
		game.herbs.add(new IntTriple(1117, 1580, 1));
		game.herbs.add(new IntTriple(1085, 1580, 1));
		game.herbs.add(new IntTriple(1053, 1580, 1));
		game.herbs.add(new IntTriple(1021, 1580, 1));
		game.herbs.add(new IntTriple(989, 1580, 1));
		game.herbs.add(new IntTriple(957, 1548, 1));
		game.herbs.add(new IntTriple(989, 1548, 1));
		game.herbs.add(new IntTriple(1021, 1548, 1));
		game.herbs.add(new IntTriple(1053, 1548, 1));
		game.herbs.add(new IntTriple(1085, 1548, 1));
		game.herbs.add(new IntTriple(1117, 1548, 1));
		game.herbs.add(new IntTriple(1149, 1548, 1));
		game.herbs.add(new IntTriple(1181, 1548, 1));
		game.herbs.add(new IntTriple(1213, 1548, 1));
		game.herbs.add(new IntTriple(1245, 1516, 1));
		game.herbs.add(new IntTriple(1213, 1516, 1));
		game.herbs.add(new IntTriple(1181, 1516, 1));
		game.herbs.add(new IntTriple(1149, 1516, 1));
		game.herbs.add(new IntTriple(1117, 1516, 1));
		game.herbs.add(new IntTriple(1085, 1516, 1));
		game.herbs.add(new IntTriple(1053, 1516, 1));
		game.herbs.add(new IntTriple(1021, 1516, 1));
		game.herbs.add(new IntTriple(989, 1516, 1));
		game.herbs.add(new IntTriple(957, 1516, 1));
		game.herbs.add(new IntTriple(989, 1484, 1));
		game.herbs.add(new IntTriple(1021, 1484, 1));
		game.herbs.add(new IntTriple(1053, 1484, 1));
		game.herbs.add(new IntTriple(1085, 1484, 1));
		game.herbs.add(new IntTriple(1117, 1484, 1));
		game.herbs.add(new IntTriple(1149, 1484, 1));
		game.herbs.add(new IntTriple(1181, 1484, 1));
		game.herbs.add(new IntTriple(1213, 1484, 1));
		game.herbs.add(new IntTriple(1053, 1452, 1));
		
		game.herbs.add(new IntTriple(861, 1420, 1));
		game.herbs.add(new IntTriple(861, 1388, 1));
		game.herbs.add(new IntTriple(829, 1388, 1));
		game.herbs.add(new IntTriple(829, 1356, 1));
		game.herbs.add(new IntTriple(861, 1356, 1));
		game.herbs.add(new IntTriple(861, 1324, 1));
		game.herbs.add(new IntTriple(829, 1324, 1));
		game.herbs.add(new IntTriple(797, 1324, 1));
		game.herbs.add(new IntTriple(765, 1292, 1));
		game.herbs.add(new IntTriple(797, 1292, 1));
		game.herbs.add(new IntTriple(829, 1292, 1));
		game.herbs.add(new IntTriple(861, 1292, 1));
		game.herbs.add(new IntTriple(861, 1260, 1));
		game.herbs.add(new IntTriple(829, 1260, 1));
		game.herbs.add(new IntTriple(797, 1260, 1));
		game.herbs.add(new IntTriple(765, 1260, 1));
		game.herbs.add(new IntTriple(765, 1228, 1));
		game.herbs.add(new IntTriple(797, 1228, 1));
		game.herbs.add(new IntTriple(829, 1228, 1));
		game.herbs.add(new IntTriple(797, 1196, 1));
		game.herbs.add(new IntTriple(765, 1196, 1));
		game.herbs.add(new IntTriple(765, 1164, 1));
		
		game.herbs.add(new IntTriple(1309, 1164, 1));
		game.herbs.add(new IntTriple(1341, 1164, 1));
		game.herbs.add(new IntTriple(1277, 1196, 1));
		game.herbs.add(new IntTriple(1309, 1196, 1));
		game.herbs.add(new IntTriple(1341, 1196, 1));
		game.herbs.add(new IntTriple(1373, 1196, 1));
		game.herbs.add(new IntTriple(1469, 1196, 1));
		game.herbs.add(new IntTriple(1469, 1228, 1));
		game.herbs.add(new IntTriple(1437, 1228, 1));
		game.herbs.add(new IntTriple(1405, 1228, 1));
		game.herbs.add(new IntTriple(1373, 1228, 1));
		game.herbs.add(new IntTriple(1341, 1228, 1));
		game.herbs.add(new IntTriple(1309, 1228, 1));
		game.herbs.add(new IntTriple(1341, 1260, 1));
		game.herbs.add(new IntTriple(1373, 1260, 1));
		game.herbs.add(new IntTriple(1405, 1260, 1));
		game.herbs.add(new IntTriple(1437, 1260, 1));
		game.herbs.add(new IntTriple(1469, 1260, 1));
		game.herbs.add(new IntTriple(1501, 1260, 1));
		game.herbs.add(new IntTriple(1469, 1292, 1));
		game.herbs.add(new IntTriple(1437, 1292, 1));
		game.herbs.add(new IntTriple(1405, 1292, 1));
		game.herbs.add(new IntTriple(1373, 1292, 1));
		game.herbs.add(new IntTriple(1437, 1324, 1));
		
		//***************************************************
		// Herbs 2
		
		game.herbs.add(new IntTriple(1469, 1068, 2));
		game.herbs.add(new IntTriple(1501, 1068, 2));
		game.herbs.add(new IntTriple(1533, 1036, 2));
		game.herbs.add(new IntTriple(1501, 1036, 2));
		game.herbs.add(new IntTriple(1469, 1036, 2));
		game.herbs.add(new IntTriple(1437, 1036, 2));
		game.herbs.add(new IntTriple(1437, 1004, 2));
		game.herbs.add(new IntTriple(1469, 1004, 2));
		game.herbs.add(new IntTriple(1501, 1004, 2));
		game.herbs.add(new IntTriple(1533, 1004, 2));
		game.herbs.add(new IntTriple(1501, 972, 2));
		game.herbs.add(new IntTriple(1469, 972, 2));
		game.herbs.add(new IntTriple(1437, 972, 2));
		game.herbs.add(new IntTriple(1405, 972, 2));
		game.herbs.add(new IntTriple(1373, 972, 2));
		game.herbs.add(new IntTriple(1341, 940, 2));
		game.herbs.add(new IntTriple(1373, 940, 2));
		game.herbs.add(new IntTriple(1405, 940, 2));
		game.herbs.add(new IntTriple(1437, 940, 2));
		game.herbs.add(new IntTriple(1469, 940, 2));
		game.herbs.add(new IntTriple(1501, 940, 2));
		game.herbs.add(new IntTriple(1469, 908, 2));
		game.herbs.add(new IntTriple(1437, 908, 2));
		game.herbs.add(new IntTriple(1405, 908, 2));
		game.herbs.add(new IntTriple(1373, 908, 2));
		game.herbs.add(new IntTriple(1341, 908, 2));
		game.herbs.add(new IntTriple(1405, 876, 2));
		
		game.herbs.add(new IntTriple(1245, 748, 2));
		game.herbs.add(new IntTriple(1245, 780, 2));
		game.herbs.add(new IntTriple(1245, 812, 2));
		game.herbs.add(new IntTriple(1245, 844, 2));
		game.herbs.add(new IntTriple(1213, 876, 2));
		game.herbs.add(new IntTriple(1213, 844, 2));
		game.herbs.add(new IntTriple(1213, 812, 2));
		game.herbs.add(new IntTriple(1213, 780, 2));
		game.herbs.add(new IntTriple(1213, 748, 2));
		game.herbs.add(new IntTriple(1213, 716, 2));
		game.herbs.add(new IntTriple(1181, 684, 2));
		game.herbs.add(new IntTriple(1181, 716, 2));
		game.herbs.add(new IntTriple(1181, 748, 2));
		game.herbs.add(new IntTriple(1181, 780, 2));
		game.herbs.add(new IntTriple(1181, 812, 2));
		game.herbs.add(new IntTriple(1181, 844, 2));
		game.herbs.add(new IntTriple(1181, 876, 2));
		game.herbs.add(new IntTriple(1149, 908, 2));
		game.herbs.add(new IntTriple(1149, 876, 2));
		game.herbs.add(new IntTriple(1149, 844, 2));
		game.herbs.add(new IntTriple(1149, 812, 2));
		game.herbs.add(new IntTriple(1149, 780, 2));
		game.herbs.add(new IntTriple(1149, 748, 2));
		game.herbs.add(new IntTriple(1149, 716, 2));
		game.herbs.add(new IntTriple(1149, 684, 2));
		game.herbs.add(new IntTriple(1117, 716, 2));
		game.herbs.add(new IntTriple(1117, 748, 2));
		game.herbs.add(new IntTriple(1117, 780, 2));
		game.herbs.add(new IntTriple(1117, 812, 2));
		game.herbs.add(new IntTriple(1117, 844, 2));
		game.herbs.add(new IntTriple(1117, 876, 2));
		game.herbs.add(new IntTriple(1117, 908, 2));
		game.herbs.add(new IntTriple(1085, 940, 2));
		game.herbs.add(new IntTriple(1085, 908, 2));
		game.herbs.add(new IntTriple(1085, 876, 2));
		game.herbs.add(new IntTriple(1085, 844, 2));
		game.herbs.add(new IntTriple(1085, 812, 2));
		game.herbs.add(new IntTriple(1085, 780, 2));
		game.herbs.add(new IntTriple(1053, 812, 2));
		game.herbs.add(new IntTriple(1053, 844, 2));
		game.herbs.add(new IntTriple(1053, 876, 2));
		game.herbs.add(new IntTriple(1053, 908, 2));
		game.herbs.add(new IntTriple(1021, 876, 2));
		game.herbs.add(new IntTriple(1021, 844, 2));
		
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
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toIntertown1) || game.deplacement.getLookingTile().equals(toTown2)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toIntertown1) || game.deplacement.getLookingTile().equals(toTown2))
					 Sounds.playSound(Const.soundEnterHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toIntertown1)){
					 new TransitionSimple(game, game.gamePanel, new Intertown1(game, 662, 267, Direction.DOWN, -250, 48));
				 }
				 else if(game.deplacement.getLookingTile().equals(toTown2)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, false, 343, 428, Direction.UP, -3, -138));
				 }
				 return true;
			}
		}
		return false;
	}
	
}
