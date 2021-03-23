package fr.hugosimony.pokemontopaze.files.adventure;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.files.FileCreator;
import fr.hugosimony.pokemontopaze.files.FileReaderWriter;

public class FileTrainersReaderWriter {

	public static void getTrainers(int save) {
		ArrayList<String> lines = FileReaderWriter.readFile(Const.getTrainersPath(save));
		Variables.BATTLERS = new ArrayList<String>();
		for(String line : lines)
			Variables.BATTLERS.add(line);
	}
	
	public static void setTrainers(int save) {
		ArrayList<String> lines = new ArrayList<String>();
		for(String line : Variables.BATTLERS)
			lines.add(line);
		FileCreator.createTrainersFile(false, save);
		FileReaderWriter.writeAllLine(lines, Const.getTrainersPath(save));
	}
	
	public static void initializeTrainers() {
		Variables.BATTLERS = new ArrayList<String>();
		Variables.BATTLERS.add("capboy001");
		Variables.BATTLERS.add("campinggirl001");
	}
	
}
