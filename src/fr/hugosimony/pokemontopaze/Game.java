package fr.hugosimony.pokemontopaze;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.files.FileReaderWriter;
import fr.hugosimony.pokemontopaze.files.adventure.FileAdventureReaderWriter;
import fr.hugosimony.pokemontopaze.files.adventure.FileGroundItemsReaderWriter;
import fr.hugosimony.pokemontopaze.intro.PresentationProf;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Map;
import fr.hugosimony.pokemontopaze.maps.Places;
import fr.hugosimony.pokemontopaze.maps.houses.selenia.MyHouse;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.roads.Road01;
import fr.hugosimony.pokemontopaze.maps.towns.Selenia;
import fr.hugosimony.pokemontopaze.maps.towns.Villaube;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown01;
import fr.hugosimony.pokemontopaze.maps.towns.intertowns.Intertown02;
import fr.hugosimony.pokemontopaze.menus.SaveMenu;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.menus.XMenu;
import fr.hugosimony.pokemontopaze.menus.YesNo;
import fr.hugosimony.pokemontopaze.pokemon.battle.Battle;
import fr.hugosimony.pokemontopaze.timer.GlobalTimer;
import fr.hugosimony.pokemontopaze.utils.IntTriple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Map map;
	
	private Game game;
	public JPanel gamePanel;
	public JPanel actualPanel;
	private int save;
	private boolean newGame;
	
	private boolean disposed;
	
	public Deplacement deplacement;
	public boolean firstMove;
	public ArrayList<IntTuple> walls = new ArrayList<IntTuple>();
	public ArrayList<IntTriple> jumpWalls = new ArrayList<IntTriple>();
	public ArrayList<IntTuple> clickableTiles = new ArrayList<IntTuple>();
	public ArrayList<Pnj> pnjs = new ArrayList<Pnj>();
	public ArrayList<IntTriple> herbs = new ArrayList<IntTriple>();
	
	public Settings settings;
	
	public Timer timer;
	
	public boolean inXMenu;
	
	public boolean inSaveMenu;
	public boolean waitingSave;
	public boolean waitingSaveDone;
	
	public TextZone textZone;
	public boolean inTextMenu;
	public boolean textWaiting;
	public boolean textDone;
	
	public boolean inYesNoMenu;
	
	public boolean inAnimation;
	public boolean inTransition;
	
	public boolean inBattle;
	
	public PresentationProf speachPanel;
	
	public Battle battle;
	
	// List of the maps
	
	public MyHouse myHouse;
	public Selenia selenia;
	public Intertown01 intertown01;
	public Road01 road01;
	public Intertown02 intertown02;
	public Villaube villaube;
	
	public Game(boolean newGame, int save) {
	
		this.save = save;
		this.newGame = newGame;
		
		game = this;
		disposed = false;
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setLocation(0, 0);
		gamePanel.setSize(800,600);
		gamePanel.setVisible(true);
		gamePanel.setOpaque(false);
		gamePanel.setLayout(null);
		gamePanel.setBackground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		add(gamePanel);
		
		settings = new Settings();
		settings.setVisible(false);
		settings.dispose();
		
		actualPanel = gamePanel;
		
		firstMove = false;
		
		inXMenu = false;
		XMenu.game = this;
		
		inSaveMenu = false;
		waitingSave = false;
		waitingSaveDone = false;
		SaveMenu.game = this;
		
		inTextMenu = false;
		textWaiting = false;
		textDone = false;
		TextZone.game = this;
		
		inYesNoMenu = false;
		YesNo.game = this;
		
		inAnimation = false;
		inTransition = false;
		
		inBattle = false;
		
		//****************************************************************************************************
		// Load Variables
		if(newGame)
			initializeNewVariables();
		else
			loadVariables();

		//****************************************************************************************************
		// Start Global Timer
		timer = new Timer();
		timer.schedule(new GlobalTimer(), 60000, 60000);
		
		//****************************************************************************************************
		// Frame Settings
		
		setTitle("Pokémon Topaze");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Const.mainIcon.getImage());
		setDefaultCloseOperation(2);
		addWindowListener(new WindowAdapter() {
	    	public void windowClosed(WindowEvent e) {
	    		if(!disposed) {
	    			System.exit(0);
	    		}
	    	}
		});
		
		//****************************************************************************************************
		// BackGround
		
		if(newGame) {
			speachPanel = new PresentationProf(this);
			add(speachPanel);
		}
		else {
			if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 1) {
				myHouse = new MyHouse(this, (FileAdventureReaderWriter.getMapFloor(save) == 1), FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(myHouse);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 2) {
				selenia = new Selenia(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(selenia);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 3) {
				intertown01 = new Intertown01(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(intertown01);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 4) {
				road01 = new Road01(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(road01);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 5) {
				intertown02 = new Intertown02(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(intertown02);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 6) {
				villaube = new Villaube(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(villaube);
			}
		}
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new MyDispatcher());
	}
	
	private void initializeNewVariables() {
		Variables.TIMER_Global = 0;
		Variables.SPEED_PERSO = 5;
		Variables.POSITION_Place = Places.SELENIA;
		Variables.BADGES_NumberOfBadges = 0;
		Variables.POKEDEX_NumberOfSeen = 0;
		Variables.ADVENTURE_Step = 0;
		Variables.STARTER = 0;
		
		FileGroundItemsReaderWriter.initializeGroundItems();
	}
	
	private void loadVariables() {
		Variables.TIMER_Global = FileAdventureReaderWriter.getAdventureTime(save);
		Variables.SPEED_PERSO = FileAdventureReaderWriter.getPersoSpeed(save);
		Variables.POSITION_Place = FileAdventureReaderWriter.getPositionPlace(save);
		Variables.BADGES_NumberOfBadges = FileAdventureReaderWriter.getNumberOfBadges(save);
		Variables.POKEDEX_NumberOfSeen = FileAdventureReaderWriter.getPokedexNumberOfSeen(save);
		Variables.PERSO_Name = FileAdventureReaderWriter.getName(save);
		Variables.PERSO_Sex = FileAdventureReaderWriter.getSex(save);
		Variables.LANG_Feminin = Variables.PERSO_Sex.equals("boy") ? "" : "e";
		Variables.ADVENTURE_Step = FileAdventureReaderWriter.getAdventureStep(save);
		Variables.STARTER = FileAdventureReaderWriter.getStarter(save);
		
		FileGroundItemsReaderWriter.loadGroundItems(save);
	}
	
	public void save() {
		if(newGame) 
			FileReaderWriter.createSave(save);
		
		FileAdventureReaderWriter.setAdventureTime(save);
		FileAdventureReaderWriter.setPersoSpeed(save);
		FileAdventureReaderWriter.setPositionPlace(save);
		FileAdventureReaderWriter.setPrecisePositionPlace(game, save);
		FileAdventureReaderWriter.setDirection(game, save);
		FileAdventureReaderWriter.setLocationX(game, save);
		FileAdventureReaderWriter.setLocationY(game, save);
		FileAdventureReaderWriter.setMapLocationX(game, save);
		FileAdventureReaderWriter.setMapLocationY(game, save);
		FileAdventureReaderWriter.setMapFloor(game, save);
		FileAdventureReaderWriter.setNumberOfBadges(save);
		FileAdventureReaderWriter.setPokedexNumberOfSeen(save);
		FileAdventureReaderWriter.setName(save);
		FileAdventureReaderWriter.setSex(save);
		FileAdventureReaderWriter.setAdventureStep(save);
		FileAdventureReaderWriter.setStarter(save);
		
		FileGroundItemsReaderWriter.saveGroundItems(save);
		
		waitingSaveDone = true;
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
		
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	
        	if(!Main.settingsOn && isVisible() && actualPanel.isVisible() && !inTextMenu && actualPanel != gamePanel) {
        		if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released) {
        			int keyCode = event.getKeyCode();
        			if((keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_Options)) {
                		Main.settingsOn = true;
                		settings = new Settings();
                		settings.setVisible(true);
        			}
        		}
        	}
        	else if(!Main.settingsOn && isVisible() && actualPanel.isVisible() && actualPanel == gamePanel && !speachPanel.validateName.isVisible()) {
        		if(event.getID() == KeyEvent.KEY_PRESSED) {
        			int keyCode = event.getKeyCode();
        			if((keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_Options)) {
                		Main.settingsOn = true;
                		settings = new Settings();
                		settings.setVisible(true);
        			}
        		}
        	}
        	else if(isVisible() && Main.settingsOn && event.getID() == KeyEvent.KEY_PRESSED && !(speachPanel != null && speachPanel.validateName.isVisible()) &&
        			(event.getKeyCode() == KeyEvent.VK_ESCAPE || event.getKeyCode() == Variables.CONTROLS_Options)) {
				Main.settingsOn = false;
				game.settings.dispose();
        	}
        	return false;
        }
	}
	
}
