package fr.hugosimony.pokemontopaze;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import fr.hugosimony.pokemontopaze.files.FileCreator;

public class Main {

	public static boolean settingsOn;
	public static URL actualClipURL;
	public static Clip actualClip;
	
	public static void main(String[] args) {
		
		//*****************************************************************
		// Game
		System.out.println("Searching game folder ...");
		if(!new File(Const.gameFolderPath).exists()) {
			System.out.println("Game folder not found, creating new one. /!\\ Clear all old files if they have existed.");
			new File(Const.gameFolderPath).mkdir();
		}else
			System.out.println("Game folder found.");
		
		//*****************************************************************
		// Settings
		System.out.println("Searching options.txt ...");
		if(!new File(Const.settingsPath).exists()) {
			System.out.println("options.txt not found, creating new one. /!\\ Clear all old options if they have existed.");
			FileCreator.createSettingsFile(true);
		}else
			System.out.println("options.txt found.");
				
		//*****************************************************************
		
		settingsOn = false;
		
		Menu menu = new Menu();
		menu.setVisible(true);
	}
	
	public static float getVolume() {
	    FloatControl gainControl = (FloatControl) actualClip.getControl(FloatControl.Type.MASTER_GAIN);        
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}

	public static void setVolume(float volume) {
	    if (volume < 0f || volume > 1f)
	        throw new IllegalArgumentException("Volume not valid: " + volume);
	    FloatControl gainControl = (FloatControl) actualClip.getControl(FloatControl.Type.MASTER_GAIN);
	    if(actualClipURL == Const.themeVillaube)
	    	gainControl.setValue(30f * (float) Math.log10(volume-0.05));
	    else if(actualClipURL == Const.themeRivalEncounter)
	    	gainControl.setValue(40f * (float) Math.log10(volume-0.05));
	    else
	    	gainControl.setValue(50f * (float) Math.log10(volume-0.05));
	}
	
	public static void refreshVolume() {
		setVolume(Variables.VOLUME_Main);
	}
	
}
