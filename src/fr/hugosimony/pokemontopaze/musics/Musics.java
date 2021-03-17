package fr.hugosimony.pokemontopaze.musics;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import fr.hugosimony.pokemontopaze.Main;

public class Musics {

	public static void startMusic(URL music) {
		try {
			Main.actualClip.close();
			Main.actualClipURL = music;
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
			Main.actualClip = AudioSystem.getClip();
			Main.actualClip.open(audioInput);
			Main.refreshVolume();
			Main.actualClip.start();
			Main.actualClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
