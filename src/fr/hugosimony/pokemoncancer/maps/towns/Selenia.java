package fr.hugosimony.pokemoncancer.maps.towns;

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
import fr.hugosimony.pokemoncancer.maps.houses.MyHouse;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class Selenia extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	private Clip clipSeleniaTheme;
	
	private IntTuple toMyHouse;
	private IntTuple toLeaveTown;

	private Pnj police001;
	
	public Selenia(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.selenia = this;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toMyHouse = new IntTuple(982, 646);
		toLeaveTown = new IntTuple(1750, 742);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Const.themeSelenia);
			clipSeleniaTheme = AudioSystem.getClip();
			clipSeleniaTheme.open(audioInput);
			Main.actualClip = clipSeleniaTheme;
			Main.refreshVolume();
			clipSeleniaTheme.start();
			clipSeleniaTheme.loop(Clip.LOOP_CONTINUOUSLY);
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
		
		game.map = new Map(2, 0);
		game.map.setLocation(mapLocationX, mapLocationY);
		game.map.setSize(10000,10000);
		
		add(game.map);
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction);
		
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		game.clickableTiles.add(new IntTuple(1078, 678)); // LETTER BOX 1
		game.clickableTiles.add(new IntTuple(1174, 678)); // LETTER BOX 2
		game.clickableTiles.add(new IntTuple(1142, 774)); // SIGN
		game.clickableTiles.add(new IntTuple(1078, 646)); // POT
		game.clickableTiles.add(new IntTuple(758, 742)); // ROCK HIDDEN OBJECT
		game.clickableTiles.add(new IntTuple(1270, 678)); // HOUSE LOCKED 1 
		game.clickableTiles.add(new IntTuple(1238, 966)); // HOUSE LOCKED 2
		game.clickableTiles.add(new IntTuple(982, 966)); // HOUSE LOCKED 3
		
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		game.walls.add(new IntTuple(982, 550));
		game.walls.add(new IntTuple(950, 550));
		game.walls.add(new IntTuple(918, 550));
		game.walls.add(new IntTuple(886, 550));
		game.walls.add(new IntTuple(854, 550));
		game.walls.add(new IntTuple(822, 550));
		game.walls.add(new IntTuple(790, 582));
		game.walls.add(new IntTuple(790, 614));
		game.walls.add(new IntTuple(758, 614));
		game.walls.add(new IntTuple(726, 646));
		game.walls.add(new IntTuple(726, 678));
		game.walls.add(new IntTuple(726, 710));
		game.walls.add(new IntTuple(726, 742));
		game.walls.add(new IntTuple(726, 774));
		game.walls.add(new IntTuple(726, 806));
		game.walls.add(new IntTuple(726, 838));
		game.walls.add(new IntTuple(726, 870));
		game.walls.add(new IntTuple(726, 902));
		game.walls.add(new IntTuple(726, 934));
		game.walls.add(new IntTuple(694, 934));
		game.walls.add(new IntTuple(662, 966));
		game.walls.add(new IntTuple(662, 998));
		game.walls.add(new IntTuple(630, 998));
		game.walls.add(new IntTuple(630, 966));
		game.walls.add(new IntTuple(630, 934));
		game.walls.add(new IntTuple(598, 934));
		game.walls.add(new IntTuple(566, 934));
		game.walls.add(new IntTuple(534, 934));
		game.walls.add(new IntTuple(534, 966));
		game.walls.add(new IntTuple(534, 998));
		game.walls.add(new IntTuple(534, 1030));
		game.walls.add(new IntTuple(534, 1062));
		game.walls.add(new IntTuple(566, 1062));
		game.walls.add(new IntTuple(598, 1062));
		game.walls.add(new IntTuple(630, 1062));
		game.walls.add(new IntTuple(662, 1062));
		game.walls.add(new IntTuple(694, 1062));
		game.walls.add(new IntTuple(726, 1062));
		game.walls.add(new IntTuple(758, 1062));
		game.walls.add(new IntTuple(790, 1062));
		game.walls.add(new IntTuple(822, 1062));
		game.walls.add(new IntTuple(854, 1062));
		game.walls.add(new IntTuple(886, 1062));
		game.walls.add(new IntTuple(918, 1062));
		game.walls.add(new IntTuple(950, 1062));
		game.walls.add(new IntTuple(982, 1062));
		game.walls.add(new IntTuple(1014, 1062));
		game.walls.add(new IntTuple(1046, 1062));
		game.walls.add(new IntTuple(1078, 1062));
		game.walls.add(new IntTuple(1110, 1062));
		game.walls.add(new IntTuple(1142, 1062));
		game.walls.add(new IntTuple(1174, 1062));
		game.walls.add(new IntTuple(1206, 1062));
		game.walls.add(new IntTuple(1238, 1062));
		game.walls.add(new IntTuple(1270, 1062));
		game.walls.add(new IntTuple(1302, 1062));
		game.walls.add(new IntTuple(1334, 1062));
		game.walls.add(new IntTuple(1366, 1062));
		game.walls.add(new IntTuple(1398, 1062));
		game.walls.add(new IntTuple(1430, 1062));
		game.walls.add(new IntTuple(1462, 1062));
		game.walls.add(new IntTuple(1494, 1062));
		game.walls.add(new IntTuple(1526, 1062));
		game.walls.add(new IntTuple(1526, 1030));
		game.walls.add(new IntTuple(1526, 998));
		game.walls.add(new IntTuple(1558, 998));
		game.walls.add(new IntTuple(1558, 966));
		game.walls.add(new IntTuple(1590, 966));
		game.walls.add(new IntTuple(1590, 934));
		game.walls.add(new IntTuple(1590, 902));
		game.walls.add(new IntTuple(1590, 870));
		game.walls.add(new IntTuple(1622, 870));
		game.walls.add(new IntTuple(1654, 870));
		game.walls.add(new IntTuple(1686, 870));
		game.walls.add(new IntTuple(1718, 870));
		game.walls.add(new IntTuple(1750, 870));
		game.walls.add(new IntTuple(1782, 870));
		game.walls.add(new IntTuple(1814, 870));
		game.walls.add(new IntTuple(1846, 870));
		game.walls.add(new IntTuple(1846, 838));
		game.walls.add(new IntTuple(1846, 806));
		game.walls.add(new IntTuple(1846, 774));
		game.walls.add(new IntTuple(1814, 774));
		game.walls.add(new IntTuple(1782, 774));
		game.walls.add(new IntTuple(1718, 774));
		game.walls.add(new IntTuple(1686, 774));
		game.walls.add(new IntTuple(1654, 774));
		game.walls.add(new IntTuple(1622, 774));
		game.walls.add(new IntTuple(1590, 774));
		game.walls.add(new IntTuple(1558, 774));
		game.walls.add(new IntTuple(1526, 774));
		game.walls.add(new IntTuple(1494, 774));
		game.walls.add(new IntTuple(1462, 774));
		game.walls.add(new IntTuple(1462, 742));
		game.walls.add(new IntTuple(1462, 710));
		game.walls.add(new IntTuple(1462, 678));
		game.walls.add(new IntTuple(1462, 646));
		game.walls.add(new IntTuple(1430, 614));
		game.walls.add(new IntTuple(1398, 614));
		game.walls.add(new IntTuple(1398, 582));
		game.walls.add(new IntTuple(1366, 550));
		game.walls.add(new IntTuple(1334, 550));
		game.walls.add(new IntTuple(1302, 550));
		game.walls.add(new IntTuple(1270, 550));
		game.walls.add(new IntTuple(1238, 550));
		game.walls.add(new IntTuple(1206, 550));
		game.walls.add(new IntTuple(1174, 550));
		game.walls.add(new IntTuple(1174, 582));
		game.walls.add(new IntTuple(1142, 550));
		game.walls.add(new IntTuple(1110, 582));
		game.walls.add(new IntTuple(1078, 582));
		game.walls.add(new IntTuple(1078, 550));
		game.walls.add(new IntTuple(1046, 550));
		game.walls.add(new IntTuple(1014, 550));
		game.walls.add(new IntTuple(694, 966));
		game.walls.add(new IntTuple(694, 998));
		game.walls.add(new IntTuple(822, 934));
		game.walls.add(new IntTuple(854, 934));
		game.walls.add(new IntTuple(950, 966));
		game.walls.add(new IntTuple(950, 934));
		game.walls.add(new IntTuple(950, 902));
		game.walls.add(new IntTuple(982, 902));
		game.walls.add(new IntTuple(1014, 902));
		game.walls.add(new IntTuple(1046, 902));
		game.walls.add(new IntTuple(1046, 934));
		game.walls.add(new IntTuple(1046, 966));
		game.walls.add(new IntTuple(1014, 966));
		game.walls.add(new IntTuple(1206, 966));
		game.walls.add(new IntTuple(1206, 934));
		game.walls.add(new IntTuple(1206, 902));
		game.walls.add(new IntTuple(1238, 902));
		game.walls.add(new IntTuple(1270, 902));
		game.walls.add(new IntTuple(1302, 902));
		game.walls.add(new IntTuple(1302, 934));
		game.walls.add(new IntTuple(1302, 966));
		game.walls.add(new IntTuple(1270, 966));
		game.walls.add(new IntTuple(1462, 966));
		game.walls.add(new IntTuple(1462, 934));
		game.walls.add(new IntTuple(1494, 934));
		game.walls.add(new IntTuple(1526, 934));
		game.walls.add(new IntTuple(1526, 966));
		game.walls.add(new IntTuple(1558, 966));
		game.walls.add(new IntTuple(1494, 998));
		game.walls.add(new IntTuple(1398, 742));
		game.walls.add(new IntTuple(1366, 742));
		game.walls.add(new IntTuple(1142, 774));
		game.walls.add(new IntTuple(758, 742));
		game.walls.add(new IntTuple(758, 838));
		game.walls.add(new IntTuple(950, 678));
		game.walls.add(new IntTuple(918, 678));
		game.walls.add(new IntTuple(918, 646));
		game.walls.add(new IntTuple(918, 614));
		game.walls.add(new IntTuple(918, 582));
		game.walls.add(new IntTuple(1046, 582));
		game.walls.add(new IntTuple(1046, 614));
		game.walls.add(new IntTuple(1046, 646));
		game.walls.add(new IntTuple(1046, 678));
		game.walls.add(new IntTuple(1014, 678));
		game.walls.add(new IntTuple(1078, 678));
		game.walls.add(new IntTuple(1078, 646));
		game.walls.add(new IntTuple(1078, 614));
		game.walls.add(new IntTuple(1174, 614));
		game.walls.add(new IntTuple(1174, 646));
		game.walls.add(new IntTuple(1174, 678));
		game.walls.add(new IntTuple(1206, 678));
		game.walls.add(new IntTuple(1238, 678));
		game.walls.add(new IntTuple(1302, 678));
		game.walls.add(new IntTuple(1334, 678));
		game.walls.add(new IntTuple(1334, 646));
		game.walls.add(new IntTuple(1334, 614));
		game.walls.add(new IntTuple(1334, 582));
		
		// Water :
		
		game.walls.add(new IntTuple(854, 742));
		game.walls.add(new IntTuple(822, 742));
		game.walls.add(new IntTuple(790, 742));
		game.walls.add(new IntTuple(790, 774));
		game.walls.add(new IntTuple(822, 774));
		game.walls.add(new IntTuple(854, 774));
		game.walls.add(new IntTuple(886, 774));
		game.walls.add(new IntTuple(886, 806));
		game.walls.add(new IntTuple(854, 806));
		game.walls.add(new IntTuple(822, 806));
		game.walls.add(new IntTuple(790, 806));
		game.walls.add(new IntTuple(790, 838));
		game.walls.add(new IntTuple(822, 838));
		game.walls.add(new IntTuple(854, 838));
		game.walls.add(new IntTuple(886, 838));
		
		// TEMP
		
		game.walls.add(new IntTuple(1270, 678));
		game.walls.add(new IntTuple(1238, 966));
		game.walls.add(new IntTuple(982, 966));
		
	}
	
	private void setPnjs() {
		game.pnjs = new ArrayList<Pnj>();
		
		police001 = new Pnj("police001", Direction.RIGHT, 0, 662, 1030);
		police001.setLocation(662, 1030);
		police001.setSize(50,70);
		game.pnjs.add(police001);
		
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
			 text = "Chez " + Variables.PERSO_Name + ".";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
			 text = "Chez Martin.";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
			 text = "Sélénia.= Une ville calme et symbole de sérénité.";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 4 && Variables.GROUND_ITEMS_Selenia.contains(0)) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Selenia.remove(0);
			 // Ajouter une potion au sac.
			 text = "Vous avez ramassé une Potion !";
		 }
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 5 && game.deplacement.direction == Direction.UP && Variables.GROUND_ITEMS_Selenia.contains(1)) {
			 Sounds.playSound(Const.soundItemGet);
			 Variables.GROUND_ITEMS_Selenia.remove(1);
			 // Ajouter une Hyper Ball au sac.
			 text = "Vous avez ramassé une Hyper Ball !";
		 }
		 //****************************
		 // TEMP
		 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 6 || IntTuple.getPosition(game.clickableTiles, tuple) == 7 || IntTuple.getPosition(game.clickableTiles, tuple) == 8) {
			 text = "C'est fermé.";
		 }
		 //****************************
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if(game.deplacement.getLookingTile().equals(toMyHouse) || game.deplacement.getLookingTile().equals(toLeaveTown)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toMyHouse) || game.deplacement.getLookingTile().equals(toLeaveTown))
					 Sounds.playSound(Const.soundEnterHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toMyHouse)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, false, 343, 428, Direction.UP, -3, -138));
				 }
				 else if(game.deplacement.getLookingTile().equals(toLeaveTown)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, true, 375, 300, Direction.DOWN, 0, 0));
				 }
				 else {
					 
				 }
				 return true;
			}
		}
		return false;
	}
	
}
