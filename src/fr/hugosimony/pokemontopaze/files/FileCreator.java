package fr.hugosimony.pokemontopaze.files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import fr.hugosimony.pokemontopaze.Const;
public class FileCreator {

	public static void createSettingsFile(boolean first) {
		try {
			PrintWriter writer = new PrintWriter(Const.settingsPath, "UTF-8");
			if(first)
				writer.print("Settings :\n"
						+ "0.5\n"
						+ "38\n"
						+ "40\n"
						+ "37\n"
						+ "39\n"
						+ "65\n"
						+ "66\n"
						+ "88\n"
						+ "89\n"
						+ "79\n"
						+ "40");
			else
				writer.print("Settings :");
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createAdventureInfosFile(boolean first, int save) {
		try {
			PrintWriter writer = new PrintWriter(Const.getAdventureInfosPath(save), "UTF-8");
			if(first)
				writer.print("Adventure Infos :\n"
						+ "0\n"
						+ "5\n"
						+ "Sélénia\n"
						+ "1\n"
						+ "DOWN\n"
						+ "375\n"
						+ "300\n"
						+ "0\n"
						+ "0\n"
						+ "1\n"
						+ "0\n"
						+ "0\n"
						+ "Bob\n"
						+ "boy\n"
						+ "0\n"
						+ "0");
			else
				writer.print("Settings :");
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createGroundItemsFile(boolean first, int save) {
		try {
			PrintWriter writer = new PrintWriter(Const.getGroundItemsPath(save), "UTF-8");
			if(first)
				writer.print("Ground Items :\n"
						+ "ab\n"
						+ "a"
						+ "ab");
			else
				writer.print("Settings :");
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
