package fr.hugosimony.pokemoncancer.files.adventure;

import java.util.ArrayList;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.files.FileCreator;
import fr.hugosimony.pokemoncancer.files.FileReaderWriter;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.Places;

public class FileAdventureReaderWriter {

	//****************************************************************************************************
	
	public static long getAdventureTime(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Long.parseLong(lines.get(0));
	}
	
	public static void setAdventureTime(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(0, Variables.TIMER_Global + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************

	public static int getPersoSpeed(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(1));
	}
	
	public static void setPersoSpeed(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(1, Variables.SPEED_PERSO + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}

	//****************************************************************************************************
	
	public static Places getPositionPlace(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Places.getGoodPlace(lines.get(2));
	}
	
	public static void setPositionPlace(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(2, Places.getGoodName(Variables.POSITION_Place) + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getPrecisePositionPlace(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(3));
	}
	
	public static void setPrecisePositionPlace(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(3, game.map.map + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static Direction getDirection(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Direction.getGoodDirection(lines.get(4));
	}
	
	public static void setDirection(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(4, game.deplacement.direction + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getLocationX(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(5));
	}
	
	public static void setLocationX(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(5, game.deplacement.locationX + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getLocationY(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(6));
	}
	
	public static void setLocationY(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(6, game.deplacement.locationY + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getMapLocationX(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(7));
	}
	
	public static void setMapLocationX(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(7, game.deplacement.mapLocationX + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getMapLocationY(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(8));
	}
	
	public static void setMapLocationY(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(8, game.deplacement.mapLocationY + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getMapFloor(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(9));
	}
	
	public static void setMapFloor(Game game, int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(9, game.map.floor + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getNumberOfBadges(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(10));
	}

	public static void setNumberOfBadges(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(10, Variables.BADGES_NumberOfBadges + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static int getPokedexNumberOfSeen(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return Integer.parseInt(lines.get(11));
	}

	public static void setPokedexNumberOfSeen(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(11, Variables.POKEDEX_NumberOfSeen + "");
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static String getName(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return lines.get(12);
	}

	public static void setName(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(12, Variables.PERSO_Name);
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
	public static String getSex(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		return lines.get(13);
	}

	public static void setSex(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getAdventureInfosPath(save));
		lines.set(13, Variables.PERSO_Sex);
		FileCreator.createAdventureInfosFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getAdventureInfosPath(save));
	}
	
	//****************************************************************************************************
	
}
