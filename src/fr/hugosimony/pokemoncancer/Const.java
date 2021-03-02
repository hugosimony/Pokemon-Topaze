package fr.hugosimony.pokemoncancer;

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
	
	private static final URL mainMenuUrl = Main.class.getResource("menus/images/mainMenu.jpg");
	public static final ImageIcon mainMenu = new ImageIcon(mainMenuUrl);
	private static final URL mainMenuBisUrl = Main.class.getResource("menus/images/mainMenuBis.jpg");
	public static final ImageIcon mainMenuBis = new ImageIcon(mainMenuBisUrl);
	private static final URL profChenIntroUrl = Main.class.getResource("intro/images/profChenIntro.jpg");
	public static final ImageIcon profChenIntro = new ImageIcon(profChenIntroUrl);
	private static final URL boyChoiceUrl = Main.class.getResource("intro/images/choixGarçon.gif");
	public static final ImageIcon boyChoice = new ImageIcon(boyChoiceUrl);
	private static final URL girlChoiceUrl = Main.class.getResource("intro/images/choixFille.gif");
	public static final ImageIcon girlChoice = new ImageIcon(girlChoiceUrl);
	private static final URL XMenuUrl = Main.class.getResource("menus/images/XMenu.gif");
	public static final ImageIcon XMenu = new ImageIcon(XMenuUrl);
	private static final URL XMenuSelectionUrl = Main.class.getResource("menus/images/XMenuSelection.gif");
	public static final ImageIcon XMenuSelection = new ImageIcon(XMenuSelectionUrl);
	private static final URL saveMenuUrl = Main.class.getResource("menus/images/saveMenu.gif");
	public static final ImageIcon saveMenu = new ImageIcon(saveMenuUrl);
	private static final URL textZoneUrl = Main.class.getResource("menus/images/textZone.jpg");
	public static final ImageIcon textZone = new ImageIcon(textZoneUrl);
	private static final URL yesNo1Url = Main.class.getResource("menus/images/yesNo1.gif");
	public static final ImageIcon yesNo1 = new ImageIcon(yesNo1Url);
	private static final URL yesNo2Url = Main.class.getResource("menus/images/yesNo2.gif");
	public static final ImageIcon yesNo2 = new ImageIcon(yesNo2Url);
	
	//****************************************************************************************************
	// Transitions
	
	private static final URL transtionSimple1Url = Main.class.getResource("transitions/images/transitionSimple1.gif");
	public static final ImageIcon transtionSimple1 = new ImageIcon(transtionSimple1Url);
	private static final URL transtionSimple2Url = Main.class.getResource("transitions/images/transitionSimple2.gif");
	public static final ImageIcon transtionSimple2 = new ImageIcon(transtionSimple2Url);
	private static final URL transtionSimple3Url = Main.class.getResource("transitions/images/transitionSimple3.gif");
	public static final ImageIcon transtionSimple3 = new ImageIcon(transtionSimple3Url);
	private static final URL transtionSimple4Url = Main.class.getResource("transitions/images/transitionSimple4.gif");
	public static final ImageIcon transtionSimple4 = new ImageIcon(transtionSimple4Url);
	private static final URL transtionSimple5Url = Main.class.getResource("transitions/images/transitionSimple5.gif");
	public static final ImageIcon transtionSimple5 = new ImageIcon(transtionSimple5Url);
	
	//****************************************************************************************************
	// Sprites Main
	
	private static final URL boyFrontUrl = Main.class.getResource("sprites/perso/main/boy/boyFront.gif");
	public static final ImageIcon boyFront = new ImageIcon(boyFrontUrl);
	private static final URL boyFrontRightUrl = Main.class.getResource("sprites/perso/main/boy/boyFrontRight.gif");
	public static final ImageIcon boyFrontRight = new ImageIcon(boyFrontRightUrl);
	private static final URL boyFrontLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyFrontLeft.gif");
	public static final ImageIcon boyFrontLeft = new ImageIcon(boyFrontLeftUrl);
	private static final URL boyRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRight.gif");
	public static final ImageIcon boyRight = new ImageIcon(boyRightUrl);
	private static final URL boyRightRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRightRight.gif");
	public static final ImageIcon boyRightRight = new ImageIcon(boyRightRightUrl);
	private static final URL boyRightLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRightLeft.gif");
	public static final ImageIcon boyRightLeft = new ImageIcon(boyRightLeftUrl);
	private static final URL boyBackUrl = Main.class.getResource("sprites/perso/main/boy/boyBack.gif");
	public static final ImageIcon boyBack = new ImageIcon(boyBackUrl);
	private static final URL boyBackRightUrl = Main.class.getResource("sprites/perso/main/boy/boyBackRight.gif");
	public static final ImageIcon boyBackRight = new ImageIcon(boyBackRightUrl);
	private static final URL boyBackLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyBackLeft.gif");
	public static final ImageIcon boyBackLeft = new ImageIcon(boyBackLeftUrl);
	private static final URL boyLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyLeft.gif");
	public static final ImageIcon boyLeft = new ImageIcon(boyLeftUrl);
	private static final URL boyLeftRightUrl = Main.class.getResource("sprites/perso/main/boy/boyLeftRight.gif");
	public static final ImageIcon boyLeftRight = new ImageIcon(boyLeftRightUrl);
	private static final URL boyLeftLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyLeftLeft.gif");
	public static final ImageIcon boyLeftLeft = new ImageIcon(boyLeftLeftUrl);
	
	private static final URL boyRunFrontUrl = Main.class.getResource("sprites/perso/main/boy/boyRunFront.gif");
	public static final ImageIcon boyRunFront = new ImageIcon(boyRunFrontUrl);
	private static final URL boyRunFrontRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRunFrontRight.gif");
	public static final ImageIcon boyRunFrontRight = new ImageIcon(boyRunFrontRightUrl);
	private static final URL boyRunFrontLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRunFrontLeft.gif");
	public static final ImageIcon boyRunFrontLeft = new ImageIcon(boyRunFrontLeftUrl);
	private static final URL boyRunRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRunRight.gif");
	public static final ImageIcon boyRunRight = new ImageIcon(boyRunRightUrl);
	private static final URL boyRunRightRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRunRightRight.gif");
	public static final ImageIcon boyRunRightRight = new ImageIcon(boyRunRightRightUrl);
	private static final URL boyRunRightLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRunRightLeft.gif");
	public static final ImageIcon boyRunRightLeft = new ImageIcon(boyRunRightLeftUrl);
	private static final URL boyRunBackUrl = Main.class.getResource("sprites/perso/main/boy/boyRunBack.gif");
	public static final ImageIcon boyRunBack = new ImageIcon(boyRunBackUrl);
	private static final URL boyRunBackRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRunBackRight.gif");
	public static final ImageIcon boyRunBackRight = new ImageIcon(boyRunBackRightUrl);
	private static final URL boyRunBackLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRunBackLeft.gif");
	public static final ImageIcon boyRunBackLeft = new ImageIcon(boyRunBackLeftUrl);
	private static final URL boyRunLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRunLeft.gif");
	public static final ImageIcon boyRunLeft = new ImageIcon(boyRunLeftUrl);
	private static final URL boyRunLeftRightUrl = Main.class.getResource("sprites/perso/main/boy/boyRunLeftRight.gif");
	public static final ImageIcon boyRunLeftRight = new ImageIcon(boyRunLeftRightUrl);
	private static final URL boyRunLeftLeftUrl = Main.class.getResource("sprites/perso/main/boy/boyRunLeftLeft.gif");
	public static final ImageIcon boyRunLeftLeft = new ImageIcon(boyRunLeftLeftUrl);
	
	//****************************************************************************************************
	// Sprites Mom
	
	private static final URL momFrontUrl = Main.class.getResource("sprites/perso/mom/momFront.gif");
	public static final ImageIcon momFront = new ImageIcon(momFrontUrl);
	private static final URL momBackUrl = Main.class.getResource("sprites/perso/mom/momBack.gif");
	public static final ImageIcon momBack = new ImageIcon(momBackUrl);
	private static final URL momLeftUrl = Main.class.getResource("sprites/perso/mom/momLeft.gif");
	public static final ImageIcon momLeft = new ImageIcon(momLeftUrl);
	private static final URL momRightUrl = Main.class.getResource("sprites/perso/mom/momRight.gif");
	public static final ImageIcon momRight = new ImageIcon(momRightUrl);
	
	//****************************************************************************************************
	// Sprites Police
	
	private static final URL policeRightUrl = Main.class.getResource("sprites/perso/police/policeRight.gif");
	public static final ImageIcon policeRight = new ImageIcon(policeRightUrl);
	
	//****************************************************************************************************
	// Badges
	
	private static final URL badge1Url = Main.class.getResource("menus/images/badges/badge1.jpg");
	public static final ImageIcon badge1 = new ImageIcon(badge1Url);
	private static final URL badge2Url = Main.class.getResource("menus/images/badges/badge2.jpg");
	public static final ImageIcon badge2 = new ImageIcon(badge2Url);
	private static final URL badge3Url = Main.class.getResource("menus/images/badges/badge3.jpg");
	public static final ImageIcon badge3 = new ImageIcon(badge3Url);
	private static final URL badge4Url = Main.class.getResource("menus/images/badges/badge4.jpg");
	public static final ImageIcon badge4 = new ImageIcon(badge4Url);
	private static final URL badge5Url = Main.class.getResource("menus/images/badges/badge5.jpg");
	public static final ImageIcon badge5 = new ImageIcon(badge5Url);
	private static final URL badge6Url = Main.class.getResource("menus/images/badges/badge6.jpg");
	public static final ImageIcon badge6 = new ImageIcon(badge6Url);
	private static final URL badge7Url = Main.class.getResource("menus/images/badges/badge7.jpg");
	public static final ImageIcon badge7 = new ImageIcon(badge7Url);
	private static final URL badge8Url = Main.class.getResource("menus/images/badges/badge8.jpg");
	public static final ImageIcon badge8 = new ImageIcon(badge8Url);
	
	//****************************************************************************************************
	// Main Map
	
	private static final URL mainMapURL = Main.class.getResource("maps/MainMap.png");
	public static final ImageIcon mainMap = new ImageIcon(mainMapURL);
	
	//****************************************************************************************************
	// Musics
	
	public static final URL themeMainMenu = Main.class.getResource("musics/mainMenuTheme.wav");
	public static final URL themeStarting = Main.class.getResource("musics/startingTheme.wav");
	public static final URL themeSelenia = Main.class.getResource("musics/towns/seleniaTheme.wav");
	public static final URL themeRoad01 = Main.class.getResource("musics/roads/road01Theme.wav");
	
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
