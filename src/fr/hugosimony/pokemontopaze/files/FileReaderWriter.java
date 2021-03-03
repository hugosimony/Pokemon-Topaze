package fr.hugosimony.pokemontopaze.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;

public class FileReaderWriter {
	
	public static ArrayList<String> readFile(String path) {
		BufferedReader reader = null;
		String line;
	    ArrayList<String> lines = new ArrayList<String>();

	    try {
	    	reader = new BufferedReader(new FileReader(path));
	    	line = reader.readLine();
	    	line = reader.readLine();
	    	while (line != null) {
	    		lines.add(line);
	    		line = reader.readLine();
	    	}
	  	    reader.close();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    
	    return lines;
	}
	
	public static void writeAllLine(ArrayList<String> lines, String path) {
		try {
			FileWriter writer = new FileWriter(path, true);
			for(int i = 0; i<lines.size();i++)
				writer.write("\n" + lines.get(i));
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void createSave(int save) {
		if(!new File(Const.savesFolder).exists())
			new File(Const.savesFolder).mkdir();
		new File(Const.getSaveFolderPath(save)).mkdir();
		new File(Const.getAdventureFolderPath(save)).mkdir();
		new File(Const.getBagFolderPath(save)).mkdir();
		new File(Const.getTrainersFolderPath(save)).mkdir();
		FileCreator.createAdventureInfosFile(true, save);
		FileCreator.createGroundItemsFile(true, save);
		new File(Const.getPCFolderPath(save)).mkdir();
		new File(Const.getTeamFolderPath(save)).mkdir();
	}
	
}
