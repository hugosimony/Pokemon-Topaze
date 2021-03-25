package fr.hugosimony.pokemontopaze;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class Const {

	//****************************************************************************************************
	// Paths
	
	public static final String gameFolderPath = Paths.get("Files").toString();
	public static final String settingsPath = Paths.get("Files/options.txt").toString();
	
	public static final String savesFolder = Paths.get("Files/Saves").toString();
	public static String getSaveFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save).toString();
	}
	private static final String adventureFolder = Paths.get("/Adventure").toString();
	private static final String bagFolder = Paths.get("/Adventure/Bag").toString();
	private static final String groundItems = Paths.get("/Adventure/groundItems.txt").toString();
	private static final String trainers = Paths.get("/Adventure/trainers.txt").toString();
	private static final String adventureInfos = Paths.get("/Adventure/infos.txt").toString();
	private static final String PCFolder = Paths.get("/PC").toString();
	private static final String teamFolder = Paths.get("/Team").toString();
	public static String getAdventureFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + adventureFolder).toString();
	}
	public static String getBagFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + bagFolder).toString();
	}
	public static String getGroundItemsPath(int save) {
		return Paths.get(savesFolder + "/" + save + groundItems).toString();
	}
	public static String getTrainersPath(int save) {
		return Paths.get(savesFolder + "/" + save + trainers).toString();
	}
	public static String getAdventureInfosPath(int save) {
		return Paths.get(savesFolder + "/" + save + adventureInfos).toString();
	}
	public static String getPCFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + PCFolder).toString();
	}
	public static String getPCBoxFolderPath(int save, int box) {
		return Paths.get(savesFolder + "/" + save + PCFolder + "/" + box).toString();
	}
	public static String getTeamFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + teamFolder).toString();
	}
	
	//****************************************************************************************************
	// Icons
	
	private static final URL mainIconUrl = Main.class.getResource("icons/mainIcon.jpg");
	public static final ImageIcon mainIcon = new ImageIcon(mainIconUrl);
	
	//****************************************************************************************************
	// Menus
	
	public static final ImageIcon mainMenu = new ImageIcon(Main.class.getResource("menus/images/mainMenu.jpg"));
	public static final ImageIcon mainMenuBis = new ImageIcon(Main.class.getResource("menus/images/mainMenuBis.jpg"));
	public static final ImageIcon profChenIntro = new ImageIcon(Main.class.getResource("intro/images/profChenIntro.jpg"));
	public static final ImageIcon boyChoice = new ImageIcon(Main.class.getResource("intro/images/choixGarçon.gif"));
	public static final ImageIcon girlChoice = new ImageIcon(Main.class.getResource("intro/images/choixFille.gif"));
	public static final ImageIcon XMenu = new ImageIcon(Main.class.getResource("menus/images/XMenu.gif"));
	public static final ImageIcon XMenuSelection = new ImageIcon(Main.class.getResource("menus/images/XMenuSelection.gif"));
	public static final ImageIcon saveMenu = new ImageIcon(Main.class.getResource("menus/images/saveMenu.gif"));
	public static final ImageIcon textZone = new ImageIcon(Main.class.getResource("menus/images/textZone.jpg"));
	public static final ImageIcon yesNo1 = new ImageIcon(Main.class.getResource("menus/images/yesNo1.gif"));
	public static final ImageIcon yesNo2 = new ImageIcon(Main.class.getResource("menus/images/yesNo2.gif"));
	
	//****************************************************************************************************
	// Transitions
	
	public static final ImageIcon transtionSimple1 = new ImageIcon(Main.class.getResource("transitions/images/transitionSimple1.gif"));
	public static final ImageIcon transtionSimple2 = new ImageIcon(Main.class.getResource("transitions/images/transitionSimple2.gif"));
	public static final ImageIcon transtionSimple3 = new ImageIcon(Main.class.getResource("transitions/images/transitionSimple3.gif"));
	public static final ImageIcon transtionSimple4 = new ImageIcon(Main.class.getResource("transitions/images/transitionSimple4.gif"));
	public static final ImageIcon transtionSimple5 = new ImageIcon(Main.class.getResource("transitions/images/transitionSimple5.gif"));
	
	//****************************************************************************************************
	// Sprites Ground Items

	public static final ImageIcon groundPokeBall = new ImageIcon(Main.class.getResource("sprites/grounditems/pokeball.gif"));
	
	//****************************************************************************************************
	// Sprites Perso Reactions
	
	public static final ImageIcon exclamationMark = new ImageIcon(Main.class.getResource("sprites/perso/react/exclamationMark.gif"));
	
	//****************************************************************************************************
	// Badges
	
	public static final ImageIcon badge1 = new ImageIcon(Main.class.getResource("menus/images/badges/badge1.gif"));
	public static final ImageIcon badge2 = new ImageIcon(Main.class.getResource("menus/images/badges/badge2.gif"));
	public static final ImageIcon badge3 = new ImageIcon(Main.class.getResource("menus/images/badges/badge3.gif"));
	public static final ImageIcon badge4 = new ImageIcon(Main.class.getResource("menus/images/badges/badge4.gif"));
	public static final ImageIcon badge5 = new ImageIcon(Main.class.getResource("menus/images/badges/badge5.gif"));
	public static final ImageIcon badge6 = new ImageIcon(Main.class.getResource("menus/images/badges/badge6.gif"));
	public static final ImageIcon badge7 = new ImageIcon(Main.class.getResource("menus/images/badges/badge7.gif"));
	public static final ImageIcon badge8 = new ImageIcon(Main.class.getResource("menus/images/badges/badge8.gif"));
	
	//****************************************************************************************************
	// Main Map
	
	public static final ImageIcon mainMap = new ImageIcon(Main.class.getResource("maps/MainMap.png"));
	
	//****************************************************************************************************
	// Musics
	
	public static final URL themeMainMenu = Main.class.getResource("musics/menu/mainMenuTheme.wav");
	public static final URL themeStarting = Main.class.getResource("musics/menu/startingTheme.wav");
	public static final URL themeSelenia = Main.class.getResource("musics/towns/seleniaTheme.wav");
	public static final URL themeVillaube = Main.class.getResource("musics/towns/villaubeTheme.wav");
	public static final URL themeRoad01 = Main.class.getResource("musics/roads/road01Theme.wav");
	public static final URL themeRivalEncounter = Main.class.getResource("musics/animations/rivalEncounter.wav");
	public static final URL themePokemonCenter = Main.class.getResource("musics/houses/special/themePokemonCenter.wav");
	public static final URL themeMart = Main.class.getResource("musics/houses/special/themeMart.wav");
	
	//****************************************************************************************************
	// Sounds
	
	public static final URL soundOpenMenu = Main.class.getResource("sounds/menus/soundOpenMenu.wav");
	public static final URL soundSelectionMenu = Main.class.getResource("sounds/menus/soundSelectionMenu.wav");
	public static final URL soundSave = Main.class.getResource("sounds/menus/soundSave.wav");
	public static final URL soundEnterHouse = Main.class.getResource("sounds/maps/soundEnterHouse.wav");
	public static final URL soundLeaveHouse = Main.class.getResource("sounds/maps/soundLeaveHouse.wav");
	public static final URL soundPlayerStopped = Main.class.getResource("sounds/maps/soundPlayerStopped.wav");
	public static final URL soundPlayerJump = Main.class.getResource("sounds/maps/soundPlayerJump.wav");
	public static final URL soundOverHerbs = Main.class.getResource("sounds/maps/soundOverHerbs.wav");
	public static final URL soundItemGet = Main.class.getResource("sounds/maps/soundItemGet.wav");
	public static final URL soundExclamation = Main.class.getResource("sounds/maps/soundExclamation.wav");
	
	public static final URL soundEvolutionDone = Main.class.getResource("sounds/pokemon/soundEvolutionDone.wav");
	
	//****************************************************************************************************
	// Colors
	
	public static final Color gameSelectorMenuColor = new Color(63, 72, 204);
	public static final Color gameSelectorMenuGameColor = new Color(63, 72, 230);
	public static final Color gameSelectorMenuSelectedGameColor = new Color(63, 150, 204);
	public static final Color placeSaveColor = new Color(255, 0, 0);
	
	//****************************************************************************************************
	// Fonts

	public static Font placeSaveFont = new Font("Comic Sans MS", Font.ITALIC, 25);
	
}
