package fr.hugosimony.pokemoncancer;

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

import fr.hugosimony.pokemoncancer.files.FileReaderWriter;
import fr.hugosimony.pokemoncancer.files.adventure.FileAdventureReaderWriter;
import fr.hugosimony.pokemoncancer.files.adventure.FileGroundItemsReaderWriter;
import fr.hugosimony.pokemoncancer.intro.PresentationProf;
import fr.hugosimony.pokemoncancer.maps.Deplacement;
import fr.hugosimony.pokemoncancer.maps.Map;
import fr.hugosimony.pokemoncancer.maps.Places;
import fr.hugosimony.pokemoncancer.maps.houses.MyHouse;
import fr.hugosimony.pokemoncancer.maps.pnj.Pnj;
import fr.hugosimony.pokemoncancer.maps.roads.Road01;
import fr.hugosimony.pokemoncancer.maps.towns.Selenia;
import fr.hugosimony.pokemoncancer.maps.towns.intertowns.Intertown1;
import fr.hugosimony.pokemoncancer.menus.SaveMenu;
import fr.hugosimony.pokemoncancer.menus.TextZone;
import fr.hugosimony.pokemoncancer.menus.XMenu;
import fr.hugosimony.pokemoncancer.menus.YesNo;
import fr.hugosimony.pokemoncancer.pokemon.Nature;
import fr.hugosimony.pokemoncancer.pokemon.PKM;
import fr.hugosimony.pokemoncancer.pokemon.Pokemon;
import fr.hugosimony.pokemoncancer.pokemon.battle.BattleConst;
import fr.hugosimony.pokemoncancer.timer.GlobalTimer;
import fr.hugosimony.pokemoncancer.utils.IntTriple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;


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
	
	public boolean inXMenu;
	
	public boolean inSaveMenu;
	public boolean waitingSave;
	public boolean waitingSaveDone;
	
	public TextZone textZone;
	public boolean inTextMenu;
	public boolean textWaiting;
	public boolean textDone;
	
	public boolean inYesNoMenu;
	
	public boolean inTransition;
	
	public boolean inBattle;
	
	public PresentationProf speachPanel;
	
	// Liste des maps
	
	public MyHouse myHouse;
	public Selenia selenia;
	public Intertown1 intertown1;
	public Road01 road01;
	
	public Game(boolean newGame, int save) {
		
		BattleConst.getAnimatedSprite(new Pokemon(PKM.HERBIZARRE, "test", Nature.ADAMANT, 2, null, 5, 0, false, 20, 20, 10, 10, 10, 10, 10, null, null, null, null, null, null, "hugo", true), false);
		
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
		Timer timer = new Timer();
		timer.schedule(new GlobalTimer(), 60000, 60000);
		
		//****************************************************************************************************
		// Frame Settings
		
		setTitle("Pokémon Cancer");
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
				intertown1 = new Intertown1(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(intertown1);
			}
			else if(FileAdventureReaderWriter.getPrecisePositionPlace(save) == 4) {
				road01 = new Road01(this, FileAdventureReaderWriter.getLocationX(save), FileAdventureReaderWriter.getLocationY(save), FileAdventureReaderWriter.getDirection(save), FileAdventureReaderWriter.getMapLocationX(save), FileAdventureReaderWriter.getMapLocationY(save));
				add(road01);
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
		if(Variables.PERSO_Sex.equals("boy")) Variables.LANG_Feminin = ""; else Variables.LANG_Feminin = "e";
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
		FileGroundItemsReaderWriter.saveGroundItems(save);
		waitingSaveDone = true;
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
		
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	
        	if(isVisible() && actualPanel.isVisible() && !Main.settingsOn && !inTextMenu && actualPanel != gamePanel) {
        		if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released) {
        			int keyCode = event.getKeyCode();
        			if((keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_Options)) {
                		Main.settingsOn = true;
                		Settings settings = new Settings();
                		settings.setVisible(true);
        			}
        		}
        	}
        	return false;
        }
	}
	
}
