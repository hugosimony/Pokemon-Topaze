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
	private static final String trainersFolder = Paths.get("/Adventure/Trainers").toString();
	private static final String groundItems = Paths.get("/Adventure/groundItems.txt").toString();
	private static final String adventureInfos = Paths.get("/Adventure/infos.txt").toString();
	private static final String PCFolder = Paths.get("/PC").toString();
	private static final String teamFolder = Paths.get("/Team").toString();
	public static String getAdventureFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + adventureFolder).toString();
	}
	public static String getBagFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + bagFolder).toString();
	}
	public static String getTrainersFolderPath(int save) {
		return Paths.get(savesFolder + "/" + save + trainersFolder).toString();
	}
	public static String getGroundItemsPath(int save) {
		return Paths.get(savesFolder + "/" + save + groundItems).toString();
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
	// Sprites Main
	
	// Boy Walking
	public static final ImageIcon boyFront = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyFront.gif"));
	public static final ImageIcon boyFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyFrontRight.gif"));
	public static final ImageIcon boyFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyFrontLeft.gif"));
	public static final ImageIcon boyRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRight.gif"));
	public static final ImageIcon boyRightRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRightRight.gif"));
	public static final ImageIcon boyRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRightLeft.gif"));
	public static final ImageIcon boyBack = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyBack.gif"));
	public static final ImageIcon boyBackRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyBackRight.gif"));
	public static final ImageIcon boyBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyBackLeft.gif"));
	public static final ImageIcon boyLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyLeft.gif"));
	public static final ImageIcon boyLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyLeftRight.gif"));
	public static final ImageIcon boyLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyLeftLeft.gif"));
	
	// Boy Running
	public static final ImageIcon boyRunFront = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunFront.gif"));
	public static final ImageIcon boyRunFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunFrontRight.gif"));
	public static final ImageIcon boyRunFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunFrontLeft.gif"));
	public static final ImageIcon boyRunRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunRight.gif"));
	public static final ImageIcon boyRunRightRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunRightRight.gif"));
	public static final ImageIcon boyRunRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunRightLeft.gif"));
	public static final ImageIcon boyRunBack = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunBack.gif"));
	public static final ImageIcon boyRunBackRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunBackRight.gif"));
	public static final ImageIcon boyRunBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunBackLeft.gif"));
	public static final ImageIcon boyRunLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunLeft.gif"));
	public static final ImageIcon boyRunLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunLeftRight.gif"));
	public static final ImageIcon boyRunLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/boy/boyRunLeftLeft.gif"));
	
	// Girl Walking
	public static final ImageIcon girlFront = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlFront.gif"));
	public static final ImageIcon girlFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlFrontRight.gif"));
	public static final ImageIcon girlFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlFrontLeft.gif"));
	public static final ImageIcon girlRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRight.gif"));
	public static final ImageIcon girlRightRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRightRight.gif"));
	public static final ImageIcon girlRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRightLeft.gif"));
	public static final ImageIcon girlBack = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlBack.gif"));
	public static final ImageIcon girlBackRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlBackRight.gif"));
	public static final ImageIcon girlBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlBackLeft.gif"));
	public static final ImageIcon girlLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlLeft.gif"));
	public static final ImageIcon girlLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlLeftRight.gif"));
	public static final ImageIcon girlLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlLeftLeft.gif"));
	
	// Girl Running
	public static final ImageIcon girlRunFront = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunFront.gif"));
	public static final ImageIcon girlRunFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunFrontRight.gif"));
	public static final ImageIcon girlRunFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunFrontLeft.gif"));
	public static final ImageIcon girlRunRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunRight.gif"));
	public static final ImageIcon girlRunRightRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunRightRight.gif"));
	public static final ImageIcon girlRunRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunRightLeft.gif"));
	public static final ImageIcon girlRunBack = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunBack.gif"));
	public static final ImageIcon girlRunBackRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunBackRight.gif"));
	public static final ImageIcon girlRunBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunBackLeft.gif"));
	public static final ImageIcon girlRunLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunLeft.gif"));
	public static final ImageIcon girlRunLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunLeftRight.gif"));
	public static final ImageIcon girlRunLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/main/girl/girlRunLeftLeft.gif"));
	
	//****************************************************************************************************
	// Sprites Mom
	
	public static final ImageIcon momFront = new ImageIcon(Main.class.getResource("sprites/perso/mom/momFront.gif"));
	public static final ImageIcon momFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/mom/momFrontRight.gif"));
	public static final ImageIcon momFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/mom/momFrontLeft.gif"));
	public static final ImageIcon momBack = new ImageIcon(Main.class.getResource("sprites/perso/mom/momBack.gif"));
	public static final ImageIcon momBackRight = new ImageIcon(Main.class.getResource("sprites/perso/mom/momBackRight.gif"));
	public static final ImageIcon momBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/mom/momBackLeft.gif"));
	public static final ImageIcon momLeft = new ImageIcon(Main.class.getResource("sprites/perso/mom/momLeft.gif"));
	public static final ImageIcon momLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/mom/momLeftRight.gif"));
	public static final ImageIcon momLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/mom/momLeftLeft.gif"));
	public static final ImageIcon momRight = new ImageIcon(Main.class.getResource("sprites/perso/mom/momRight.gif"));
	public static final ImageIcon momRightRight = new ImageIcon(Main.class.getResource("sprites/perso/mom/momRightRight.gif"));
	public static final ImageIcon momRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/mom/momRightLeft.gif"));
	
	//****************************************************************************************************
	// Sprites Prof Chen
	
	public static final ImageIcon profChenFront = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenFront.gif"));
	public static final ImageIcon profChenFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenFrontRight.gif"));
	public static final ImageIcon profChenFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenFrontLeft.gif"));
	public static final ImageIcon profChenBack = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenBack.gif"));
	public static final ImageIcon profChenBackRight = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenBackRight.gif"));
	public static final ImageIcon profChenBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenBackLeft.gif"));
	public static final ImageIcon profChenLeft = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenLeft.gif"));
	public static final ImageIcon profChenLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenLeftRight.gif"));
	public static final ImageIcon profChenLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenLeftLeft.gif"));
	public static final ImageIcon profChenRight = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenRight.gif"));
	public static final ImageIcon profChenRightRight = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenRightRight.gif"));
	public static final ImageIcon profChenRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/profchen/profchenRightLeft.gif"));
	
	//****************************************************************************************************
	// Sprites Brown Boy
	
	public static final ImageIcon brownboyFront = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyFront.gif"));
	public static final ImageIcon brownboyFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyFrontRight.gif"));
	public static final ImageIcon brownboyFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyFrontLeft.gif"));
	public static final ImageIcon brownboyBack = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyBack.gif"));
	public static final ImageIcon brownboyBackRight = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyBackRight.gif"));
	public static final ImageIcon brownboyBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyBackLeft.gif"));
	public static final ImageIcon brownboyLeft = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyLeft.gif"));
	public static final ImageIcon brownboyLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyLeftRight.gif"));
	public static final ImageIcon brownboyLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyLeftLeft.gif"));
	public static final ImageIcon brownboyRight = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyRight.gif"));
	public static final ImageIcon brownboyRightRight = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyRightRight.gif"));
	public static final ImageIcon brownboyRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/brownboy/brownboyRightLeft.gif"));
	
	//****************************************************************************************************
	// Sprites Brown Girl
	
	public static final ImageIcon browngirlFront = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlFront.gif"));
	public static final ImageIcon browngirlFrontRight = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlFrontRight.gif"));
	public static final ImageIcon browngirlFrontLeft = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlFrontLeft.gif"));
	public static final ImageIcon browngirlBack = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlBack.gif"));
	public static final ImageIcon browngirlBackRight = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlBackRight.gif"));
	public static final ImageIcon browngirlBackLeft = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlBackLeft.gif"));
	public static final ImageIcon browngirlLeft = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlLeft.gif"));
	public static final ImageIcon browngirlLeftRight = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlLeftRight.gif"));
	public static final ImageIcon browngirlLeftLeft = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlLeftLeft.gif"));
	public static final ImageIcon browngirlRight = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlRight.gif"));
	public static final ImageIcon browngirlRightRight = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlRightRight.gif"));
	public static final ImageIcon browngirlRightLeft = new ImageIcon(Main.class.getResource("sprites/perso/browngirl/browngirlRightLeft.gif"));
	
	//****************************************************************************************************
	// Sprites Police
	
	public static final ImageIcon policeRight = new ImageIcon(Main.class.getResource("sprites/perso/police/policeRight.gif"));
	
	//****************************************************************************************************
	// Sprites Seller Boy
	
	public static final ImageIcon sellerboyFront = new ImageIcon(Main.class.getResource("sprites/perso/sellerboy/sellerboyFront.gif"));
	public static final ImageIcon sellerboyBack = new ImageIcon(Main.class.getResource("sprites/perso/sellerboy/sellerboyBack.gif"));
	public static final ImageIcon sellerboyLeft = new ImageIcon(Main.class.getResource("sprites/perso/sellerboy/sellerboyLeft.gif"));
	public static final ImageIcon sellerboyRight = new ImageIcon(Main.class.getResource("sprites/perso/sellerboy/sellerboyRight.gif"));
	
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
	
	public static final URL themeMainMenu = Main.class.getResource("musics/mainMenuTheme.wav");
	public static final URL themeStarting = Main.class.getResource("musics/startingTheme.wav");
	public static final URL themeSelenia = Main.class.getResource("musics/towns/seleniaTheme.wav");
	public static final URL themeVillaube = Main.class.getResource("musics/towns/villaubeTheme.wav");
	public static final URL themeRoad01 = Main.class.getResource("musics/roads/road01Theme.wav");
	public static final URL themeRivalEncounter = Main.class.getResource("musics/animations/rivalEncounter.wav");
	
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
