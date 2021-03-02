package fr.hugosimony.pokemoncancer.files.adventure;

import java.util.ArrayList;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.files.FileCreator;
import fr.hugosimony.pokemoncancer.files.FileReaderWriter;

public class FileGroundItemsReaderWriter {

	//*********************************************************
	// Sélénia
	
	public static void loadGroundItems(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getGroundItemsPath(save));
		
		//****************************************************
		// Selenia
		ArrayList<String> items = new ArrayList<String>();
		if (lines.get(0).contains("a"))
			items.add("0");
		if (lines.get(0).contains("b"))
			items.add("1");
		Variables.GROUND_ITEMS_Selenia = items;
		
		//****************************************************
		// Road 1
		items = new ArrayList<String>();
		if(lines.get(1).contains("a"))
			items.add("0");
		Variables.GROUND_ITEMS_Road1 = items;
		
		//****************************************************
		// xxx
		items = new ArrayList<String>();
	}
	
	public static void saveGroundItems(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getGroundItemsPath(save));
		
		//****************************************************
		// Selenia
		String items = " ";
		if(Variables.GROUND_ITEMS_Selenia.contains("0"))
			items += "a";
		if(Variables.GROUND_ITEMS_Selenia.contains("1"))
			items += "b";
		lines.set(0, items);
		
		//****************************************************
		// Road 1
		items = " ";
		if(Variables.GROUND_ITEMS_Road1.contains("0"))
			items += "a";
		lines.set(1, items);
		
		//****************************************************
		// xxx
		items = " ";
		
		FileCreator.createGroundItemsFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getGroundItemsPath(save));
	}
	
	public static void initializeGroundItems() {
		//****************************************************
		// Selenia
		ArrayList<String> items = new ArrayList<String>();
		items.add("0");
		items.add("1");
		Variables.GROUND_ITEMS_Selenia = items;
		
		//****************************************************
		// Road 1
		items = new ArrayList<String>();
		items.add("0");
		Variables.GROUND_ITEMS_Road1 = items;
		
		//****************************************************
		// xxx
		items = new ArrayList<String>();
	}
	
}
